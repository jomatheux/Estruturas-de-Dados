package collections;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class StaticDeque<E> extends AbstractDeque<E> {

    private E[] deque;
    private int first;

    @SuppressWarnings("unchecked")
    public StaticDeque(){
        deque = (E[]) new Object[5];
    }

    public boolean isFull(){
        return size == deque.length;
    }

    @Override
    public void add(E value) {
        if(isFull()) throw new FullQueueException("Deque is Full!");
        deque[(first+size)%deque.length] = value;
        size++;
        
    }
    
    @Override
    public E first() {
        if(isEmpty()) throw new EmptyQueueException("Deque is empty!");
        return deque[first];
    }
    
    @Override
    public void insert(E value) {
        if(isFull()) throw new FullQueueException("Deque is Full!");
        first = (first - 1 + deque.length)%deque.length;
        deque[first] = value;
        size++;
        
    }
    
    @Override
    public E last() {
        if(isEmpty()) throw new EmptyQueueException("Deque is empty!");        
        return deque[(first+size-1)%deque.length];
    }

    @Override
    public E removeFirst() {
        E value = first();
        first = (first+1)%deque.length;
        size--;
        return value;
    }

    @Override
    public E removeLast() {
        E value = last();
        // deque[(first+size-1)%deque.length] = null;
        size--;
        return value;
    }

    @Override
    public String toString() {
        String dequeData = "";
        for(int i = 0; i < size; i++){
            dequeData += deque[(i+first)%deque.length];
            if(i<size-1){
                dequeData += ", ";
            }
        }
        return dequeData;
    }


    
    

}
