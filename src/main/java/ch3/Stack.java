package ch3;

public class Stack<T> {

    private static class Node<T> {
        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node() {

        }
    }

    private Node<T> head = new Node<>();
    private int size = 0;

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public int size() {
        return size;
    }

    public T pop() {
        T top = getTopElement();
        head.next = head.next == null ? null : head.next.next;
        size--;
        return top;
    }

    private T getTopElement() {
        T top = head.next == null ? null : head.next.data;
        return top;
    }

    public T peek() {
        return getTopElement();
    }

    public boolean isEmpty() {
        return head.next == null;
    }
}
