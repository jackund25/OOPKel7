package gradlepvzkelompok7;

public class JackInABoxZombie extends Zombie {
    public JackInABoxZombie(){
        super("Jack-in-a-box Zombie", 150, 5000, 1, false);
    }
    
    @Override
    public void zombieAttack(Creature target) {
        if (canAttack()) {
            System.out.println("plant initial health = " + target.getHealth());
            target.takeDamage(attackDamage);
            this.health = 0; //kamikaze
            System.out.println(target.getName() + " taken damage " + attackDamage + ", " +target.getName() + " hp is now " + target.getHealth() + ", " + this.getName() + " suicide");
            nextAttackTime = 1000000;
        }

    }
}

