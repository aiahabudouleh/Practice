package ch3;

public class QueueViaStack<T> {

    private Stack<T> stack = new Stack<>();
    private Stack<T> buffer = new Stack<>();

    public void add(T data) {
        stack.push(data);
    }

    public T peek() {
        moveToBuffer();
        T data = buffer.peek();
        moveToStack();
        return data;
    }

    public T remove() {
        moveToBuffer();
        T data = buffer.pop();
        moveToStack();
        return data;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    private void moveToBuffer() {
        while(!stack.isEmpty()) {
            buffer.push(stack.pop());
        }
    }

    private void moveToStack() {
        while(!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }
}
