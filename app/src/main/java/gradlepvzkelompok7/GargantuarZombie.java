package gradlepvzkelompok7;

public class GargantuarZombie extends Zombie {
    private boolean hasThrownJavelin = false; 

    public GargantuarZombie() {
        super("Gargantuar Zombie", 400, 5000, 4, false); // Example health and attack
    }

    public boolean isReadyToThrow() {
        //kalo hp ny ud turun dibawah 200 (1/2 darah awal) sama belum perna lempar maka bisa lempar
        return this.health < 250 && !hasThrownJavelin;
    }

    public void setHasThrownJavelin(boolean hasThrown) {
        this.hasThrownJavelin = hasThrown;
    }

    @Override
    public void zombieAttack(Creature target) {
        if (isReadyToThrow()) {
            return; // skip ngeattack
        }
        //attack biasa
        else {super.zombieAttack(target);}
    }
}