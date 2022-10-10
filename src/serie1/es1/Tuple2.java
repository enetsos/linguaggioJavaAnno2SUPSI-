package serie1.es1;

public class Tuple2<T1,T2> {
    final private T1 first;
    final private T2 second;

    public Tuple2(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
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
