package gradlepvzkelompok7;

public class DolphinRiderZombie extends Zombie implements Jumping {
    private boolean hasJumped = false;

    public DolphinRiderZombie() {
        super("Dolphin Rider Zombie", 175, 100, 1, true);
    }

    public void setHasJumped(boolean Boolean) {
        this.hasJumped = Boolean;
    } 
    
    public boolean hasJumped() {
        return hasJumped;
    }    
    
}
