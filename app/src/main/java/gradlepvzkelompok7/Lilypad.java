package gradlepvzkelompok7;

public class Lilypad extends Plant {
    // private Plant plantedPlant;

    /**
     * Konstruktor untuk kelas Lilypad.
     * Menginisialisasi Lilypad dengan properti spesifik dan mengatur plantedPlant ke null.
     */
    public Lilypad() {
        super("Lilypad", 100, 0, 0, false, 25, 0, 10);
        // this.plantedPlant = null;
    }

    // /**
    //  * Memeriksa apakah sebuah tanaman bisa ditempatkan di Lilypad.
    //  * Tanaman bisa ditempatkan jika tidak ada tanaman yang sudah ada di Lilypad dan tanaman yang diberikan tidak null.
    //  * 
    //  * @param plant Tanaman yang akan ditempatkan.
    //  * @return true jika tanaman bisa ditempatkan, false jika tidak.
    //  */
    // public boolean canPlacePlant(Plant plant) {
    //     return plantedPlant == null && plant != null;
    // }

    // /**
    //  * Menghitung total kesehatan gabungan antara Lilypad dan tanaman yang ditempatkan di atasnya.
    //  * Jika tanaman null, mengembalikan kesehatan Lilypad saja.
    //  * 
    //  * @param plant Tanaman yang akan ditempatkan.
    //  * @return Total kesehatan gabungan.
    //  */
    // public int calculateCombinedHealth(Plant plant) {
    //     if (plant == null) {
    //         return this.getHealth();
    //     }
    //     return this.getHealth() + plant.getHealth();
    // }

    // /**
    //  * Menempatkan tanaman di atas Lilypad jika memungkinkan.
    //  * Jika tanaman bisa ditempatkan, mengatur tanaman tersebut ke plantedPlant dan memperbarui kesehatannya.
    //  * 
    //  * @param plant Tanaman yang akan ditempatkan.
    //  */
    // public void placePlant(Plant plant) {
    //     if (canPlacePlant(plant)) {
    //         this.plantedPlant = plant;
    //         plant.setHealth(calculateCombinedHealth(plant));
    //     }
    // }

    // /**
    //  * Mendapatkan tanaman yang ditempatkan di atas Lilypad.
    //  * 
    //  * @return Tanaman yang ditempatkan di atas Lilypad.
    //  */
    // public Plant getPlantedPlant() {
    //     return this.plantedPlant;
    // }
}
