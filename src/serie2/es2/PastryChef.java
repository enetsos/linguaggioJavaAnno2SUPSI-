package serie2.es2;

public class PastryChef extends FoodManufacture{
    public Food produce() {
        return produce(new Cake());
    }
}
