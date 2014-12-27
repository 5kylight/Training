package home.training.lessons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by tom on 21.12.14.
 */
public class Tree<T extends Comparable<T>> implements BST<T> {

    Logger logger = LogManager.getLogger(Logging.class.getName());
    private Node<T> head;

    public Tree(T val) {
        logger.info("Tree Initialized");
        head = new Node<T>(val);
    }

    public Tree() {
        this.head = null;
    }

    @Override
    public void insert(T val) {
        logger.info("Inserting into Tree");
        Node node = new Node<T>(val);
        if(head == null )
            head = node;
        else {
            insert(node, this.head);
        }
    }

    private void insert(Node node, Node cur) {
        if(node.compareTo(cur) >= 0){
            if(cur.getRight() == null)
                cur.setRight(node);
            else
                insert(node, cur.getRight());
        } else {
            if (cur.getLeft() == null)
                cur.setLeft(node);
            else
                insert(node, cur.getLeft());
        }


    }

    @Override
    public boolean search(T val) {
        Node<T> node = new Node<T>(val);
        if(search(node, head)!= null)return true;
        return false;
    }

    private Node<T> search(Node val, Node head) {
        if( head == null) return null;
        if (val.compareTo(head)==0) return head;
        if(val.compareTo(head) > 0){
            if(head.getRight() == null)
               return null;
            else
               return search(val, head.getRight());
        } else {
            if (head.getLeft() == null)
                return null;
            else {
                return search(val, head.getLeft());
            }
        }


    }


    @Override
    public boolean delete(T val) {
        return false;
    }

    @Override
    public void preorder() {
        logger.info("Preorder Started");
        preorder(head);

    }

    private void preorder(Node cur){

        if(cur == null )return;
        else {
            System.out.print(cur.getVal());
            preorder(cur.getLeft());
            preorder(cur.getRight());
        }
    }

    @Override
    public void inorder() {
        logger.info("Inorder Called");
        if(this.head == null )return;
        inorder(this.head);

    }

    private void inorder(Node cur) {
        if(cur == null )return;
        inorder(cur.getLeft());
        System.out.print(cur.getVal());
        inorder(cur.getRight());

    }
}
