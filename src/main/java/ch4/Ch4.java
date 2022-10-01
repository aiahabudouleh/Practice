package ch4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Ch4 {

    public static boolean RouteBetweenNode(Map<Integer, List<Integer>> graph, Integer src, Integer des) {
        //BFS
        Queue<Integer> queue = new LinkedList<Integer>();
        Map<Integer, Boolean> vis = new HashMap<>();

        queue.add(src);

        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            vis.put(cur, true);
            if (cur == des) {
                return true;
            }
            List<Integer> neighbours = graph.get(cur);
            for (Integer n: neighbours) {
                if (vis.getOrDefault(cur, false)) {
                   continue;
                }
                queue.add(n);
            }

        }
        return false;
    }

    public static Node createMinimalTree(int[] arr) {
        return createMinimalBST(arr, 0, arr.length -1);
    }

    private static Node createMinimalBST(int[] arr, int start ,int end) {
        if (end < start) {
            return null;
        }
        int mid = (end + start) / 2;
        Node root = new Node(arr[mid]);
        root.setLeft(createMinimalBST(arr, start, mid-1));
        root.setRight(createMinimalBST(arr, mid+1, end));
        return root;
    }

    public static void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeft());
        System.out.println(node.getData());
        printInOrder(node.getRight());
    }

    public static<T> List<List<Node<T>>> createListOfDepths(Node<T> root) {
        List<List<Node<T>>> depths = new ArrayList<>();
        fillListOfDepths(depths, 0, root);
        return depths;
    }

    private static <T> void fillListOfDepths(List<List<Node<T>>> depths, int depth, Node<T> cur) {
        if (cur == null) {
            return;
        }

        List<Node<T>> sameDepth = null;
        if (depths.size() == depth) {
            sameDepth = new ArrayList<>();
            depths.add(sameDepth);
        } else {
            sameDepth = depths.get(depth);
        }
        sameDepth.add(cur);
        fillListOfDepths(depths, depth + 1, cur.getLeft());
        fillListOfDepths(depths, depth + 1, cur.getRight());
    }

    public static <T> boolean isBalanced(Node<T> root) {
        if (root == null) {
            return true;
        }

        if(Math.abs(getHeight(root.getLeft()) - getHeight(root.getRight())) <= 1) {
           return isBalanced(root.getLeft()) && isBalanced(root.getRight());
        } else {
            return false;
        }
    }

    public static <T> int getHeight(Node<T> node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        if (leftHeight == Integer.MIN_VALUE || rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1 ;
    }

    public static<Integer> boolean isBST(Node<Integer> node) {
        if (node == null) {
            return true;
        }
        return isBST(node, null, null);
    }

    private static<Integer> boolean isBST(Node<Integer> node, Node<Integer> min, Node<Integer> max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.getDataAsInt() <= min.getDataAsInt())
                && (max != null && node.getDataAsInt() > max.getDataAsInt())) {
            return false;
        }
        if(!isBST(node.getLeft(), min, node) || !isBST(node.getRight(), node, max)) {
            return false;
        }
        return true;
    }

    public static <T> Node<T> findSuccessor(Node<T> root) {
        if (root.getRight() != null) {
            //Most left of right
            return getMostLeftNode(root.getRight());
        } else {
            Node<T> p = root.getParent();
            Node<T> c = root;

            while (p != null && p.getLeft() != c) {
               c = p;
               p = p.getParent();
            }
            return p;
        }


    }

    private static <T> Node<T> getMostLeftNode(Node<T> cur) {
        while (cur.getLeft() != null) {
            cur = cur.getLeft();
        }
        return cur;
    }
}
