package gradlepvzkelompok7;

import java.util.List;

public class TangleKelp extends Plant{


    public TangleKelp() {
        super("Tangle kelp", 100, 5000, 0, true, 50, 1, 20);
    }
    
    @Override
    public void plantAction(List<Zombie> targetZombies) {
        super.plantAction(targetZombies);
        this.health = 0;
    }       
  
}