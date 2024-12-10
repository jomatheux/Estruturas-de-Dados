package collections;

import entities.DefaultComparator;
import java.util.Comparator;

public abstract class AbstractBinaryTree<E> implements Tree<E> {

    class Node{
        Node left;
        Node right;
        E value;
        int height;
        public Node(E value) {
            height = 1;
            this.value = value;
        }
        @Override
        public String toString() {
            return "(" + value + " | h=" + height + ")";
        }
        
        
    }

    protected Node root;
    protected int size;
    protected Comparator<E> comparator;

    
    public AbstractBinaryTree() {
        comparator = new DefaultComparator<>();
    }

    public int compare(Node n1, Node n2){
        return compare(n1.value, n2.value);
    }

    public int compare(E e, Node n){
        return compare(e, n.value);
    }

    public int compare(E e1, E e2){
        return comparator.compare(e1, e2);
    }

    @Override
    public void clear() {
        root = null;
        size = 0;        
    }

    @Override
    public boolean isEmpty() {        
        return root == null;
    }

    @Override
    public int size() {        
        return size;
    }
    
}
