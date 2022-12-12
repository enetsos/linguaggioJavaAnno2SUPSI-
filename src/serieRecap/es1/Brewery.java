package serieRecap.es1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

abstract class Beer {
    private final double abv;
    private final String name;
    private final String origin;

    public Beer(String nome, String origin, double abv) {
        this.name = nome;
        this.origin = origin;
        this.abv = abv;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public double getAbv() {
        return abv;
    }

    @Override
    public String toString() {
        return String.format(" - name: %s, origin: %s, abv: %.1f%%", getName(), getOrigin(), getAbv());
    }
}

class Trappist extends Beer {
    public Trappist(String nome, double abv) {
        super(nome, "Belgium, Netherlands", abv);
    }

    @Override
    public String toString() {
        return "Trappist" + super.toString();
    }
}

class PaleAle extends Beer {
    public PaleAle(String nome, double abv) {
        super(nome, "England", abv);
    }

    @Override
    public String toString() {
        return "Pale Ale" + super.toString();
    }
}

class Weisse extends Beer {
    public Weisse(String nome, double abv) {
        super(nome, "Germany", abv);
    }

    @Override
    public String toString() {
        return "Weisse" + super.toString();
    }
}

public class Brewery<T extends Beer> {
    public static void add(List<? extends Beer> listBeer, Class<? extends Beer> t, Collection<Beer> collection) {
        for (Beer b : listBeer) {
            if (b.getClass().equals(t)) {
                collection.add(b);
            }
        }
    }

    public static List<Beer> filter(List<Beer> beerList, Class<? extends Beer> type) {
        return beerList.stream().filter(item -> item.getClass().equals(type)).collect(Collectors.toList());
    }

    public static <T extends Beer> List<T> filterGeneric(Collection<Beer> beers, Class<T> type) {
        final List<T> selection = new ArrayList<>();
        for (final Beer beer : beers) {
            if (type.isAssignableFrom(beer.getClass())) {
                selection.add(type.cast(beer));
            }
        }
        return selection;
    }

    public static void main(String[] args) {
        List<Beer> beers = Arrays.asList(
                new Weisse("BRLO", 4),
                new Trappist("Rochefort 10", 11.3),
                new PaleAle("Brewdog dead pony", 3.8),
                new Trappist("Achel blonde", 8),
                new Weisse("Amundsden Lush", 5.3)
        );

        System.out.println("add (Weisse)");
        final List<Beer> addedWeisse = new ArrayList<>();
        add(beers, Weisse.class, addedWeisse);
        addedWeisse.forEach(System.out::println);

        System.out.println("add (Weisse)");
        final List<Beer> filterTrappist = filter(beers, Trappist.class);
        filterTrappist.forEach(System.out::println);

        System.out.println("filterGeneric (PaleAle)");
        final List<PaleAle> paleAles = filterGeneric(beers, PaleAle.class);
        paleAles.forEach(System.out::println);
    }

}
