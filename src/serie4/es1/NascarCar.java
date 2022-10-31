package serie4.es1;

public class NascarCar extends RacingCar {

    public NascarCar(String brand, int carNumber, String pilotName) {
        super(brand, carNumber, pilotName);
    }

    @Override
    public String toString() {
        return "NascarCar{} " + super.toString();
    }
}
