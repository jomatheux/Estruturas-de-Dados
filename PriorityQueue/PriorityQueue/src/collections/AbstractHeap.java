package collections;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class AbstractHeap<K,V> implements PriorityQueue<K,V> {

    class PriorityEntry implements Entry<K,V>{
        K key;
        V value;
        
        public PriorityEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {            
            return key;
        }

        @Override
        public V getValue() {            
            return value;
        }

        @Override
        public String toString() {
            return "{" + key + " : " + value + "}";
        }
    }

    protected int size;
    protected Entry<K,V>[] heap;
    protected Comparator<K> comparator;
    // protected ArrayList<Entry<K,V>> heap2;

    @SuppressWarnings("unchecked")
    public AbstractHeap(){
        heap = new Entry[500];
        comparator = new MyComparator<>();
    }

    protected int compare(int index1, int index2){
        return compare(heap[index1], heap[index2]);
    }

    protected int compare(Entry<K,V> e1, Entry<K,V> e2){
        return comparator.compare(e1.getKey(), e2.getKey());
    }


    public boolean isFull(){
        return size == heap.length;
    }

    @Override
    public boolean isEmpty() {    
        return false;
    }

    @Override
    public int size() {        
        return 0;
    } 

    protected int leftChild(int index){
        return index*2+1;
    }
    protected int rightChild(int index){
        return leftChild(index)+1;
    }
    protected int parent(int index){
        return (index-1)/2;
    }
    protected void swap(int index1, int index2){
        Entry<K,V> auxEntry = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = auxEntry;
    }

    @Override
    public String toString() {
        String heapData = "";
        for(int i = 0 ;i < size; i++){
            heapData += heap[i];
            if(i < size-1){
                heapData +=", ";
            }
        }
        return heapData;
    }

    
    

}
