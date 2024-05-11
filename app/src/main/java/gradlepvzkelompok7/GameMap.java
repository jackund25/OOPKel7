package gradlepvzkelompok7;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class GameMap {
    private Tile[][] tiles;
    private int width = 11; 
    private int height = 6; 

    public GameMap(int width,int height) {
        tiles = new Tile[height][width];
        initializeTiles();
    }

    private void initializeTiles() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // loop buat bikin watertile
                if ((i == 2 || i == 3) && (j >= 1 && j <= 11)) { 
                    tiles[i][j] = new WaterTile();
                } else {
                    tiles[i][j] = new GroundTile();
                }
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < height && y >= 0 && y < width) {
            return tiles[x][y];
        }
        return null;
    }


    public void updateTiles() {
        //mastiin semua zombie pada awalnya belum gerak
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (Zombie zombie : tiles[i][j].getZombies()) {
                    zombie.setHasMoved(false);
                }
            }
        }
        
        for (int i = 0; i < height; i++) {
            for (int j = width - 1; j > 0; j--) {
                Tile currentTile = tiles[i][j];
                Tile leftTile = tiles[i][j - 1];
                List<Zombie> zombiesToMove = new ArrayList<>();
                // cek zombie di tile yang ada tile[i][j] yang lagi ada di tahap loop
                for (Zombie zombie : new ArrayList<>(currentTile.getZombies())) { //pake new arraylist<> buat ngecopy isinya biar ga langsung ngemodifikasi si tilesnya 
                    if (!zombie.hasMoved() && !currentTile.hasPlant()) {
                        // Normal movement: kalo ga ada plant di tile yang sama ama zombie gerakin ke kiri
                        zombiesToMove.add(zombie);
                        zombie.setHasMoved(true);} //rubah state hasmoved nya biar zombie ga gerak 2 kali dalam loop yang sama
                }
    
                // zombie yang uda dimasukin ke arraylist baru digerakin
                for (Zombie zombie : zombiesToMove) {
                    System.out.println("Moving zombie from (" + i + ", " + j + ") to (" + i + ", " + (j-1) + ")");
                    currentTile.removeZombie(zombie);
                    leftTile.placeZombie(zombie);
    
                }
            }
        }
    }

    public void updateZombieAttacks() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile currentTile = tiles[i][j];
                if (currentTile.hasZombie() && currentTile.hasPlant()) {
                    Plant plant = currentTile.getPlant();
                    List<Zombie> zombies = currentTile.getZombies();
                    for (Zombie zombie : zombies) {
                        if (!plant.isDead()&& zombie.canAttack()) {
                            System.out.println(zombie.getName() + "attacking plant at tile (" + i + ", " + j + ")");
                            zombie.zombieAttack(plant);
                        }
                    }
                }
            }
        }
    }


    public void updatePlantAttacks() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = tiles[i][j];
                if (tile.getPlant() != null && tile.getPlant().canAttack()) {
                    List<Zombie> targetZombies = getZombiesInRange(i, j, tile.getPlant().getRange());
                    tile.getPlant().attack(targetZombies);
                }
            }
        }
    }


    // implementasi generik
    public <T extends Creature> void removeDeadEntities(List<T> entities, int row, int col) {
        Iterator<T> iterator = entities.iterator();
        while (iterator.hasNext()) {
            T entity = iterator.next();
            if (entity.isDead()) {
                iterator.remove();
                if (entity instanceof Plant) {
                    tiles[row][col].removePlant();
                } else if (entity instanceof Zombie) {
                    tiles[row][col].removeZombie((Zombie) entity);
                }
                System.out.println(entity.getClass().getSimpleName() + " at tile (" + row + ", " + col + ") has died and been removed.");
            }
        }
    }

    public void removeDeadEntities() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = tiles[i][j];
                removeDeadEntities(tile.getCreatures(), i, j);
            }
        }
    }



    
    
    private List<Zombie> getZombiesInRange(int plantRow, int plantCol, int range) {
        List<Zombie> zombiesInRange = new ArrayList<>();
    
        if (range == -1) { // cek buat plant yang bisa attack sepanjang row
            // cari tile pertama yang ada zombienya, di loop dari kolom si plant ke kolom akhir dari map
            for (int j = plantCol; j < width; j++) {
                if (tiles[plantRow][j].hasZombie()) {
                    zombiesInRange.addAll(tiles[plantRow][j].getZombies());
                    break;  
                }
            }
        } else {
            // Search within the defined range for the first tile with zombies
            for (int j = plantCol; j <= plantCol + range; j++) {
                if (tiles[plantRow][j].hasZombie()) {
                    zombiesInRange.addAll(tiles[plantRow][j].getZombies());
                    break;
                }
            }
        }
        return zombiesInRange;
    }
    

    
    
    public void printMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = tiles[i][j];
                if (tile.hasZombie() && tile.getPlant() != null) {
                    System.out.print("\u001B[31mF \u001B[0m");  // kode ANSI "F" merah kalo fighting
                } else if (tile.hasZombie()) {
                    System.out.print("Z ");  // kalo tilenya ada zombie
                } else if (tile instanceof WaterTile) {
                    System.out.print("W ");  // kalo tilenya water
                } else if (tile.getPlant() != null) {
                    System.out.print("P ");  // kalo tilenya ada plant
                } else {
                    System.out.print(". ");  // kalo ground tile kosong
                }
            }
            System.out.println(); 
        }
    }
    

    




}