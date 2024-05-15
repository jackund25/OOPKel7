package gradlepvzkelompok7;

import java.util.List;

public class Snowpea extends Plant{
    public Snowpea() {
        super("Snow pea", 100, 25, 4, false, 175, -1, 10);
    
    }

    @Override
    public void plantAttack(List<Zombie> targetZombies) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAttackTime >= attackSpeed * 1000) {
            for (Zombie zombie : targetZombies) {
                if (!zombie.isDead()) {
                    zombie.takeDamage(attackDamage);
                    zombie.slow();
                    System.out.println("zombie is slowed");
                }
            }
            lastAttackTime = currentTime;

    }
    
}
}
