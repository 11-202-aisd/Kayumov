public class Queue {
    private Stack inputStack;
    private Stack outputStack;

    public Queue() {
        inputStack = new Stack();
        outputStack = new Stack();
    }

    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public boolean isFull() {
        return inputStack.isFull() && outputStack.isFull();
    }

    public int look() {
        return outputStack.look();
    }

    public boolean push(int elem) throws RuntimeException {
        if (isFull()) {
            throw new RuntimeException("The Queue is full");
        }
        inputStack.push(elem, outputStack);
        return true;
    }

    public int pop() {
        return outputStack.pop(inputStack);
    }

}