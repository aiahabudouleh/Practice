package ch3;

public class Cat implements Animal {

    private long arrivalTime;

    public Cat() {
        arrivalTime = System.currentTimeMillis();
    }

    public Cat(long arrivalTime) {
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
        if (other instanceof Cat) {
            return ((Cat) other).getArrivalTime() == this.getArrivalTime();
        }
        return false;
    }
}
