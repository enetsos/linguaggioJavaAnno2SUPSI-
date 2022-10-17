package serie2.es2;

import java.util.ArrayList;

public abstract class FoodManufacture{


    public Food produce(Food food) {

        if (food instanceof Bakery) {
            ((Bakery) food).bake();
        } else if (food instanceof IceCream) {
            ((IceCream) food).freeze();
        }

        return food;
    }

}
