package gradlepvzkelompok7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;


public class GameMap {
    private Tile[][] tiles;
    private int width = 11; 
    private int height = 6; 
    private int currentZombieCount = 0;
    private static final int MAX_ZOMBIES = 10;
    private static final int MAX_FLAG_ZOMBIES = 25;
    private int gameTime = 0; 
    private boolean isFlagDay = false;
    private int availableSun = 50;
    private int dayCount = 1;
    private boolean gameOver = false;
    private boolean gameWin = false;

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


    public void updateGame() {
        updateTiles();
        updatePlantActions();
        updateZombieAttacks();
        removeDeadEntities();
        if (reachedEndTile() || (gameTime > 30 && currentZombieCount == 0)){
            gameOver = true;
            if (currentZombieCount ==0){
                gameWin = true;
            }
        }
    }


    public void updateTiles() {
        long currentTime = System.currentTimeMillis();
        
        for (int i = 0; i < height; i++) {
            for (int j = width - 1; j > 0; j--) {
                Tile currentTile = tiles[i][j];
                Tile leftTile = tiles[i][j - 1];
                List<Zombie> zombiesToMove = new ArrayList<>(); 
                // cek zombie di tile yang ada tile[i][j] yang lagi ada di tahap loop
                for (Zombie zombie : new ArrayList<>(currentTile.getZombies())) { //pake new arraylist<> buat ngecopy isinya biar ga langsung ngemodifikasi si tilesnya 
                    if (zombie.canMove(currentTime)) {
                        // logic buat zombie yang bisa jump
                        if (zombie instanceof Jumping && !((Jumping) zombie).hasJumped() && leftTile.hasPlant() ) {
                            if (j - 2 >= 0) { //pastiin ga keluar map
                                Tile landingTile = tiles[i][j - 2];
                                Plant targetPlant = landingTile.getPlant();
                                landingTile.placeZombie(zombie);
                                currentTile.removeZombie(zombie);
                                System.out.println(zombie + "landed on " + i + "," + (j-2) + "and killed plant on " + i + "," + (j-2));
                                if (landingTile instanceof WaterTile) {
                                    ((WaterTile)landingTile).setLilyPlanted(false); 
                                }
                                ((Jumping) zombie).setHasJumped(true);
                                zombie.updateNextMoveTime(currentTime); //rubah nextmove timeny nya biar zombie ga gerak 2 kali dalam loop yang sama
                                if (targetPlant != null) {
                                    targetPlant.takeDamage(targetPlant.getHealth()); // plant yang dilompatin mati
                                    landingTile.removePlant();
                                }
                            }
                        }

                        // normal movement: kalo ga ada plant di tile yang sama ama zombie gerakin ke kiri
                        else if (!currentTile.hasPlant()) {
                            zombiesToMove.add(zombie);
                            zombie.updateNextMoveTime(currentTime);} //rubah state hasmoved nya biar zombie ga gerak 2 kali dalam loop yang sama
 
                    }
                }

                
    
                // zombie yang uda dimasukin ke arraylist baru digerakin
                for (Zombie zombie : zombiesToMove) {
                    //System.out.println("Moving " + zombie.getName() +" from (" + i + ", " + j + ") to (" + i + ", " + (j-1) + ")");
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
                List<Zombie> zombies = currentTile.getZombies();
                for (Zombie zombie : zombies) {
                    //handle gargantuar yang lempar lembing
                    if (zombie instanceof GargantuarZombie && ((GargantuarZombie)zombie).isReadyToThrow()) {
                        GargantuarZombie gargantuar = (GargantuarZombie) zombie;
                        if (gargantuar.isReadyToThrow()) {
                            boolean plantHit = false;
                            for (int k = 1; k < j; k++) {
                                if (tiles[i][k].getPlant() != null) {
                                    System.out.println("Javelin hits and destroys the plant at (" + i + ", " + k + ")");
                                    tiles[i][k].removePlant();
                                    plantHit = true;
                                    gargantuar.setHasThrownJavelin(true); //biar ga ngelempar lagi
                                    break;
                                }
                            }
                            if (!plantHit) System.out.println("Javelin missed! No plant in the range.");
                        }
                    //attack zombie biasa
                    } else if (currentTile.hasPlant()) {
                        Plant plant = currentTile.getPlant();
                        if (!plant.isDead() && zombie.canAttack()) {
                            //System.out.println(zombie.getName() + " attacking plant at tile (" + i + ", " + j + ")");
                            zombie.zombieAttack(plant);
                        }
                    }
                }
            }
        }
    }


    public void updatePlantActions() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = tiles[i][j];
                Plant plant = tile.getPlant();
                if (plant != null && plant.canPerformAction()) {
                    if (plant instanceof Sunflower) {
                        plant.plantAction(null); 
                        availableSun += 25;
                        //System.out.println("Sunflower at (" + i + ", " + j + ") generated sun!");
                    } 
                    else if (plant instanceof Jalapeno) {
                        List<Zombie> allZombiesInRow = getAllZombiesInRow(i);
                        plant.plantAction(allZombiesInRow);
                        //System.out.println("Jalapeno at (" + i + ", " + j + ") has exploded!");
                    } else {
                        List<Zombie> targetZombies = getZombiesInRange(i, j, plant.getRange());
                        if (!targetZombies.isEmpty()) {
                            plant.plantAction(targetZombies);
                        }
                    }
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
                    if (tiles[row][col].isWater()) {
                        ((WaterTile)tiles[row][col]).setLilyPlanted(false); //sekalian ngedelete lilypad soalnya logicnya kan hp lily ditambah ke plant diatasnya
                        ((WaterTile)tiles[row][col]).removeAll();
                    }
                    else {
                    tiles[row][col].removePlant();
                    }
                } else if (entity instanceof Zombie) {
                    tiles[row][col].removeZombie((Zombie) entity);
                    removeZombieCount();
                }
                //System.out.println(entity.getClass().getSimpleName() + " at tile (" + row + ", " + col + ") has died and been removed.");
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
        } 
        else {
            // cari tile sesuai sama attackrange si plant terkait
            for (int j = plantCol; j <= plantCol + range; j++) {
                if (tiles[plantRow][j].hasZombie()) {
                    zombiesInRange.addAll(tiles[plantRow][j].getZombies());
                    break;
                }
            }
        }
        return zombiesInRange;
    }
    
    public List<Zombie> getAllZombiesInRow(int row) {
        List<Zombie> zombiesInRow = new ArrayList<>();
        for (int col = 0; col < width; col++) {
            zombiesInRow.addAll(tiles[row][col].getZombies());
        }
        return zombiesInRow;
    }
    
    
    public void printMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = tiles[i][j];
    
                if (tile.hasZombie() && tile.getPlant() != null) {
                    System.out.print("\u001B[31mF \u001B[0m");  //kode ansi F merah kalo lg fighting
                } 
                else if (tile.hasZombie()) {
                    int zombieCount = tile.getZombies().size();
                    switch (zombieCount) {
                        case 1:
                            System.out.print("Z ");  // regular Z kalo 1 zombie
                            break;
                        case 2:
                            System.out.print("\u001B[32mZ \u001B[0m");  // Z ijo kalo 2 zombie
                            break;
                        case 3:
                            System.out.print("\u001B[33mZ \u001B[0m");  // Z kuning kalo 3 zombie
                            break;
                        case 4:
                            System.out.print("\u001B[34mZ \u001B[0m");  // Z biru kalo 4 zombie
                            break;
                        default:
                            System.out.print("\u001B[35mZ \u001B[0m");  // Z magenta kalo lebi dari 4
                            break;
                    }
                } 
                else if (tile.getPlant() != null && !tile.getPlant().getName().equals("Lilypad") && tile instanceof WaterTile) {
                    System.out.print("\u001B[34mP \u001B[0m");  // P biru kalo plant yang diplant di lilypad
                } 
                else if (tile instanceof WaterTile) {
                    if (((WaterTile) tile).isLilyPlanted()) {
                        System.out.print("\u001B[32mL \u001B[0m");  // L ijo kalo ada lilypad di watertile
                    } else {
                        System.out.print("\u001B[34m. \u001B[0m");  // . biru kalo watertile
                    }
                } 
                else if (tile.getPlant() != null) {
                    System.out.print("P ");  // P biasa kalo ada plant di groundtile
                } 
                else {
                    System.out.print(". ");  // empty tile
                }
            }
            System.out.println();  
        }
    }

    public void spawnZombies() {
        if (gameTime >= 20 && gameTime <= 160) {

            double spawnChance = isFlagDay ? 0.5 : 0.3;
            for (int i = 0; i < height; i++) {
                boolean appropriateForTile = false;
                Random random = new Random();
                    if (random.nextDouble() < spawnChance) { //30% chance buat spawnzombie
                        if (currentZombieCount >= (isFlagDay ? MAX_FLAG_ZOMBIES : MAX_ZOMBIES)) break; 
                        
                        Tile spawnTile = tiles[i][width - 1]; // spawn tilenya adalah tile paling kiri di gamemap
                        int zombieType = random.nextInt(10); // random int buat nentuin zombie mana yg dispawn
                        
                        //mastiin si aquatic zombie cuma bisa spawn di yang air
                        if (spawnTile instanceof WaterTile) {
                            if (zombieType == 8 || zombieType == 9) {
                                appropriateForTile = true;
                            }
                        } else {
                            //sebaliknya
                            if (zombieType != 8 && zombieType != 9) {
                                appropriateForTile = true;
                            }
                        }
                        if (appropriateForTile) {
                            Zombie zombie = ZombieFactory.createZombie(zombieType);
                            spawnTile.placeZombie(zombie);
                            currentZombieCount++;
                            //System.out.println("Spawned " + zombie.getClass().getSimpleName() + " at row " + i);
                        }
                }
            }
        }
    }

    public void handleFlagEvents() {
        isFlagDay = (dayCount > 1);
        if (gameTime > 200) {
             setGameTime(1);
             dayCount += 1;
        }

    }

    public boolean isFlagDay() {
        return isFlagDay;
    }

    public void updateGameTime(int seconds) {
        gameTime += seconds;
        handleFlagEvents();
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public int getGameTime(){
        return gameTime;
    }
    
    public boolean reachedEndTile(){
        for(int i = 0; i < height;i++) {
            if (getTile(i, 0).hasZombie()) {
                return true;
            } 
        }
        return false;
    }
    public void removeZombieCount() {
        currentZombieCount--;
    }

    
    public int getAvailableSun() {
        return availableSun;
    }

    public void setAvailableSun(int availableSun) {
        this.availableSun = availableSun;
    }

    public boolean gameOver(){
        return gameOver;
    }

    public boolean gameWin(){
        return gameWin;
    }

}