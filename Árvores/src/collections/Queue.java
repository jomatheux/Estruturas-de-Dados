package collections;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    E first();
    int size(); // int length();
    boolean isEmpty();
}
