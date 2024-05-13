package gradlepvzkelompok7;


public class PoleVaultingZombie extends Zombie{
    private boolean hasJumped = false;

    public PoleVaultingZombie() {
        super("Pole Vaulting Zombie", 175, 100, 1, false);
    }

    public void setHasJumped(boolean Boolean) {
        this.hasJumped = Boolean;
    } 
    
    public boolean hasJumped() {
        return hasJumped;
    }
}
