package serie4.es1;

public abstract class Vehicle {

    final private String brand;

    final private int numWheels;

    public Vehicle(String brand, int numWheels) {
        this.brand = brand;
        this.numWheels = numWheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", numWheels=" + numWheels +
                '}';
    }
}
