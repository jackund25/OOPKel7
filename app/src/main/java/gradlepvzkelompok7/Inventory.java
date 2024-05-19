package gradlepvzkelompok7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
    private List<Plant> deck;
    private List<Plant> availablePlants;

    public Inventory(List<Plant> availablePlants) {
        this.deck = new ArrayList<>(Collections.nCopies(6, null));
        this.availablePlants = availablePlants;
    }

    public void selectPlant(int deckSlot, Plant plant) {
        if (deckSlot < 0 || deckSlot >= deck.size()) {
            throw new IllegalArgumentException("Invalid deck slot");
        }
        if (deck.contains(plant)) {
            throw new IllegalArgumentException("Plant already selected");
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
        if (slot1 < 0 || slot1 >= availablePlants.size() || slot2 < 0 || slot2 >= availablePlants.size()) {
            throw new IllegalArgumentException("Invalid slot number");
        }
        if (slot1 == slot2) {
            throw new IllegalArgumentException("Cannot swap the same slot");
        }
        Collections.swap(availablePlants, slot1, slot2);
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

    public List<Plant> getAvailablePlants() {
        return new ArrayList<>(availablePlants);
    }

    public List<Plant> getDeck() {
        return new ArrayList<>(deck);
    }

    public void harvest(int index, Tile tile) {
        if (index >= 0 && index < deck.size()) {
            Plant plant = deck.get(index);
            if (!plant.isHarvested()) {
                tile.removePlant();
            } else {
                System.out.println("This plant's spot is already empty.");
            }
        } else {
            System.out.println("Invalid plant index.");
        }
    }
}
