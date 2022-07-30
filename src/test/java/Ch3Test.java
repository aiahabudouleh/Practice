import ch3.Queue;
import ch3.Stack;
import ch3.ThreeInOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ch3Test {

    @Test
    public void test_stack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);


        Assertions.assertEquals(3, stack.peek());
        Assertions.assertEquals(false, stack.isEmpty());
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertEquals(true, stack.isEmpty());
    }

    @Test
    public void test_queue() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(false, queue.isEmpty());
        Assertions.assertEquals(1, queue.remove());
        Assertions.assertEquals(2, queue.remove());
        Assertions.assertEquals(3, queue.remove());
        Assertions.assertEquals(true, queue.isEmpty());

    }

    @Test
    public void test_ThreeInOne() {
        int capacity = 5;
        ThreeInOne threeInOne = new ThreeInOne(capacity);
        threeInOne.push(2, 1);
        threeInOne.push(2, 2);
        threeInOne.push(2, 3);

        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);

        threeInOne.push(1, 1);
        threeInOne.push(1, 2);
        threeInOne.push(1, 3);

        Assertions.assertEquals(3, threeInOne.peek(2));
        Assertions.assertEquals(3, threeInOne.peek(1));
        Assertions.assertEquals(3, threeInOne.peek(0));

        threeInOne.pop(1);
        Assertions.assertEquals(2, threeInOne.peek(1));



    }
}
