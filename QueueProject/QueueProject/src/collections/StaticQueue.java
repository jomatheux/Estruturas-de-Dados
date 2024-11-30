package collections;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class StaticQueue<E> extends AbstractQueue<E> {

    private E[] queue;    

    
    @SuppressWarnings("unchecked")
    public StaticQueue() {
        queue = (E[]) new Object[10];
    }

    @Override
    public E dequeue() {
        if(isEmpty()) throw new EmptyQueueException("Queue is empty!");
        size--;
        E value = first();
        for(int i = 0; i < size; i++){
            queue[i] = queue[i+1];
        }
        
        return value;
    }

    @Override
    public void enqueue(E value) {
        if(isFull()) throw new FullQueueException("Queue is full");
        queue[size++] = value;
        
    }

    @Override
    public E first() {
        if(isEmpty()) throw new EmptyQueueException("Queue is empty!");
        return queue[0];
    }   

    public boolean isFull(){
        return size == queue.length;
    } 

    @Override
    public String toString() {
        String queueData = "V first\n";

        for(int i = 0; i < size; i++){
            queueData += queue[i];
            if(i<size-1){
                queueData += ", ";
            }
        }
        String last = "\n";
        for(int i = 0; i < queueData.length()-11;i++){
            last+=" ";
        }
        return queueData + last +" /\\ last" ;
    }


    
    

}
