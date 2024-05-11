package gradlepvzkelompok7;

public class WaterTile extends Tile {
    private boolean lilyPlanted;

    public WaterTile() {
        super(true);
        this.lilyPlanted = false;
    }

    public boolean lilyPlanted() {
        if (getPlant().getName() == "lilypad" )  {
            return true;
        }
        else return false;
    }

    public void setLilyPlanted(boolean lilyPlanted) {
        this.lilyPlanted = lilyPlanted;
    }

    @Override
    public void placePlant(Plant plant) {
        if (lilyPlanted && !hasPlant()) {
            super.placePlant(plant);
        }
    }
}
