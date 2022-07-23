package ch2;

import java.util.HashSet;

public class CustomizedLinkedList<T> {

    private Node<T> head = new Node<>();
    private int length;

    public void add(T data) {
        Node<T> ptr = head;
        while(ptr.next != null) {
            ptr = ptr.next;
        }
        length++;
        ptr.next = new Node(data);
    }

    public void add(Node node) {
        Node<T> ptr = head;
        while(ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = node;
        while (ptr.next != null) {
            length++;
        }
    }

    public int length() {
        return length;
    }

    public Node<T> getHead() {
        return head.next;
    }

    public void removeDuplicates() {
        Node<T> ptr = head, trail = ptr;

        HashSet<T> buffer = new HashSet<>();
        while (ptr != null) {
            if (!buffer.add(ptr.data)) {
                trail.next = ptr.next;
                length--;
            }
            trail = ptr;
            ptr = ptr.next;
        }
    }

    public Node<T> getKthToTail(int k) {
        Node<T> ptr = head;
        return k > length || k <= 0 ? null : getKthToTailHelper(ptr, k);
    }

    private Node<T> getKthToTailHelper(Node<T> node, int k) {
        if (k == 0) {
            return node;
        }
        return getKthToTailHelper(node.next, k-1);
    }

    public void partitionAround(T x) {

    }


}
