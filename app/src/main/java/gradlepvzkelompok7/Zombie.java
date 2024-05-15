package gradlepvzkelompok7;

public class Zombie extends Creature {
    private boolean isSlowed = false;
    private long slowEndTime = 0;
    private long nextMoveTime = 0; // kapan zombi bisa gerak


    public Zombie(String name, int health, int attackDamage,long attackSpeed, boolean isAquatic) {
        super(name, health, attackDamage, attackSpeed, isAquatic);

        this.nextMoveTime = System.currentTimeMillis() + 5000; //default awal zombi gerak pas 5 detik
    }

    // @Override
    public void zombieAttack(Creature target) {
        long currentTime = System.currentTimeMillis();
        if (canAttack()) {
            System.out.println("plant initial health = " + target.getHealth());
            target.takeDamage(attackDamage);
            System.out.println(target.getName() + " taken damage " + attackDamage + ", " +target.getName() + " hp is now " + target.getHealth());
            lastAttackTime = currentTime;  // reset att time
        }
    }

    public boolean canAttack() {
        updateSlowStatus();
        long currentTime = System.currentTimeMillis();
        long elapsed = currentTime - lastAttackTime;
        if (isSlowed) {
            return elapsed >= ((attackSpeed*1.5) * 1000);
        }
            return elapsed >= ((attackSpeed) * 1000);
    }
    
    public void updateNextMoveTime(long currentTime) {
        if (isSlowed && currentTime > slowEndTime) {
            isSlowed = false; 
        }
        long moveInterval = isSlowed ? 7500 : 5000; // 7.5 detik klo lg keslow, klo normal 5 detik
        nextMoveTime = currentTime + moveInterval;
    }

    public boolean canMove(long currentTime) {
        if (currentTime >= nextMoveTime) {
            updateNextMoveTime(currentTime); // ganti nextmovetime biar ga terus"an move
            return true;
        }
        return false;
    }

    public void slow() {
        if (!isSlowed) { 
            isSlowed = true;
            slowEndTime = System.currentTimeMillis() + 3000;
        }
    }

    public void updateSlowStatus() {
        if (System.currentTimeMillis() > slowEndTime) {
            isSlowed = false;
        }
    }

    public void takeDamage(int damage) {
        System.out.println("Before damage: Zombie health = " + health);
        health -= damage;
        System.out.println("After damage: Zombie health = " + health);

        if (health <= 0) {
            System.out.println("Zombie has died.");
        }
    }
    
}


