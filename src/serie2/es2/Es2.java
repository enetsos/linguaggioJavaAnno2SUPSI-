package serie2.es2;
// Food products

import java.util.Collection;
import java.util.LinkedList;

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
abstract class FoodManufacturer<T extends Food>{
    abstract T produce();
    public void addToStock(Collection<? super T> foods){
        foods.add(produce());
    }
}

class Baker extends FoodManufacturer<Bread>{

    @Override
    Bread produce() {
        Bread panino = new Bread();
        panino.bake();
        return panino;
    }
}

class PastryChef extends FoodManufacturer<Cake>{

    @Override
    Cake produce() {
        Cake torta = new Cake();
        torta.bake();
        return torta;
    }
}

class IceCreamMaker extends FoodManufacturer<IceCream>{

    @Override
    IceCream produce() {
        IceCream gelato = new IceCream();
        gelato.freeze();
        return gelato;
    }
}

public class Es2 {

    public static void main(String[] args) {
        Baker panettiere = new Baker();
        PastryChef pasticcere = new PastryChef();
        IceCreamMaker gelataio = new IceCreamMaker();

        LinkedList<IceCream> gelati = new LinkedList<>();
        LinkedList<Bread> panini = new LinkedList<>();
        LinkedList<Cake> torte = new LinkedList<>();

        LinkedList<Food> charityBox = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            panettiere.addToStock(panini);
            pasticcere.addToStock(torte);
            gelataio.addToStock(gelati);
        }
        panettiere.addToStock(charityBox);
        pasticcere.addToStock(charityBox);
        gelataio.addToStock(charityBox);
        System.out.println();
        for (final Food food:charityBox) {
            food.eat();
        }
    }
}
