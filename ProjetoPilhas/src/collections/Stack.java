package collections;

public interface Stack<E> {
    void push(E value); //insere
    E pop(); // remove
    E peek(); //E top(); verifica o topo.
    boolean isEmpty();
    int height();

}
