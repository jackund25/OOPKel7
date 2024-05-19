package gradlepvzkelompok7;

import java.util.List;

public abstract class Plant extends Creature {
    protected int cost;
    protected int range;
    protected int cooldown;
    protected boolean harvested;

    // Konstruktor untuk inisialisasi objek Plant dengan nilai atribut yang telah ditentukan
    public Plant(String name, int health, int attackDamage, long attackSpeed, boolean isAquatic, int cost, int range, int cooldown) {
        super(name, health, attackDamage, attackSpeed, isAquatic);
        this.cost = cost;
        this.range = range;
        this.cooldown = cooldown;
        this.harvested = false;
    }

    // Method untuk menyerang zombie
    public void plantAttack(List<Zombie> targetZombies) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAttackTime >= attackSpeed * 1000) {
            for (Zombie zombie : targetZombies) {
                if (!zombie.isDead()) {
                    zombie.takeDamage(attackDamage);
                }
            }
            lastAttackTime = currentTime; // update waktu serangan terakhir
        }
    }

    @Override
    public boolean canAttack() {
        if (attackDamage == 0) return false;
        long currentTime = System.currentTimeMillis();
        // cek apakah waktu yang telah berlalu cukup untuk menyerang lagi
        long elapsed = currentTime - lastAttackTime;
        return elapsed >= (attackSpeed * 1000);
    }

    // Getter dan setter untuk cost
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // Getter dan setter untuk range
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    // Getter dan setter untuk cooldown
    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }  
    
    // Getter dan setter untuk harvested
    public boolean isHarvested() {
        return harvested;
    }

    public void setHarvested(boolean harvested) {
        this.harvested = harvested;
    }

    // Method untuk memanen tanaman
    public void harvest() {
        if (!harvested) {
            // Lakukan aksi panen
            harvested = true;
        } else {
            System.out.println("This plant's spot is already empty.");
        }
    }
}

