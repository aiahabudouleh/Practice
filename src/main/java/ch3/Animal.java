package ch3;


public interface Animal extends Comparable<Animal> {

    long getArrivalTime();

    @Override
    default int compareTo(Animal animal) {
        return Long.compare(this.getArrivalTime(), animal.getArrivalTime());
    }


}
