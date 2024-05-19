package gradlepvzkelompok7;

// import java.util.List;

public class Chomper extends Plant {
    // private boolean chewing;

    /**
     * Konstruktor untuk kelas Chomper.
     * Menginisialisasi Lilypad dengan properti spesifik
     */
    public Chomper() {
        super("Chomper", 150, 3000, 42, false, 150, 1, 15);
    }

    // @Override
    // public void plantAttack(List<Zombie> targetZombies) {
    //     if (chewing || targetZombies == null || targetZombies.isEmpty()) {
    //         return;
    //     }

    //     for (Zombie zombie : targetZombies) {
    //         if (!zombie.isDead()) {
    //             zombie.takeDamage(attackDamage);
    //             chewing = true;
    //             break; // Hanya menyerang satu zombie
    //         }
    //     }

    //     // Simulasi waktu mengunyah (chewing time) selama 42 detik
    //     new java.util.Timer().schedule(new java.util.TimerTask() {
    //         @Override
    //         public void run() {
    //             chewing = false;
    //         }
    //     }, attackSpeed * 1000); // Mengonversi attackSpeed dari detik ke milidetik
    // }

    // @Override
    // public boolean canAttack() {
    //     return !chewing;
    // }

    // public boolean isChewing() {
    //     return chewing;
    // }
}
