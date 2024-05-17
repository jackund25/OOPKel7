package gradlepvzkelompok7;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
    private Plant plant; // Menyimpan tanaman yang ditempatkan di tile ini
    private ArrayList<Zombie> zombies; // Menyimpan daftar zombie yang ada di tile ini
    private boolean isWater; // Menandakan apakah tile ini adalah tile air

    // Konstruktor untuk inisialisasi tile dengan atau tanpa air
    public Tile(boolean isWater) {
        this.isWater = isWater;
        this.zombies = new ArrayList<>();
        this.plant = null;
    }

    // Mengembalikan tanaman yang ada di tile ini
    public Plant getPlant() {
        return plant;
    }

    // Mengembalikan daftar zombie yang ada di tile ini
    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    // Mengembalikan daftar semua creature (tanaman dan zombie) yang ada di tile ini
    public List<Creature> getCreatures() {
        List<Creature> creatures = new ArrayList<>();
        if (plant != null) {
            creatures.add(plant);
        }
        creatures.addAll(zombies);
        return creatures;
    }

    // Mengembalikan true jika tile ini adalah tile air
    public boolean isWater() {
        return isWater;
    }

    // Mengembalikan true jika ada tanaman di tile ini
    public boolean hasPlant() {
        return plant != null;
    }

    // Mengembalikan true jika ada zombie di tile ini
    public boolean hasZombie() {
        return !zombies.isEmpty();
    }

    // Menempatkan tanaman di tile ini jika belum ada tanaman
    public void placePlant(Plant plant) {
        if (!hasPlant()) {  
            this.plant = plant;
        }
    }

    // Menambahkan zombie ke daftar zombie di tile ini
    public void placeZombie(Zombie zombie) {
        this.zombies.add(zombie);
    }

    // Menghapus tanaman dari tile ini
    public void removePlant() {
        this.plant = null;
    }

    // Menghapus zombie tertentu dari tile ini
    public void removeZombie(Zombie zombie) {
        this.zombies.remove(zombie);
    }

    // Menghapus semua zombie dari tile ini
    public void removeAllZombie() {
        this.zombies.clear();
    }

    // Menghapus zombie berdasarkan indeks dari daftar zombie di tile ini
    public void removeZombie(int index) {
        if (index >= 0 && index < zombies.size()) {
            zombies.remove(index);
        }
    }
}
