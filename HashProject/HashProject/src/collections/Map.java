package collections;

public interface Map<K,V> {
    void set(K key, V value); // adiciona quanto edita
    Entry<K,V> get(K key);
    Entry<K,V> delete(K key);
    boolean isEmpty();
    int size();

}
