package collections;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class CircularStaticQueue<E> extends AbstractQueue<E> {

    private E[] queue;
    private int first;

    public CircularStaticQueue(){
        queue = (E[]) new Object[5];
    }

    @Override
    public E dequeue() {
        E value = first();
        // queue[first] = null;
        first = (first + 1)%queue.length;
        size--;
        return value;
    }

    @Override
    public void enqueue(E value) {
        if(isFull()) throw new FullQueueException("Queue is full!");
        queue[(first + size++)%queue.length] = value;
    }

    @Override
    public E first() {
        if(isEmpty()) throw new EmptyQueueException("Queue is empty!");
        return queue[first];
    }

    public boolean isFull(){
        return size == queue.length;
    }

    @Override
    public String toString() {
        String queueData = "";
        for(int i = 0; i < size; i++){
            queueData += queue[(first+i)%queue.length];
            if(i<size-1){
                queueData += ", ";
            }
        }
        return queueData;
    }

    
    

}
