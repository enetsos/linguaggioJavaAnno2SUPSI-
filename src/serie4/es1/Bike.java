package serie4.es1;

public abstract class Bike extends Vehicle {

    public Bike(String brand) {
        super(brand, 2);
    }

    @Override
    public String toString() {
        return "Bike{} " + super.toString();
    }
}
