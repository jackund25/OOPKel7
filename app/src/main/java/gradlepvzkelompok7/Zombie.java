package gradlepvzkelompok7;

public class Zombie extends Creature {
    private boolean isSlowed;
    private int slowDuration;
    private boolean hasMoved = false;
    // private long lastAttackTime;  // Timestamp of the last attack

    public Zombie(String name, int health, int attackDamage,long attackSpeed, boolean isAquatic) {
        super(name, health, attackDamage, attackSpeed, isAquatic);
        this.isSlowed = false;
        this.slowDuration = 0;
        // this.lastAttackTime = System.currentTimeMillis() - (attackSpeed * 1000);
    }

    // @Override
    public void zombieAttack(Creature target) {
        long currentTime = System.currentTimeMillis();  // Convert milliseconds to seconds
        if (canAttack()) {
            System.out.println("plant initial health = " + target.getHealth());
            target.takeDamage(attackDamage);
            System.out.println(target.getName() + " taken damage " + attackDamage + ", " +target.getName() + " hp is now " + target.getHealth());
            lastAttackTime = currentTime;  // Reset the last attack time
        }
    }

    public boolean canAttack() {
        long currentTime = System.currentTimeMillis();
        // Check if current time is enough after last attack based on attack speed
        long elapsed = currentTime - lastAttackTime;
        // System.out.println("Elapsed Time: " + elapsed + "ms, Required: " + (attackSpeed * 1000) + "ms");
        return elapsed >= (attackSpeed * 1000);
    }
    


    public void slow() {
        isSlowed = true;
        slowDuration = 3;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
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

