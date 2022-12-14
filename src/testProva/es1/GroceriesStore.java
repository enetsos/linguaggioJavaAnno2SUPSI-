package testProva.es1;

import java.util.*;
import java.util.stream.Collectors;

class Item {
    public enum Category {
        BEVERAGES,
        FOOD,
        MEAT,
        VEGETABLES;

        String getPrefix() {
            return this.name().charAt(0) + ":";
        }

        static Category getRandom() {
            final Category[] values = Category.values();
            return values[new Random().nextInt(values.length)];
        }
    }

    private int id;
    private float price;
    private boolean isDiscounted;
    private Category category;

    public Item(int id, float price, Category category) {
        this.id = id;
        this.price = price;
        this.category = category;
        this.isDiscounted = false;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public void applyDiscount(final float discountPercentage) {
        this.isDiscounted = true;
        // Convert percentage to factor
        final float discountFactor = (100 - discountPercentage) / 100;
        // Round price to nearest $0.05
        this.price = (float) Math.floor(this.price * discountFactor / 0.05) * 0.05f;
    }

    @Override
    public String toString() {
        final String format = String.format("%s%03d $%.2f", category.getPrefix(), id, price);
        if (isDiscounted)
            return format + " DISCOUNTED";
        return format;
    }
}

public class GroceriesStore {
    public static void main(String[] args) {
        // Create stock of 20 random items
        List<Item> stock = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final float price = (float) (10000.* Math.random() / 100.0);
            stock.add(new Item(i, price, Item.Category.getRandom()));
        }

        // Show stock
        stock.forEach(System.out::println);

        // Simulate 5 weeks
        for (int week = 0; week < 5; week++) {
            // Establish category and discount for week
            final Item.Category discountCategory = Item.Category.getRandom();
            final float discount =  (float) Math.floor(2 + 20 *(Math.random()) / 0.5) * 0.5f;

            System.out.println(String.format("This weeks promotion: %s %3.1f%% OFF", discountCategory, discount));

            // ------------------------------------------------
            // REMARK: start of exercise section
            // ------------------------------------------------


            List<Item> discountedItems = stock.stream()
                    .filter(item -> item.getCategory().equals(discountCategory))
                    .peek(item -> item.applyDiscount(discount))
                    .sorted(Comparator.comparingDouble(Item::getPrice).reversed())
                    .limit(3)
                    .collect(Collectors.toList());

            discountedItems.forEach(System.out::println);



//            final List<Item> discountedItems = new ArrayList<>();
//            final List<Item> originalPriced = new ArrayList<>();
//
//            for (final Item item : stock) {
//
//                // Save original
//                originalPriced.add(new Item(item.getId(), item.getPrice(), item.getCategory()));
//
//                // Apply discount on selected item
//                if (item.getCategory().equals(discountCategory)) {
//                    item.applyDiscount(discount);
//                    discountedItems.add(item);
//                }
//            }
//
//            // Sort descending, first the most expensive item!
//            Collections.sort(discountedItems, (i1, i2) -> Float.compare(i2.getPrice(), i1.getPrice()));
//
//            // Print most expensive items (may be less than 3)
//            int nItems = Math.min(3, discountedItems.size());
//            for (int itemIndex = 0; itemIndex < nItems; itemIndex++) {
//                System.out.print(discountedItems.get(itemIndex));
//                if (itemIndex < nItems - 1)
//                    System.out.print(", ");
//            }
//            System.out.println();
//
//            // Need to restore original stock prices
//            stock = originalPriced;
            // ------------------------------------------------
            // REMARK: end of exercise section
            // ------------------------------------------------
        }

        // Show stock

        stock.forEach(System.out::println);
    }
}
