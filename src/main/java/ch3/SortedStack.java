package ch3;

public class SortedStack<T> {

    private Stack<T> stack = new Stack<>();
    private Stack<T> buffer = new Stack<>();

    public void push(T data) {
        stack.push(data);
        sort();
    }

    public T peek() {
        return stack.peek();
    }

    public T pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    private void sort() {
        while (!stack.isEmpty()) {
            T tmp = stack.pop();
            while(!buffer.isEmpty() && buffer.peek().hashCode() > tmp.hashCode()) {
                stack.push(buffer.pop());
            }
            buffer.push(tmp);
        }

        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }
}
