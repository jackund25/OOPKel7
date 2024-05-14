package gradlepvzkelompok7;

public class NewspaperZombie extends Zombie{
    public NewspaperZombie() {
        super("Newpaper Zombie", 150, 100, 1, false);
    }
    @Override
    public void zombieAttack(Creature target) {
        if (this.health < 100 && this.attackSpeed != (long) 0.5) {
            this.attackSpeed = (long) 0.5 ; 
            System.out.println("Newspaper Zombie's attack speed has increased!");
        }
        
        super.zombieAttack(target); 
    }
}
