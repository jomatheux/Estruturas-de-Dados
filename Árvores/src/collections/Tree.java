package collections;

public interface Tree<E> {
    void insert(E value);
    void clear();
    E delete(E value);
    E get(E value);
    boolean contains(E value);
    int size();
    boolean isEmpty();
    String treeTraversal(String type);
}
