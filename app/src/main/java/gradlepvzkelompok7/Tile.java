package gradlepvzkelompok7;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile {
    private Plant plant;
    private ArrayList<Zombie> zombies;
    private boolean isWater;

    public Tile(boolean isWater) {
        this.isWater = isWater;
        this.zombies = new ArrayList<>();
        this.plant = null;
    }

    public Plant getPlant() {
        return plant;
    }
    

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public List<Creature> getCreatures() {
        List<Creature> creatures = new ArrayList<>();
        if (plant != null) {
            creatures.add(plant);
        }
        creatures.addAll(zombies);
        return creatures;
    }




    public boolean isWater() {
        return isWater;
    }

    public boolean hasPlant() {
        return plant != null;
    }

    public boolean hasZombie() {
        return !zombies.isEmpty();
    }

    public void placePlant(Plant plant) {
        if (!hasPlant()) {  
            this.plant = plant;
        }
    }

    public void placeZombie(Zombie zombie) {
        this.zombies.add(zombie);
    }

    public void removePlant() {
        this.plant = null;
    }

    public void removeZombie(Zombie zombie) {
        this.zombies.remove(zombie);
    }

    public void removeAllZombie() {
        this.zombies.clear();
    }

    public void removeZombie(int index) {
        if (index >= 0 && index < zombies.size()) {
            zombies.remove(index);
        }
    }
}

