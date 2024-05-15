package gradlepvzkelompok7;

public class ZombieFactory {

    public static Zombie createZombie(int type) {
        switch (type) {
            case 0:
                return new NormalZombie();
            case 1:
                return new ConeheadZombie();
            case 2:
                return new BucketheadZombie();
            case 3:
                return new FootballZombie();
            case 4:
                return new PoleVaultingZombie();
            case 5:
                return new GargantuarZombie();
            case 6:
                return new NewspaperZombie();
            case 7:
                return new JackInABoxZombie();
            case 8:
                return new DolphinRiderZombie();
            case 9:
                return new DuckyTubeZombie();
            default:
                return new NormalZombie(); // default
        }
    }
}
