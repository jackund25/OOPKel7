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
        if (plant.getName().equals("Lilypad")) {
            if (!isLilyPlanted()) {
                super.placePlant(plant); 
                setLilyPlanted(true);
            } else {
                System.out.println("Lilypad already planted here");
            }
        } else if (isLilyPlanted()) {
            if (getPlant() != null && getPlant().getName().equals("Lilypad")) {
                plant.setHealth(plant.getHealth() + getPlant().getHealth());  // hp nya digabung dulu
                super.placePlant(plant);  // replace lilypad jd plant dengan hp yg ditambah lilypad
            }

        } else System.out.println("Cannot place any plant except lilypad on water tile without lilypad");
        
    }

    public void removePlant() {
        if (getPlant() != null && getPlant().getName().equals("Lilypad")) {
            setLilyPlanted(false);
        }
        super.removePlant();
    }
}
