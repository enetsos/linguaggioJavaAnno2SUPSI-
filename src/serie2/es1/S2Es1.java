package serie2.es1;

class WrongFuelException extends Exception {
    private static final long serialVersionUID = 1L;
}

abstract class Fuel {
    private int amount;
    
    public Fuel(int amount) {
        this.amount = amount;
    }
    
    public void add(Fuel f) throws WrongFuelException {
        final Class<? extends Fuel> class1 = this.getClass();
        final Class<? extends Fuel> class2 = f.getClass();
        if (!class1.equals(class2))
            throw new WrongFuelException();
        this.amount += f.amount;
    }
    
    @Override
    public String toString() {
        return String.format("%s [amount=%s]", getClass().getSimpleName(), amount);
    }
}

class Petrol extends Fuel implements IHybridFuelAlternative{
    public Petrol(int amount) {
        super(amount);
    }
}

class Diesel extends Fuel implements IHybridFuelAlternative{
    public Diesel(int amount) {
        super(amount);
    }
}

class NaturalGas extends Fuel {
    public NaturalGas(int amount) {
        super(amount);
    }
}

interface Electric {
    void recharge(int amount);
}

class Car <T extends Fuel>{
    private String name;
    private T tank;
    
    public Car(String name, T tank) {
        this.name = name;
        this.tank = tank;
    }
    public void tank(T fuel) throws WrongFuelException {
        tank.add(fuel);
    }
    
    @Override
    public String toString() {
        return String.format("%s, tank=%s", name, tank);
    }
}

class HybridCar  <T extends Fuel & IHybridFuelAlternative> extends Car implements Electric {

    private int charge = 0;
    
    public HybridCar(String name, T tank) {
        super(name, tank);
        if (NaturalGas.class.isInstance(tank))
            throw new RuntimeException("Hybrid cars cannot have NaturalGas as alternative source.");
    }

    @Override
    public void recharge(int amount) {
        charge += amount;
    }

    @Override
    public String toString() {
        return String.format("%s, charge=%s", super.toString(), charge);
    }
}

public class S2Es1 {

    private static void refillPetrol(Car c) {
        try {
            c.tank(new Petrol(15));
            System.out.println(c +  " refilled with Petrol");
        } catch (WrongFuelException e) {
            System.err.println(c + " wrong fuel added to tank");
        }
    }
    
    private static void refillDiesel(Car c) {
        try {
            c.tank(new Diesel(10));
            System.out.println(c +  " refilled with Diesel");
        } catch (WrongFuelException e) {
            System.err.println(c + " wrong fuel added to tank");
        }
    }
    
    private static void refillNaturalGas(Car c) {
        try {
            c.tank(new NaturalGas(10));
            System.out.println(c +  " refilled with NaturalGas");
        } catch (WrongFuelException e) {
            System.err.println(c + " wrong fuel added to tank");
        }
    }
    
    private static void rechargeElectric(HybridCar c) {
        c.recharge(150);
        System.out.println(c +  " recharged");
    }
    
    public static void main(String[] args) {

        // Test petrol car
        Car petrolCar = new Car("PetrolCar", new Petrol(100));
        refillPetrol(petrolCar);
        refillDiesel(petrolCar);
        refillNaturalGas(petrolCar);

        // Test diesel car
        Car dieselCar = new Car("DieselCar", new Diesel(100));
        refillPetrol(dieselCar);
        refillDiesel(dieselCar);
        refillNaturalGas(dieselCar);
        
        // Test natural gas car
        Car naturalGasCar = new Car("NaturalGasCar", new NaturalGas(100));
        refillPetrol(naturalGasCar);
        refillDiesel(naturalGasCar);
        refillNaturalGas(naturalGasCar);

        // Test hybrid petrol car
        HybridCar hybridPetrolCar = new HybridCar("HybridPetrolCar", new Petrol(100));
        refillPetrol(hybridPetrolCar);
        refillDiesel(hybridPetrolCar);
        refillNaturalGas(hybridPetrolCar);
        rechargeElectric(hybridPetrolCar);

        // Test hybrid diesel car
        HybridCar hybridDieselCar = new HybridCar("HybridDieselCar", new Diesel(100));
        refillPetrol(hybridDieselCar);
        refillDiesel(hybridDieselCar);
        refillNaturalGas(hybridDieselCar);
        rechargeElectric(hybridDieselCar);

        // Test Hybrid natural gas car
        HybridCar hybridNaturalGasCar = new HybridCar("HybridNaturalGasCar", new NaturalGas(100));
        refillPetrol(hybridNaturalGasCar);
        refillDiesel(hybridNaturalGasCar);
        refillNaturalGas(hybridNaturalGasCar);
        rechargeElectric(hybridNaturalGasCar);
    }
}
