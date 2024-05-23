package gradlepvzkelompok7;

public class Lilypad extends Plant {
    public Lilypad() {
        super("Lilypad", 100, 0, 0, true, 25, 0, 10);
    }
    
}
    // Method to determine if a plant can be placed on Lilypad
    // public boolean canPlacePlant(Tanaman plant) {
    //     System.out.println(getName() + " allows placement of " + plant.getName() + ".");
    //     return true; // Assume it's always possible to place a plant on Lilypad
    // }

    // Method to calculate the combined health of the Lilypad and the plant placed on it
    // public int calculateCombinedHealth(Tanaman plant) {
    //     int combinedHealth = this.getHealth() + plant.getHealth();
    //     System.out.println("The combined health of " + getName() + " and " + plant.getName() + " is " + combinedHealth);
    //     return combinedHealth;
    // }