package home.training.lessons;

/**
 * Created by tom on 21.12.14.
 */
public interface BST<T extends Comparable<T>> {
    public void insert(T val);
    public boolean search(T val);
    public boolean delete(T val);
    public void preorder();
    public void inorder();


}
