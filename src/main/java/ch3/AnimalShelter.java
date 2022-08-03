package ch3;

public class AnimalShelter {

    private Queue<Cat> cats = new Queue<>();
    private Queue<Dog> dogs = new Queue<>();

    public void enqueue(Animal animal) {
        if (animal instanceof  Cat) {
            cats.add((Cat) animal);
        } else {
            dogs.add((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        Cat cat = cats.peek();
        Dog dog = dogs.peek();
        if (cat == null) {
            return dog;
        }
        if (dog == null) {
            return cat;
        }
        return cat.compareTo(dog) == 1 ? dogs.remove() : cats.remove();
    }

    public Animal dequeueCat() {
        return cats.remove();
    }

    public Animal dequeueDog() {
        return dogs.remove();
    }
}
