package collections;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class Heap<K,V> extends AbstractHeap<K,V> {

    @Override
    public Entry<K, V> dequeue() {
        Entry<K,V> auxEntry = maxPriority();
        heap[0] = heap[--size];
        if(size>1){
            sinkDown();
        }
        return auxEntry;
    }

    private void sinkDown(){
        int current, min = 0;
        int leftChild, rightChild;
        do{
            current = min;
            leftChild = leftChild(current);
            rightChild = rightChild(current);
            if(leftChild < size && compare(leftChild, min)<=0){
                min = leftChild;
            }
            if(rightChild<size && compare(rightChild, min)<0){
                min = rightChild;
            }
            swap(current, min);
        }while(current!=min);
    }

    @Override
    public void enqueue(K key, V value) { // O(log n)
        if(isFull()) throw new FullQueueException("Heap is full!");
        heap[size++] = new PriorityEntry(key, value);
        int current = size-1;
        int parent = parent(current);
        while(current > 0 && compare(current, parent)<0){
            swap(current, parent);
            current = parent;
            parent = parent(current);
        }
        
    }

    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new EmptyQueueException("Heap is empty!");
        return heap[0];
    }

    

}
