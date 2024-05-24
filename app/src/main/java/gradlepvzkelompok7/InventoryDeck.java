package gradlepvzkelompok7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Objects;

public class InventoryDeck {
    private List<Plant> deck;
    private List<Plant> inventory;
    private HashMap<Plant, Long> deckCooldowns;
    private GameMap gameMap;


    public InventoryDeck(GameMap gameMap) {
        this.deck = new ArrayList<>(Collections.nCopies(6, null));
        this.inventory = initializeInventory();
        this.deckCooldowns = new HashMap<>();
        this.gameMap = gameMap;
    }

    public static List<Plant> initializeInventory() {
        List<Plant> availablePlants = new ArrayList<>();
        String[] plantTypes = {
            "Sunflower",  "Peashooter", "Snowpea", "Repeater", "Wall nut", "Chomper", "Jalapeno", 
            "Squash", "Lilypad", "TangleKelp"
        };
        
        for (String plantType : plantTypes) {
            availablePlants.add(PlantFactory.createPlant(plantType));
        }

        return availablePlants;
    }


    

    public void plant(int deckSlot, long currentTime, int x, int y) throws Exception {
        Plant plant = deck.get(deckSlot);
        if (y == 0) {
            throw new Exception("Cannot plant on End-Tile");
        }
        if(y == 10){
            throw new Exception("Cannot plant on Zombie-Spawning-Tile");
        }
        if (plant == null) {
            throw new IllegalArgumentException("No plant in the selected deck slot.");
        }
        if (!cdReady(plant, currentTime)){
            throw new Exception("Plant is on cooldown");
        } if (gameMap.getAvailableSun() < plant.getCost()) {
            throw new Exception("Insufficient sun");
        }
        executePlanting(plant, currentTime, x, y);
    }

    public void executePlanting(Plant plant, long currentTime, int x, int y) throws Exception {
        try {
            Plant plantDuplicate = PlantFactory.createPlant(plant.getName());
            gameMap.getTile(x, y).placePlant(plantDuplicate); //ini yg throw exception
            long cooldownEnd = currentTime + (plant.getCooldown() *1000);
            deckCooldowns.put(plant,cooldownEnd);
            System.out.println(plant.getName() + " is planted on " + y + ", " + x);
            gameMap.setAvailableSun(gameMap.getAvailableSun() - plant.getCost());
            
        }catch (Exception e){
            throw new Exception("Failed to plant due to: " + e.getMessage(), e);
        }
    }

    public void dig(int x,int y) throws Exception{
        try {
            gameMap.getTile(x, y).removePlant();
            System.out.println("Plant removed from "+ y + ", "+ x);
        } 
        catch (Exception e) {
            throw new Exception("Failed to dig due to: " + e.getMessage(), e);
        }
    }

    private boolean cdReady(Plant plant, long currentTime) {
        Long cooldownEnd = deckCooldowns.get(plant);
        return cooldownEnd == null||currentTime >= cooldownEnd;
    }

    public void selectPlant(int deckSlot, Plant plant) {
        if (deckSlot < 0 || deckSlot >= deck.size()) {
            throw new IllegalArgumentException("Invalid deck slot");
        }
        if (deck.contains(plant)) {
            throw new IllegalArgumentException(plant.getName() + " already selected");
        }
        deck.set(deckSlot, plant);
    }

    public void swapDeckPlants(int slot1, int slot2) {
        if (slot1 < 0 || slot1 >= deck.size() || slot2 < 0 || slot2 >= deck.size()) {
            throw new IllegalArgumentException("Invalid slot number");
        }
        if (slot1 == slot2) {
            throw new IllegalArgumentException("Cannot swap the same slot");
        }
        Collections.swap(deck, slot1, slot2);
    }

    public void swapInventoryPlants(int slot1, int slot2) {
        if (slot1 < 0 || slot1 >= inventory.size() || slot2 < 0 || slot2 >= inventory.size()) {
            throw new IllegalArgumentException("Invalid slot number");
        }
        if (slot1 == slot2) {
            throw new IllegalArgumentException("Cannot swap the same slot");
        }
        Collections.swap(inventory, slot1, slot2);
    }

    public void removePlant(int deckSlot) {
        if (deckSlot < 0 || deckSlot >= deck.size()) {
            throw new IllegalArgumentException("Invalid deck slot");
        }
        if (deck.get(deckSlot) == null) {
            throw new IllegalArgumentException("Slot is already empty");
        }
        deck.set(deckSlot, null);
    }

    public void displayDeckStatus() {
        long timeLeftInSeconds = 0;
        long currentTime = System.currentTimeMillis();
        System.out.println("Deck Status:");
        for (int i = 0; i < deck.size(); i++) {
            Plant plant = deck.get(i);
            Long cooldownEnd = deckCooldowns.get(plant);
            if (cooldownEnd != null) {
                long timeLeft = cooldownEnd - currentTime;
                timeLeftInSeconds = (timeLeft > 0) ? TimeUnit.MILLISECONDS.toSeconds(timeLeft) : 0; //mastiin ga nampilin cd negatif
            }
            System.out.printf("Slot %d: %s - Cooldown remaining: %d seconds\n",i, plant.getName(),timeLeftInSeconds);
            
        }
    }
    

    public List<Plant> getInventory() {
        return new ArrayList<>(inventory);
    }

    public List<Plant> getDeck() {
        return new ArrayList<>(deck);
    }

    public boolean deckIsFull() {
        return getDeck().stream().noneMatch(Objects::isNull) && getDeck().size() == 6; //ini harus dicek si nullnya karena di pembuatan awal adalah deck dengan 6 nilai null
    }

    public List<Plant> displayAvailableToChoosePlants() {//ngecopy inventory ke list baru yang nampilin plant2 yg blm masuk ke deck doang
        List<Plant> availablePlants = new ArrayList<>(getInventory());
        availablePlants.removeAll(getDeck());
        int index = 1;
        for (Plant plant : availablePlants) {
            System.out.println(index++ + ": " + plant.getName());
        }
        return availablePlants;
    }
}

