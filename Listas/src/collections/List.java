package collections;

import exceptions.EmptyListException;

public interface List<E> {
    void add(E value);
    void insert(E value);
    void insert(int index, E value);

    E removeLast() throws EmptyListException;
    E removeFirst() throws EmptyListException;
    E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException;

    void set(int index, E value) throws EmptyListException, IndexOutOfBoundsException;
    E get(int index) throws EmptyListException, IndexOutOfBoundsException;

    int size();
    boolean isEmpty();
    void clear();

}
