package gradlepvzkelompok7;

import java.util.List;

public class Jalapeno extends Plant {
    public Jalapeno(){
        super("Jalapeno", 100, 5000, 1, false, 150, -1, 20);
    }

    @Override
    public void plantAction(List<Zombie> targetZombies) {
        System.out.println(this.getName() + " is performing a row-wide kamikaze attack!");
        for (Zombie zombie : targetZombies) {
            zombie.takeDamage(this.attackDamage);  
        }
        this.health = 0;  // automatis mati
    }
    
}
