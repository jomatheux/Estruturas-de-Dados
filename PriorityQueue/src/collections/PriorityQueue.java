package collections;

public interface PriorityQueue<K,V> {
    void enqueue(K key, V value);
    Entry<K,V> maxPriority();
    Entry<K,V> dequeue();
    int size();
    boolean isEmpty();
}
