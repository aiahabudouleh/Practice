package ch3;

public class ThreeInOne {

    private int [] sizes;
    private int [] values;
    private int capacity;
    public ThreeInOne(int stackCapacity){
        this.sizes = new int[3];
        this.values = new int [stackCapacity * 3];
        this.capacity = stackCapacity;
    }

    public void push(int stackNumber, int value) {
        if (sizes[stackNumber] == capacity) {
            throw new IllegalArgumentException();
        }
        confirmStackNumber(stackNumber);
        sizes[stackNumber]++;
        int idx = getTop(stackNumber);
        values[idx] = value;
    }

    public int peek(int stackNumber) {
        int idx = getTop(stackNumber);
        return values[idx];
    }

    public int pop(int stackNumber) {
        int value = values[getTop(stackNumber)];
        sizes[stackNumber]--;
        return value;
    }

    private int getTop(int stackNumber) {
        if (sizes[stackNumber] == 0) {
            throw new NullPointerException();
        }
        return getOffset(stackNumber) + sizes[stackNumber] - 1;
    }

    private int getOffset(int stackNumber) {
        return capacity * stackNumber;
    }

    public boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    private void confirmStackNumber(int stackNumber) {
        if (stackNumber >= 3) {
            throw new IllegalArgumentException();
        }
    }

}
