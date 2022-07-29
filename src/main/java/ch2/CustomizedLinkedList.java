package ch2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CustomizedLinkedList<T> {

    private Node<T> head = new Node<>(null);
    private  Node<T> tail = head;
    private int length;

    public void add(T data) {
        this.tail.next = new Node(data);
        this.tail = tail.next;
        this.length++;
    }

    public void add(Node<T> node) {
        this.tail.next = node;
        this.length++;
        this.tail = tail.next;

        Map<Node<T>, Boolean> isVis = new HashMap<>();
        isVis.put(node, true);
        node = node.next;
        while (node != null) {
            if (isVis.put(node, true) != null) {
                break;
            }
            this.length++;
            this.tail = tail.next;
            node = node.next;
        }
    }

    public void addToBegining(T data) {
        Node<T> node = new Node<>(data);
        node.next = head.next;
        head.next = node;
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
        System.out.println();
    }

    public boolean isPalindrome() {
        CustomizedLinkedList<T> reversed = reverseAndClone();
        Node<T> ptr1 = reversed.getHead();
        Node<T> ptr2 = this.getHead();

        while (ptr1 != null && ptr2 != null) {
            if (!ptr1.data.equals(ptr2.data)) {
                return false;
            }
            ptr1= ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1 == null && ptr2 == null;
    }

    public CustomizedLinkedList<T> reverseAndClone() {
        CustomizedLinkedList<T> reveresList = new CustomizedLinkedList<>();
        Node<T> ptr = head.next;
        while(ptr != null) {
            reveresList.addToBegining(ptr.data);
            ptr = ptr.next;
        }
        return reveresList;
    }

    public static<T> Node<T> intersectionFinder1(CustomizedLinkedList<T> list1, CustomizedLinkedList<T> list2){
        int LengthDifference = Math.abs(list1.length - list2.length);
        CustomizedLinkedList<T> longer = list1.length >= list2.length
                ? list1
                : list2;
        CustomizedLinkedList<T> shorter = list1.length >= list2.length
                ? list2
                : list1;
        Node<T> longerListPtr = getKthNodeFromHead(longer, LengthDifference);
        Node<T> shorterListPtr = shorter.getHead();
        while (longerListPtr != null && shorterListPtr != null && shorterListPtr != longerListPtr) {
            longerListPtr = longerListPtr.next;
            shorterListPtr = shorterListPtr.next;
        }

        return longer.tail == shorter.tail ? longerListPtr : null;
    }

    private static<T>  Node<T> getKthNodeFromHead(CustomizedLinkedList<T> list, int k) {
        if (k > list.length) {
            return null;
        }
        Node<T> ptr = list.getHead();
        while(k-- > 0 && ptr != null) {
            ptr = ptr.next;
        }

        return ptr;
    }


    public static<T> boolean isCircular(CustomizedLinkedList<T> list){
        Node<T> fastPtr = list.getHead();
        Node<T> slowPtr = list.getHead();

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                break;
            }
        }
        if (fastPtr == null || fastPtr.next == null) {
            return false;
        }
        return true;
    }

    public static <T> Node<T> findStartOfCircle(CustomizedLinkedList<T> list) {
        Node<T> fastPtr = list.getHead();
        Node<T> slowPtr = list.getHead();

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                break;
            }
        }
        if (fastPtr == null || fastPtr.next == null) {
            return null;
        }

        slowPtr = list.getHead();
        while(slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return fastPtr;
    }



}
