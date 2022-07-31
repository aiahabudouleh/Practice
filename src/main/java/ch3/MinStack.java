package ch3;

public class MinStack<T> extends Stack<T> {

    private Stack<T> minTracker = new Stack<>();
    private T minData = null;

    public T min() {
        return minTracker.peek();
    }

    @Override
    public void push(T data) {
        super.push(data);
        if (minData == null || data.hashCode() < minData.hashCode()) {
            minData = data;
            minTracker.push(data);
        }
    }

    @Override
    public T pop() {
        T data = super.pop();
        if (data == minData){
            minTracker.pop();
            minData = minTracker.peek();
        }
        return data;
    }
}
