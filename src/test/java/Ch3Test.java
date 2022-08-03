import ch3.MinStack;
import ch3.Queue;
import ch3.QueueViaStack;
import ch3.SortedStack;
import ch3.Stack;
import ch3.StackOfPlates;
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

    @Test
    public void test_minStack() {
        MinStack<Integer> stack = new MinStack<>();
        stack.push(5);
        Assertions.assertEquals(5, stack.min());
        stack.push((2));
        Assertions.assertEquals(2, stack.min());
        Assertions.assertEquals(2, stack.peek());
        stack.push(10);
        Assertions.assertEquals(2, stack.min());
        Assertions.assertEquals(10, stack.peek());
        stack.pop();
        stack.pop();
        Assertions.assertEquals(5, stack.min());

    }

    @Test
    public void test_stackOfPlates() {
        StackOfPlates<Integer> plates = new StackOfPlates<>(3);
        Assertions.assertEquals(true, plates.isEmpty());
        plates.push(1);
        plates.push(2);
        plates.push(3);
        plates.push(4);
        plates.push(5);
        plates.push(6);
        plates.push(7);
        plates.push(8);

        Assertions.assertEquals(8, plates.peek());
        Assertions.assertEquals(8, plates.pop());
        Assertions.assertEquals(7, plates.pop());
        Assertions.assertEquals(3, plates.popAt(0));
    }

    @Test
    public void test_q4() {
        QueueViaStack<Integer> queue = new QueueViaStack<>();
        Assertions.assertEquals(true, queue.isEmpty());

        queue.add(1);
        queue.add(2);

        Assertions.assertEquals(1, queue.peek());
        Assertions.assertEquals(1, queue.remove());

        queue.add(3);
        Assertions.assertEquals(2, queue.peek());
        Assertions.assertEquals(2, queue.remove());

    }

    @Test
    public void test_q5() {
        SortedStack<Integer> sortedStack = new SortedStack();
        Assertions.assertEquals(true, sortedStack.isEmpty());
        sortedStack.push(2);
        sortedStack.push(5);
        sortedStack.push(3);
        sortedStack.push(1);

        Assertions.assertEquals(1, sortedStack.peek());
        Assertions.assertEquals(1, sortedStack.pop());
        Assertions.assertEquals(2, sortedStack.pop());
        Assertions.assertEquals(3, sortedStack.pop());
        Assertions.assertEquals(5, sortedStack.pop());

        Assertions.assertEquals(true, sortedStack.isEmpty());
    }
}
