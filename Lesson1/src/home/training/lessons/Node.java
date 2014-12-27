package home.training.lessons;

/**
 * Created by tom on 21.12.14.
 */

public class Node<T extends Comparable<T>> implements Comparable<Node> {

    private T val;
    private Node<T> right;
    private Node<T> left;


    // Let's make it Comparable!
    @Override
    public int compareTo(Node o) {
        T temp = (T) o.getVal();
        if ( val.compareTo(temp) > 0) return 1;
        if(val.compareTo(temp)<  0) return -1;
        return 0;

    }


    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}

