package ch4;

public class Node<T> {

    private Node<T> left;
    private Node<T> right;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public T getData() {
        return this.value;
    }

    public Integer getDataAsInt() {
        return Integer.parseInt(this.value.toString());
    }

    @Override
    public String toString() {
        return getData().toString();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Node)) {
            return false;
        }
        Node o = (Node) other;
        return o.getData() == this.getData();
    }

}
