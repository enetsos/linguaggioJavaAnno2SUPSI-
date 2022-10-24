package serie3.es2;

public class CustomStack implements AdvancedStack {
    private StackElement head;

    private class StackElement {
        private StackElement next;
        private Object valore;

        public StackElement(Object valore) {
            this.valore = valore;
        }

        public StackElement getNext() {
            return next;
        }

        public StackElement setNext(StackElement next) {
            this.next = next;
            return this;
        }

        @Override
        public String toString() {
            return "StackElement{" +
                    "valore=" + valore +
                    '}';
        }
    }

    public void push(Object o) {
        StackElement newStackElement = new StackElement(o);
        if (head == null) {
            head = newStackElement;
            return;
        }
        StackElement current = head;
        while (current.getNext() != null) {
            current = current.next;
        }
        newStackElement.next = null;
        current.next = newStackElement;
    }

    @Override
    public Object pop() {
        if (head == null) {
            return null;
        }
        StackElement current = head;
        StackElement previous = null;
        while (current.getNext() != null) {
            previous = current;
            current = current.next;
        }
        if (previous != null) {
            previous.next = null;
        } else {
            head = null;
        }
        return current.valore;
    }

    @Override
    public Object peek() {
        if (head == null) {
            return null;
        }
        StackElement current = head;
        while (current.getNext() != null) {
            current = current.next;
        }
        return current.valore;
    }

    @Override
    public long size() {
        if (head == null) {
            return 0;
        }
        StackElement current = head;
        long size = 1;
        while (current.getNext() != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public long count(Evaluate testLogic) {
        if (head == null) {
            return 0;
        }
        StackElement current = head;
        long count = 0;
        while (current.getNext() != null) {
            if (testLogic.verify(current.valore)) {
                count++;
            }
            current = current.next;
        }
        return count;
    }
}
