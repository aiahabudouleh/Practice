package ch3;

import java.util.ArrayList;
import java.util.List;

public class StackOfPlates<T> {

    private List<Stack<T>> stacks = new ArrayList<>();
    private int capacity;
    private int stackIdx = -1;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public void push(T data) {
        Stack stack = stackIdx == -1 ? null : stacks.get(stackIdx);
        if (stack == null || stack.size() == capacity) {
            stacks.add(new Stack());
            stackIdx++;
            stacks.get(stackIdx).push(data);
        } else {
            stack.push(data);
        }
    }

    public T pop() {
        Stack<T> stack = stacks.get(stackIdx);
        T data = stack.pop();
        if (stack.size() == 0) {
            stacks.remove(stackIdx);
            stackIdx--;
        }
        return data;
    }

    public T popAt(int stackIdx) {
        if (stackIdx < 0 || stackIdx >= stacks.size()) {
            throw new IllegalArgumentException();
        }
        Stack<T> stack = stacks.get(stackIdx);
        T data = stack.pop();
        if (stack.size() == 0) {
            stacks.remove(stackIdx);
        }
        return data;
    }

    public T peek() {
        Stack<T> stack = stacks.get(stackIdx);
        return stack.peek();
    }

    public boolean isEmpty() {
        return stacks.isEmpty();
    }
}
