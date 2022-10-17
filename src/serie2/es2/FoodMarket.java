package serie2.es2;

// Food products

abstract class Food {
    public void eat() {
        System.out.println(String.format("Eating %s", toString()));
    }
}

class IceCream extends Food {
    public void freeze() {
        System.out.println("Freezing " + toString());
    }
    
    @Override
    public String toString() {
        return String.format("IceCream %d", hashCode());
    }
}

abstract class Bakery extends Food {
    public void bake() {
        System.out.println("Baking " + toString());
    }
}

class Cake extends Bakery {
    @Override
    public String toString() {
        return String.format("Cake %d", hashCode());
    }
}

class Bread extends Bakery {
    @Override
    public String toString() {
        return String.format("Bread %d", hashCode());
    }
}

public class FoodMarket {

    public static void main(String[] args) {
        
    }
}
