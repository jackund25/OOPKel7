package gradlepvzkelompok7;

import java.util.List;

public class Snowpea extends Plant{
    public Snowpea() {
        super("Snow pea", 100, 25, 4, false, 175, -1, 10);
    
    }

    @Override
    public void plantAction(List<Zombie> targetZombies) {
        long currentTime = System.currentTimeMillis();
        if (currentTime  >= nextAttackTime) {
            for (Zombie zombie : targetZombies) {
                if (!zombie.isDead()) {
                    zombie.takeDamage(attackDamage);
                    zombie.slow();
                    System.out.println("zombie is slowed");
                }
            }
            nextAttackTime = currentTime + attackSpeed * 1000;

    }
    
}
}
