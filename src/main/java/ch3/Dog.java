package ch3;


public class Dog implements Animal{

    private long arrivalTime;

    public Dog() {
        arrivalTime = System.currentTimeMillis();
    }

    public Dog(Long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public long getArrivalTime() {
        return arrivalTime;
    }


    @Override
    public int hashCode() {
        return (int) (this.arrivalTime % Integer.MAX_VALUE);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Dog) {
            return ((Dog) other).getArrivalTime() == this.getArrivalTime();
        }
        return false;
    }
}
