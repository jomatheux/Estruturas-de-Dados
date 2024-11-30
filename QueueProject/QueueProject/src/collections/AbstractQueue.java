package collections;

public abstract class AbstractQueue<E> implements Queue<E> {

    protected int size;

    @Override
    public boolean isEmpty() {        
        return size == 0;
    }

    @Override
    public int size() {        
        return size;
    }
    
}
