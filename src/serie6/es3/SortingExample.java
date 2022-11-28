package serie6.es3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class MySortingLogic implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        final boolean o1IsOdd = o1.intValue() % 2 == 1;
        final boolean o2IsOdd = o2.intValue() % 2 == 1;
        if (o1IsOdd && o2IsOdd)
            return Integer.compare(o1, o2);
        else if (!o1IsOdd && !o2IsOdd)
            return Integer.compare(o2, o1);
        return (o1IsOdd)? 1 : -1;
    }
}

public class SortingExample {

    private static List<Integer> original = null;

    private static List<Integer> generate() {
        // init
        if (original == null) {
            original = new ArrayList<>();
            final Random random = new Random();
            for (int i = 0; i < 15; i++) {
                original.add(random.nextInt(100));
            }
        }
        final List<Integer> list = new ArrayList<>();
        list.addAll(original);
        return list;
    }

    public static void main(String[] args) {
        testReference();

        testAnonymousInnerClass();

        testLambda();

        testInstanceMethodReference();

        testStaticMethodReference();
    }

    private static void testReference() {
        System.out.println("Reference");
        final List<Integer> list = generate();

        list.sort(new MySortingLogic());

        list.forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }

    private static void testAnonymousInnerClass() {
        System.out.println("Anonymous inner class:");
        final List<Integer> list = generate();

        // FIXME to implement!
        // list.sort( ... );

        list.forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }

    private static void testLambda() {
        System.out.println("Lambda reference:");
        final List<Integer> list = generate();

        // FIXME to implement!
        // list.sort( ... );

        list.forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }

    private static void testInstanceMethodReference() {
        System.out.println("Instance method reference:");
        final List<Integer> list = generate();

        // FIXME to implement!
        // list.sort( ... );

        list.forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }
    private static void testStaticMethodReference() {
        System.out.println("Static method reference:");
        final List<Integer> list = generate();

        // FIXME to implement!
        // list.sort( ... );

        list.forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }
}
