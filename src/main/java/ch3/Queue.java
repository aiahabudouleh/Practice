package ch3;

public class Queue<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node() {
            this.next = null;
        }
    }

    private Node<T> top = new Node<>();
    private Node<T> bottom = top;

    public void add(T data) {
        Node<T> node = new Node(data);
        bottom.next = node;
        bottom = node;
    }

    public T remove() {
        T first = getFirstElement();
        top = top.next != null ? top.next : top;
        return first;
    }

    private T getFirstElement() {
        return top.next == null ? null : top.next.data;
    }

    public T peek(){
        return getFirstElement();
    }

    public boolean isEmpty() {
        return top.next == null;
    }
}
