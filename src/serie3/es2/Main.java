package serie3.es2;

public class Main {

    public static void main(String[] args) {

        CustomStack stack = new CustomStack();

        stack.push(1);
        stack.push(2);
        stack.push("a");
        stack.push("b");
        stack.push(3.0);
        stack.push(4.0);

        System.out.println(stack.count(new AdvancedStack.Evaluate() {
            @Override
            public boolean verify(Object objectToTest) {
                return objectToTest instanceof Integer;
            }
        }));

        System.out.println(stack.count(new AdvancedStack.Evaluate() {
            @Override
            public boolean verify(Object objectToTest) {
                return objectToTest instanceof String;
            }
        }));

        System.out.println(stack.count(new AdvancedStack.Evaluate() {
            @Override
            public boolean verify(Object objectToTest) {
                return objectToTest instanceof Double;
            }
        }));
    }
}
