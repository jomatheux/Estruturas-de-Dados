package collections;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    class Node{
        Node next;
        Node previous;
        Entry<K,V> entry;

        public Node(K key, V value){
            entry = new PriorityEntry(key, value);
        }
        
        public Node(Entry<K, V> entry) {
            this.entry = entry;
        }
        
    }

    class PriorityEntry implements Entry<K,V>{
        K key;
        V value;
        
        public PriorityEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K newKey) {
            key = newKey;
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

    protected Node first;
    protected Node last;
    protected int size;
    protected Comparator<K> comparator;

    public AbstractPriorityQueue(){
        comparator = new MyComparator<>();
    }

    protected int compare(Entry<K,V> e1, Entry<K,V> e2){
        return comparator.compare(e1.getKey(),e2.getKey());
    }
    protected int compare(Node n1, Node n2){
        return comparator.compare(n1.entry.getKey(),n2.entry.getKey());
    }

    @Override
    public boolean isEmpty() {        
        return size==0;
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        String priorityQueueData = "";
        Node auxNode = first;
        while(auxNode!=null){
            priorityQueueData += auxNode.entry;
            if(auxNode.next != null){
                priorityQueueData += ", ";
            }
            auxNode = auxNode.next;
        }
        return priorityQueueData;
    }

    

    

}
