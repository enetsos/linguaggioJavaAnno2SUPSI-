package serie1.es1;

public class Tuple1<T> {
    final private T first;
    final private T second;

    public Tuple1(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public Tuple1 swap() {
        return new Tuple1(second, first);
    }

    @Override
    public String toString() {
        return String.format("Tuple1(%s, %s)", first.toString(), second.toString());
    }
}
