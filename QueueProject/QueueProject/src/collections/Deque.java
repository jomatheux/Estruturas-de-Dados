package collections;
public interface Deque<E> {

    void add(E value);
    void insert(E value);
    E removeFirst();
    E removeLast();
    E first();
    E last();
    int size();
    boolean isEmpty();

}
