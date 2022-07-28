package ch2;

public class CH2 {

    public static void q1(CustomizedLinkedList list) {
        list.removeDuplicates();
    }

    public static Node q2(CustomizedLinkedList list, int k) {
        return list.getKthToTail(k);
    }

    public static void q3() {
        //Solved in q1
    }

    public static void q4(CustomizedLinkedList<Integer> list, Integer x) {
        list.partitionAround(x);
    }

    public static void q5(CustomizedLinkedList<Integer> list1, CustomizedLinkedList<Integer> list2) {
        Node<Integer> sumHead = reverseSummation(list1.getHead(), list2.getHead(), 0);
        while (sumHead != null) {
            System.out.print(sumHead.data + " ");
            sumHead = sumHead.next;
        }
    }

    private static Node<Integer> reverseSummation(Node<Integer> ptr1, Node<Integer> ptr2, int carry) {
        if (ptr1 == null && ptr2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        if (ptr1 != null) {
            value += ptr1.data;
        }
        if (ptr2 != null) {
            value += ptr2.data;
        }
        Node<Integer> result = new Node<>(value % 10);
        if (ptr1 != null || ptr2 != null) {
            result.next = reverseSummation(ptr1 != null ? ptr1.next : null, ptr2 != null ? ptr2.next : null, value / 10);
        }
        return result;
    }


}
