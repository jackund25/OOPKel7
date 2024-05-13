package gradlepvzkelompok7;

public class GroundTile extends Tile {
    public GroundTile() {
        super(false);
    }

    @Override
    public void placePlant(Plant plant) {
        if (plant.isAquatic()) {
            System.out.println("Aquatic plants cannot be placed on ground tiles.");
            return;
        }
        super.placePlant(plant);
    }
}

