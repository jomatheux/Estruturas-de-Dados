package collections;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class MaxHeap<K,V> extends AbstractHeap<K,V> {

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
        int current, max = 0;  
        int leftChild, rightChild;
        do{
            current = max; 
            leftChild = leftChild(current);
            rightChild = rightChild(current);
            if(leftChild < size && compare(leftChild, max)>=0){ 
                max = leftChild; 
            }
            if(rightChild<size && compare(rightChild, max)>0){ 
                max = rightChild; 
            }
            swap(current, max); 
        }while(current!=max); 
    }

    private void sinkDown(int index){
        int current, max = index;  
        int leftChild, rightChild;
        do{
            current = max; 
            leftChild = leftChild(current);
            rightChild = rightChild(current);
            if(leftChild < size && compare(leftChild, max)>=0){ 
                max = leftChild; 
            }
            if(rightChild<size && compare(rightChild, max)>0){ 
                max = rightChild; 
            }
            swap(current, max); 
        }while(current!=max); 
    }

    @Override
    public void enqueue(K key, V value) { // O(log n)   bubbling up
        if(isFull()) throw new FullQueueException("Heap is full!");
        heap[size++] = new PriorityEntry(key, value);
        int current = size-1;
        int parent = parent(current);
        while(current > 0 && compare(current, parent)>0){  
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

    public void increasePriority(K key, K newKey) {
        int index = 0;
        for(int i = 0; i<size;i++){
            if(heap[i].getKey() == key){
                index = i;
            }
        }
        heap[index].setKey(newKey);
        int current = index;
        int parent = parent(index);

        if(compare(current, parent)>0) {
            while(current > 0 && compare(current, parent)>0){  
                swap(current, parent);
                current = parent;
                parent = parent(current);
            }
        }
        if(compare(current, leftChild(current))<0) {
            sinkDown(index);
        }else if(compare(current, rightChild(current))<0) {
            sinkDown(index);
        }

    }

    public Entry<K, V> deleteEntry(K key) {
        int index = 0;
        for(int i = 0; i<size;i++){
            if(heap[i].getKey() == key){
                index = i;
            }            
        }
        Entry<K,V> auxEntry = heap[index];
        
        heap[index] = heap[--size];
        if(size>1){
            sinkDown(index);
        }

        return auxEntry;
    }

    

}
