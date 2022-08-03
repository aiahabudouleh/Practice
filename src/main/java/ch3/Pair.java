package ch3;

public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof  Pair) {
            Pair otherPair = (Pair) other;
            return otherPair.key.equals(this.key) && otherPair.value.equals(this.value);
        }
        return false;
    }
}
