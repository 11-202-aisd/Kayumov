public class Stack {
    private int[] numbers;
    private int size;
    private int length;

    public Stack() {
        this(10);
    }

    public Stack(int length) {
        numbers = new int[length];
        size = 0;
        this.length = length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == length;
    }

    public int look() {
        return numbers[size - 1];
    }

    public boolean push(int elem, Stack output) throws StackOverflowError {
        if (output != null) {
            output.push(elem, null);
            return true;
        }
        numbers[size] = elem;
        size++;
        return true; 
    }

    public int pop(Stack input) {
        int elem = numbers[0];
        for (int i = 0; i < size; i++) {
            numbers[i] = numbers[i + 1];
        }
        size--;
        if (input != null && !input.isEmpty()) {
            push(input.pop(null), null);
        }
        return elem;
    }
}
