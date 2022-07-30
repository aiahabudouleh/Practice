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
        int idx = getOffset(stackNumber);
        values[idx] = value;
        sizes[stackNumber]++;
    }

    public int peek(int stackNumber) {
        int idx = getLastElementIdx(stackNumber);
        return values[idx];
    }

    public int pop(int stackNumber) {
        int value = values[getLastElementIdx(stackNumber)];
        sizes[stackNumber]--;
        return value;
    }

    private int getLastElementIdx(int stackNumber) {
        if (sizes[stackNumber] == 0) {
            throw new NullPointerException();
        }
        return (capacity * stackNumber) + sizes[stackNumber] - 1;
    }

    public boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    private void confirmStackNumber(int stackNumber) {
        if (stackNumber >= 3) {
            throw new IllegalArgumentException();
        }
    }

    private int getOffset(int stackNumber) {
        return (capacity * (stackNumber + 1)) - sizes[stackNumber] - 1;
    }


}
