package gradlepvzkelompok7;

import java.util.List;

public class Sunflower extends Plant {

    // Konstruktor untuk inisialisasi objek Sunflower dengan nilai atribut yang telah ditentukan
    public Sunflower() {
        super("Sunflower", 100, 0, 3, false, 50, 0, 10);
    }

    @Override
    public void plantAction(List<Zombie> targetZombies) {
        long currentTime = System.currentTimeMillis();
        if (canPerformAction()) {
            generateSun();
            nextAttackTime = currentTime + attackSpeed * 1000; //reset time
        }
    }

    private void generateSun() {
        //System.out.println(getName() + " generated sun at position.");
    }
}
