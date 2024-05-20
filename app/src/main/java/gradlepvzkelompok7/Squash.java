package gradlepvzkelompok7;

import java.util.List;

public class Squash extends Plant{ 
    public Squash() {
        super("Squash", 100, 5000, 0, false, 50, 1, 20);
    }


    @Override
    public void plantAction(List<Zombie> targetZombies) {
        System.out.println(this.getName() + " is performing a squash!");
        for (Zombie zombie : targetZombies) {
            zombie.takeDamage(attackDamage);  
        }
        this.health = 0;  //otomatis mati
    }



    
}