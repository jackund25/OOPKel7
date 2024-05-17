package gradlepvzkelompok7;

import java.util.ArrayList;
import java.util.List;

// public class DeckPlants<T extends Plant> {
//     private List<T> deck;
//     /**
//      * Konstruktor untuk kelas DeckPlants
//      */
//     public DeckPlants() {
//         deck = new ArrayList<>();
//     }

//     /**
//      * Menambahkan tanaman ke deck, jika deck belum penuh.
//      * @param plant Tanaman yang akan ditambahkan.
//      */
//     public void addPlant(T plant) {
//         if (deck.size() < 6) {
//             deck.add(plant);
//         } else {
//             System.out.println("Deck is full.");
//         }
//     }

//     /**
//      * Menanam tanaman dari deck berdasarkan indeks, jika tanaman tidak sedang cooldown.
//      * @param index Indeks tanaman yang akan ditanam.
//      */
//     public void plant(int index) {
//         if (index >= 0 && index < deck.size()) {
//             T plant = deck.get(index);
//             if (plant.getCooldown() <= 0) {
//                 // Perform planting action
//                 plant.plant();
//             } else {
//                 System.out.println("This plant is still on cooldown.");
//             }
//         } else {
//             System.out.println("Invalid plant index.");
//         }
//     }

//     /**
//      * Memanen tanaman dari deck berdasarkan indeks, jika tanaman belum dipanen.
//      * @param index Indeks tanaman yang akan dipanen.
//      */
//     public void harvest(int index) {
//         if (index >= 0 && index < deck.size()) {
//             T plant = deck.get(index);
//             if (!plant.isHarvested()) {
//                 // Perform harvesting action
//                 plant.harvest();
//             } else {
//                 System.out.println("This plant's spot is already empty.");
//             }
//         } else {
//             System.out.println("Invalid plant index.");
//         }
//     }

public class DeckPlants<T extends Plant> {
    private List<T> deck;

    public DeckPlants() {
        deck = new ArrayList<>();
    }

    public void addPlant(T plant) {
        if (deck.size() < 6) {
            deck.add(plant);
        } else {
            System.out.println("Deck is full.");
        }
    }

    public void plant(int index, Tile tile) {
        if (index >= 0 && index < deck.size()) {
            T plant = deck.get(index);
            if (plant.getCooldown() <= 0) {
                tile.placePlant(plant);
            } else {
                System.out.println("This plant is still on cooldown.");
            }
        } else {
            System.out.println("Invalid plant index.");
        }
    }

    public void harvest(int index, Tile tile) {
        if (index >= 0 && index < deck.size()) {
            T plant = deck.get(index);
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