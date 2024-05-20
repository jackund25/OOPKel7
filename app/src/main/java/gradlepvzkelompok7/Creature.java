package gradlepvzkelompok7;

public abstract class Creature {
    protected String name;
    protected int health;
    protected int attackDamage;
    protected long attackSpeed;
    protected boolean isAquatic;
    protected long nextAttackTime;

    public Creature(String name, int health, int attackDamage, long attackSpeed, boolean isAquatic) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.isAquatic = isAquatic;
        this.nextAttackTime = System.currentTimeMillis();
    }
    
    public boolean canAttack() {
        long currentTime = System.currentTimeMillis();
        return currentTime >= nextAttackTime;
    }  
    

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }

    public void die(){
        System.out.println(name + "has died"); 
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public long getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(long attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public boolean isAquatic() {
        return isAquatic;
    }

    public void setAquatic(boolean isAquatic) {
        this.isAquatic = isAquatic;
    }

    
}

