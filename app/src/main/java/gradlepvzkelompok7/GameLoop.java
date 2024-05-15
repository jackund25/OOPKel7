package gradlepvzkelompok7;

public class GameLoop {
    private boolean gameRunning;
    //private final long tickInterval = 5000; //bisa diganti" kalo lagi mau ngecek biar cepet, intervalnya direndahin
    private GameMap gameMap;

    public GameLoop() {
        this.gameMap = new GameMap(11, 6);
        this.gameRunning = true;
        initializeGame(); // buat naro" zombie dan plant sebelum ada thread input
    }

    public void initializeGame() {
        Zombie zombie1 = new NormalZombie();
        Zombie zombie2 = new ConeheadZombie();
        Plant peashooter1 = new Peashooter();
        Plant peashooter2 = new Peashooter();
        Plant repeater1 = new Repeater();
        //gameMap.getTile(0, 10).placeZombie(zombie1);
        //gameMap.getTile(1, 10).placeZombie(zombie2);
        gameMap.getTile(0, 6).placePlant(peashooter1);
        gameMap.getTile(1, 6).placePlant(peashooter2);
        gameMap.getTile(0, 4).placePlant(repeater1);
    }

    public void startGame() {
        long lastSpawnTime = System.currentTimeMillis();
        long lastPrintTime = System.currentTimeMillis();
    
        gameMap.printMap(); // Initial map print
    
        while (gameRunning) {
            long currentTime = System.currentTimeMillis();
    
            // zombi spawn stiap 1 detik
            if (currentTime - lastSpawnTime >= 1000) {
                gameMap.spawnZombies();
                lastSpawnTime = currentTime; // update time
            }
    
            gameMap.updateTiles();

            //ngeprint map stiap 1 detik
            if (currentTime - lastPrintTime >= 1000) {
                clearConsole();
                gameMap.printMap();
                lastPrintTime = currentTime; // //update time
            }

    
            // yg dilakukan terus"an karena logic waktu ud di dalem method yg dipanggil 
            gameMap.updatePlantAttacks();    // plant attack zombi
            gameMap.updateZombieAttacks();   // zombie attack plant
            gameMap.removeDeadEntities();    
    


    
            // disini nanti nambahin kondisi gameover
            try {
                Thread.sleep(100); // sleep
            } catch (InterruptedException e) {
                System.out.println("Game loop was interrupted.");
                gameRunning = false;
            }
        }
    }

    

    public static void main(String[] args) {

        GameLoop game = new GameLoop();
        game.startGame();
    }

    private static void clearConsole() {
        
    }

    

}
