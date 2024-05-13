package gradlepvzkelompok7;

public class WaterTile extends Tile {
    private boolean lilyPlanted;

    public WaterTile() {
        super(true);
        this.lilyPlanted = false;
    }

    public boolean isLilyPlanted() {
        return lilyPlanted;
    }

    public void setLilyPlanted(boolean lilyPlanted) {
        this.lilyPlanted = lilyPlanted;
    }


    @Override
    public void placePlant(Plant plant) {
        if (plant.getName().equals("Lilypad") && !isLilyPlanted()) {
            setLilyPlanted(true);
        }

        else if (isLilyPlanted() && !hasPlant()) {
            // Combine health of the lilypad with the new plant
            plant.setHealth(plant.getHealth() + 100); //100 adalah hp lilypad
            super.placePlant(plant);
        }
    }

    public void removePlant() {
        if (getPlant() != null && getPlant().getName().equals("Lilypad")) {
            setLilyPlanted(false);
        }
        super.removePlant();
    }
}
