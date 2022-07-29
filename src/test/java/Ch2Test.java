import ch2.CH2;
import ch2.CustomizedLinkedList;
import ch2.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ch2Test {

    @Test
    public void q1_test() {
        CustomizedLinkedList<Integer> list = new CustomizedLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(9);
        list.add(8);
        list.add(1);

        list.removeDuplicates();

        Assertions.assertEquals(4, list.length());
    }

    @Test
    public void q1_test_single() {
        CustomizedLinkedList<Integer> list = new CustomizedLinkedList<>();
        list.add(1);

        list.removeDuplicates();

        Assertions.assertEquals(1, list.length());
    }

    @Test
    public void q1_test_empty() {
        CustomizedLinkedList<Integer> list = new CustomizedLinkedList<>();
        list.removeDuplicates();

        Assertions.assertEquals(0, list.length());
    }

    @Test
    public void q2_test() {
        CustomizedLinkedList<Integer> list = new CustomizedLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Assertions.assertEquals(6, list.getKthToTail(6).data);
    }


    @Test
    public void q2_test_single() {
        CustomizedLinkedList<Integer> list = new CustomizedLinkedList<>();
        list.add(1);
        Assertions.assertEquals(1, list.getKthToTail(1).data);
    }

    @Test
    void q4_test() {
        CustomizedLinkedList<Integer> list = new CustomizedLinkedList<>();
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(8);
        list.add(10);
        list.add(2);
        list.add(1);

        list.partitionAround(5);

        CustomizedLinkedList<Integer> expected = new CustomizedLinkedList<>();
        expected.add(3);
        expected.add(2);
        expected.add(1);
        expected.add(5);
        expected.add(5);
        expected.add(8);
        expected.add(10);

        Node<Integer> ptr1 = list.getHead().next;
        Node<Integer> ptr2 = expected.getHead().next;

        list.printList();
        System.out.println();
        expected.printList();
        while (ptr1.next != null) {
            Assertions.assertEquals(ptr2.data, ptr1.data);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
    }

    @Test
    public void q5_test() {
        CustomizedLinkedList<Integer> list1 = new CustomizedLinkedList<>();
        list1.add(9);
        list1.add(9);
        list1.add(9);

        CustomizedLinkedList<Integer> list2 = new CustomizedLinkedList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);

        CH2.q5(list1, list2);
    }

    @Test
    public void q6_test() {
        CustomizedLinkedList<Integer> list = new CustomizedLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(false, list.isPalindrome());

        CustomizedLinkedList<Integer> list1 = new CustomizedLinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(1);
        Assertions.assertEquals(true, list1.isPalindrome());

    }

    @Test
    public void q7_test() {
        CustomizedLinkedList<Integer> list1 = new CustomizedLinkedList<>();
        CustomizedLinkedList<Integer> list2 = new CustomizedLinkedList<>();

        Node<Integer> node1= new Node<>(7);
        node1.next = new Node(2);
        node1.next.next = new Node(1);

        list1.add(3);
        list1.add(1);
        list1.add(5);
        list1.add(9);

        list2.add(4);
        list2.add(6);

        list1.add(node1);
        list2.add(node1);

        Node<Integer> intersctionNode = list1.intersectionFinder1(list1, list2);
        Assertions.assertEquals(node1, intersctionNode);
    }
}
