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

    public void plantAttack(List<Zombie> targetZombies) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAttackTime >= attackSpeed * 1000) {
            for (Zombie zombie : targetZombies) {
                if (!zombie.isDead()) {
                    zombie.takeDamage(attackDamage);
                }
            }
            lastAttackTime = currentTime; // update lastattacktime 
        }
    }


    @Override
    public boolean canAttack() {
        if (attackDamage == 0) return false;
        long currentTime = System.currentTimeMillis();
        // cek waktu yang uda lewat uda mencukupi belum buat ngeattack lagi
        long elapsed = currentTime - lastAttackTime;
        return elapsed >= (attackSpeed * 1000);
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

