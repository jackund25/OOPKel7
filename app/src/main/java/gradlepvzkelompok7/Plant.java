package gradlepvzkelompok7;

import java.util.List;

public abstract class Plant extends Creature {
    protected int cost;
    protected int range;
    protected int cooldown;

    public Plant(String name, int health, int attackDamage, long attackSpeed, boolean isAquatic, int cost, int range, int cooldown) {
        super(name, health, attackDamage, attackSpeed, isAquatic);
        this.cost = cost;
        this.range = range;
        this.cooldown = cooldown;
    }

    public void plantAction(List<Zombie> targetZombies) {

            if (attackDamage > 0) {
                for (Zombie zombie : targetZombies) {
                    if (!zombie.isDead()) {
                        zombie.takeDamage(attackDamage);
                    }
                }
            nextAttackTime = System.currentTimeMillis() + attackSpeed * 1000;
        }
    }
    

    public boolean canPerformAction() {
        long currentTime = System.currentTimeMillis();
        return currentTime >= nextAttackTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }  

}



