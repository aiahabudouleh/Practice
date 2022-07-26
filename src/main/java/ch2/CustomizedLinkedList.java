package ch2;

import java.util.HashSet;

public class CustomizedLinkedList<T> {

    private Node<T> head = new Node<>(null);
    private  Node<T> tail = head;
    private int length;

    public void add(T data) {
        this.tail.next = new Node(data);
        this.tail = tail.next;
        this.length++;
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
       Node<T> beforeStart = null;
       Node<T> beforeEnd = null;
       Node<T> afterStart = null;
       Node<T> afterEnd = null;

       Node<T> ptr = head.next;
       while(ptr != null) {
           if (ptr.data.hashCode() < x.hashCode()) {
               if (beforeStart == null) {
                   beforeStart = new Node<>(ptr.data);
                   beforeEnd = beforeStart;
               } else {
                   beforeEnd.next = new Node(ptr.data);
                   beforeEnd = beforeEnd.next;
               }

           } else if (ptr.data.hashCode() > x.hashCode()) {
               if (afterStart == null) {
                   afterStart = new Node<>(ptr.data);
                   afterEnd = afterStart;
               } else {
                   afterEnd.next = new Node(ptr.data);
                   afterEnd = afterEnd.next;
               }

           } else {
               if (afterStart == null) {
                   afterStart = new Node<>(ptr.data);
                   afterEnd = afterStart;
               } else {
                   afterEnd.next = new Node<>(ptr.data);
                   afterEnd = afterEnd.next;
               }
           }

           ptr = ptr.next;
       }

        if (afterStart == null ) {
            this.head.next = afterStart;
            this.tail = afterEnd;
            return;
        }
        if (afterEnd != null) {
            beforeEnd.next = afterStart;
            this.head.next = beforeStart;
            this.tail = afterEnd;
            return;
        }


    }


    public void printList() {
        Node<T> ptr = head.next;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
    }


}
