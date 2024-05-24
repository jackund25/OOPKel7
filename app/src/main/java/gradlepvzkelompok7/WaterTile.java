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
    public void placePlant(Plant plant) throws IllegalArgumentException {
        if (plant.getName().equals("Lilypad")) {
            if (isLilyPlanted()) {
                throw new IllegalArgumentException("Lilypad already planted");
            }
            super.placePlant(plant);
            setLilyPlanted(true);
        } 
        else {
            if (!isLilyPlanted()) {
                throw new IllegalArgumentException("Cannot place any plant except Lilypad on water tile without lilypad.");
            }
            if (getPlant() != null && !getPlant().getName().equals("Lilypad")) {
                throw new IllegalArgumentException("Another plant is already planted on top of this lilypad");
            }
             plant.setHealth(plant.getHealth() + getPlant().getHealth()); //gabung hp plant yg diplant sama lilypad
             removePlant(); //remove si lilypad (kayanya ga perlu(?))
             super.placePlant(plant); // plant si plant yg emg mau diplant
        }
    }
    

    
    
    @Override
    public void removePlant() {
        if (hasPlant()) {
            boolean wasLilypad = getPlant().getName().equals("Lilypad");
            plant = null; //ngeremove litereli plant ato lilypad ttp aja awalnya diremove plantnya
    
            if (!wasLilypad) { //ngedig plant di atas lilypad, bukan si lilypadny
                Plant lilypad = PlantFactory.createPlant("Lilypad");
                placePlant(lilypad);
                setLilyPlanted(true);
            } else { //ngedig lilypad
                setLilyPlanted(false); //cuma perlu ganti atribut boolean karena di atas ud diremove
            }
        } else {
            throw new IllegalArgumentException("There's no plant to be removed");
        }
    }

    public void removeAll() {
        plant = null;
    }
    
}