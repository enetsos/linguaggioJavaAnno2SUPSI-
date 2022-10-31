package serie4.es1;

public abstract class Car extends Vehicle {

    public Car(String brand) {
        super(brand, 4);
    }

    @Override
    public String toString() {
        return "Car{} " + super.toString();
    }
}
