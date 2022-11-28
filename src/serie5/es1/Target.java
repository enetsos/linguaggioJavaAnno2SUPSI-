package serie5.es1;

public class Target {
    @Extract
    public int theAnswer = 42;

    @Extract("anotherName")
    private String hello = "world";

    private int anotherAnswer;
}
