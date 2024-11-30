package collections;

public interface Entry<K,V> {
    K getKey();
    void setKey(K key);
    V getValue();
}
