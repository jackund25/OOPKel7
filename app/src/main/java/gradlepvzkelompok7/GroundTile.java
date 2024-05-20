package gradlepvzkelompok7;

public class GroundTile extends Tile {
    public GroundTile() {
        super(false);
    }

    @Override
    public void placePlant(Plant plant) throws IllegalArgumentException {
        if (plant.isAquatic()) {
            throw new IllegalArgumentException("Aquatic plants cannot be placed on ground tiles.");
        }
        if (getPlant() != null) {
            throw new IllegalArgumentException("Another plant is already present on this tile.");
        }
        super.placePlant(plant);
    }
}

