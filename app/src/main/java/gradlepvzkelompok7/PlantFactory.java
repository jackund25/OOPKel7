package gradlepvzkelompok7;

public class PlantFactory {

    public static Plant createPlant(String plantType) {
        if (plantType == null) {
            throw new IllegalArgumentException("Plant type cannot be null");
        }

        switch (plantType.toLowerCase()) {//biar case insensitive
            case "peashooter":
                return new Peashooter();
            case "repeater":
                return new Repeater();
            case "chomper":
                return new Chomper();
            case "lilypad":
                return new Lilypad();
            case "jalapeno":
                return new Jalapeno();
            case "sunflower":
                return new Sunflower();
            case "wall nut":
                return new Wallnut();
            case "squash":
                return new Squash();
            case "tangle kelp":
                return new TangleKelp();
            case "snow pea":
                return new Snowpea();
            case "tanglekelp":
                return new TangleKelp();
            case "snowpea":
                return new Snowpea();
            default:
                throw new IllegalArgumentException("Unknown plant type: " + plantType);
        }
    }
}


