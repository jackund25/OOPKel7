package gradlepvzkelompok7;

public class Lilypad extends Plant {
    private Plant plantedPlant;

    public Lilypad() {
        super("Lilypad", 100, 0, 0, false, 25, 0, 10);
        this.plantedPlant = null;
    }

    public boolean canPlacePlant(Plant plant) {
        return plantedPlant == null && plant != null;
    }

    public int calculateCombinedHealth(Plant plant) {
        if (plant == null) {
            return this.getHealth();
        }
        return this.getHealth() + plant.getHealth();
    }

    public void placePlant(Plant plant) {
        if (canPlacePlant(plant)) {
            this.plantedPlant = plant;
            plant.setHealth(calculateCombinedHealth(plant));
        }
    }

    public Plant getPlantedPlant() {
        return this.plantedPlant;
    }
}
