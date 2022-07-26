import ch4.Ch4;
import ch4.DAGraph;
import ch4.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static ch4.Ch4.createListOfDepths;
import static ch4.Ch4.createMinimalTree;
import static ch4.Ch4.findSuccessor;
import static ch4.Ch4.isBST;
import static ch4.Ch4.isBalanced;
import static ch4.Ch4.printInOrder;

public class Ch4Test {

    @Test
    public void testCreateMinimalBST() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node root = createMinimalTree(arr);
        printInOrder(root);
    }

    @Test
    public void testSameDepth() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        Node root = createMinimalTree(arr);
        List<List<Node<Integer>>> depths = createListOfDepths(root);
        Assertions.assertArrayEquals(Arrays.asList(new Node(4)).toArray(), depths.get(0).toArray());
        Assertions.assertArrayEquals(Arrays.asList(new Node(2), new Node(6)).toArray(), depths.get(1).toArray());
        Assertions.assertArrayEquals(Arrays.asList(new Node(1), new Node(3), new Node(5), new Node(7)).toArray(), depths.get(2).toArray());
    }

    @Test
    public void testBalancedBT() {
        Node<Integer> root = new Node<>(5);
        root.setRight(new Node(6));
        root.getRight().setRight(new Node(7));
        Assertions.assertEquals(false, isBalanced(root));

        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        root = createMinimalTree(arr);
        Assertions.assertEquals(true, isBalanced(root));

    }

    @Test
    public void testIsBST() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        Node root = createMinimalTree(arr);
        Assertions.assertEquals(true, isBST(root));
    }

    @Test
    public void testFindSuccessor() {
        Node<Integer> root = new Node<>(6);
        root.setLeft(new Node(3));
        root.setRight(new Node(9));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(4));

        root.getRight().setLeft(new Node(8));
        root.getRight().setRight(new Node(10));

        root.getLeft().getLeft().setLeft(new Node(1));

        root.getRight().getLeft().setLeft(new Node(7));
        root.getRight().getRight().setRight(new Node(11));

        Assertions.assertEquals(new Node<Integer>(6), findSuccessor(root.getLeft().getRight()));
    }

    @Test
    public void testTopologicalSort() {
        DAGraph<Integer> graph = new DAGraph<>();
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 1);
        graph.addEdge(4, 0);

        Ch4.topologicalSort(graph);
    }
}
