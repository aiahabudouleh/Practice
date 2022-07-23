package ch2;

public class Node<T> {

    public Node next;
    public T data;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node() {

    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    @Override
    public int hashCode() {
        return this.data.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Node)) {
            return false;
        }

        Node<T> otherN = (Node<T>) other;
        return otherN.data.equals(this.data);
    }
}
