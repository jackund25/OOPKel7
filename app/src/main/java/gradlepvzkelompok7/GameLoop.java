package gradlepvzkelompok7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameLoop {
    private boolean gameRunning;
    private GameMap gameMap;
    private InventoryDeck inventoryDeck;
    private long lastUpdateTime;
    Scanner scanner = new Scanner(System.in);

    public GameLoop() {
        this.gameMap = new GameMap(11, 6);
        this.gameRunning = true;
        initializeGame(); // buat naro" zombie dan plant sebelum ada thread input
    }

    public void initializeGame() {
        inventoryDeck = new InventoryDeck(gameMap);
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
        initializeDeck(); // pilih deck
        this.gameRunning = true; // start cuma kalo deck ud lengkap
        this.lastUpdateTime = System.currentTimeMillis();
        
        Thread inputThread = new Thread(this::handleUserInputs); 
        inputThread.start(); 

        long lastSpawnTime = System.currentTimeMillis();
        long lastPrintTime = System.currentTimeMillis();
        long last1SecActions = System.currentTimeMillis();
        Random random = new Random();
        long lastRandomSun = random.nextLong(5, 10);
    
        gameMap.printMap(); 
    

        while (gameRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastUpdateTime;
    
            if (currentTime - last1SecActions >= 1000) {
                gameMap.handleFlagEvents();
                gameMap.setGameTime(gameMap.getGameTime()+1);
                lastRandomSun --;
                last1SecActions = currentTime;
            }

            if (currentTime - lastSpawnTime >= 3000) {
                gameMap.spawnZombies();
                lastSpawnTime = currentTime;
            }


            if (currentTime - lastPrintTime >= 5000) {
                System.out.println("Available sun: "+ gameMap.getAvailableSun());
                gameMap.printMap();
                lastPrintTime = currentTime; // //update time
            }

            if (lastRandomSun ==0) {
                gameMap.setAvailableSun(gameMap.getAvailableSun() + 25);
                lastRandomSun = random.nextLong(5, 10);
                
            }

            if (elapsedTime >= 200) {  
                gameMap.updateGame(); 
                lastUpdateTime = currentTime;
                if (gameMap.gameOver()) {
                    gameRunning = false;
                    handleGameOver();
                }
            }

    
            try {
                Thread.sleep(100); // sleep
            } catch (InterruptedException e) {
                System.out.println("Game loop was interrupted.");
                gameRunning = false;
            }
        }

        try {
            inputThread.join(); // tunggu input thread
        } catch (InterruptedException e) {
            System.out.println("Input handling was interrupted.");
        }
    }

    private List<Integer> extractParameters(String userInput) {
        List<Integer> params = new ArrayList<>();
        String[] parts = userInput.split(" ");
        try {
            for (int i = 1; i < parts.length; i++) {  // Start from 1 to skip the command word
                params.add(Integer.parseInt(parts[i]));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in command.");
        }
        return params;
    }
    
    

    private void handleUserInputs() {
        Scanner scanner = new Scanner(System.in); 
        while (gameRunning) {
            String userInput = scanner.nextLine();
            List<Integer> params = extractParameters(userInput);
            
            try {
                if (userInput.startsWith("plant")) {
                    if (params.size() < 3) throw new IllegalArgumentException("Not enough parameters for 'plant'");
                    inventoryDeck.plant(params.get(0), System.currentTimeMillis(), params.get(2), params.get(1));
                } 
                else if (userInput.startsWith("deck")) {
                    inventoryDeck.displayDeckStatus();
                } 
                else if (userInput.startsWith("dig")) {
                    if (params.size() < 2) throw new IllegalArgumentException("Not enough parameters for 'dig'");
                    inventoryDeck.dig(params.get(1), params.get(0));
                } else {
                    System.out.println("Invalid command.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }    

    private void fillDeck(Scanner scanner) {
        System.out.println("Please select plants for your deck:");
        List<Integer> emptySlots = new ArrayList<>();
        for (int i = 0; i < inventoryDeck.getDeck().size(); i++) {
            if (inventoryDeck.getDeck().get(i) == null) {
                emptySlots.add(i); //initu harus di keep track mana yg empty soalnya si fungsi selectplant perlu index deck
            }
        }
    
        for (int i = 0; i < emptySlots.size(); i++) {
            int slot = emptySlots.get(i);
            boolean validInput = false;
            
            while (!validInput) {
                List<Plant> currentAvailablePlants = inventoryDeck.displayAvailableToChoosePlants(); //nampilin plant yg blm dipilih
                System.out.println("Choose a plant by number for deck slot " + (slot + 1) + ":");
                try {
                    int choice = Integer.parseInt(scanner.nextLine())- 1; // di -1 biar sesuai ama index array
                    if (choice < 0|| choice >= currentAvailablePlants.size()) {
                        System.out.println("Invalid choice. Please select a valid number.");
                        continue; // minta input lg
                    }
                    inventoryDeck.selectPlant(slot, currentAvailablePlants.get(choice)); 
                    System.out.println(currentAvailablePlants.get(choice).getName() + " added to deck.");
                    validInput = true; //break loop
                } 
                catch(NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

    }

    public void initializeDeck() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                fillDeck(scanner);  //isi ato menuhin
                if (!inventoryDeck.deckIsFull()) {
                    System.out.println("Your deck is not full. Please add more plants.");
                    continue;  
                }
                System.out.println("Do you want to edit your inventory or deck? (yes/no)");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("yes")) {
                    modifyDeck(scanner);  
                    continue; //hrs ngecek lagi apakah ud penuh ato blm
                } else {
                    break;  
                }
            }
        } finally {
            //scanner.close();
        }
    }

    private void modifyDeck(Scanner scanner) {
        while (true) {
            System.out.println("Choose an action: 'swap deck', 'swap inventory', 'remove', or 'done'");
            String command = scanner.nextLine().trim().toLowerCase();
            try {
                switch (command) {
                    case "swap deck":
                        System.out.println("Enter two deck slots to swap:");
                        int slot1 = Integer.parseInt(scanner.nextLine()) - 1;
                        int slot2 = Integer.parseInt(scanner.nextLine()) - 1;
                        inventoryDeck.swapDeckPlants(slot1, slot2);
                        System.out.println("Plants swapped in deck.");
                        break;

                    case "swap inventory":
                        System.out.println("Enter two inventory slots to swap:");
                        int invSlot1 = Integer.parseInt(scanner.nextLine()) - 1;
                        int invSlot2 = Integer.parseInt(scanner.nextLine()) - 1;
                        inventoryDeck.swapInventoryPlants(invSlot1, invSlot2);
                        System.out.println("Plants swapped in inventory.");
                        break;
                    
                    case "remove":
                        System.out.println("Enter a deck slot to clear:");
                        int removeSlot = Integer.parseInt(scanner.nextLine()) - 1;
                        inventoryDeck.removePlant(removeSlot);
                        System.out.println("Plant removed from deck.");
                        break;
    
                    case "done":
                        System.out.println("Deck modification completed.");
                        return;
                    
                    default:
                        System.out.println("Invalid command. Please choose a valid action.");
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            } 
        }
    }

    private void handleGameOver() {
        System.out.println("GAME OVER");
        System.exit(0);
    }

    public static void main(String[] args) {

        GameLoop game = new GameLoop();
        game.startGame();
    }



    

}
