package collections;

import exceptions.EmptyQueueException;

public class UnsortedPriorityQueue<K,V>  extends AbstractPriorityQueue<K,V> {



    @Override
    public void enqueue(K key, V value) {  // O(1)
        Node newNode = new Node(key,value);
        if(isEmpty()){
            first = newNode;
        }else{
            newNode.previous = last;
            last.next = newNode;
        }
        last = newNode;
        size++;        
    }

    private Node maxPriorityNode(){
        if(isEmpty()) throw new EmptyQueueException("PQ is empty!");
        Node maxPriority = first;
        Node auxNode = first.next;
        while (auxNode!=null) {
           int c = compare(auxNode, maxPriority);
            if(c<0){
                maxPriority = auxNode;
            }
           auxNode = auxNode.next;
        }
        return maxPriority;
    }

    @Override
    public Entry<K, V> maxPriority() {   //O(n)     
        return maxPriorityNode().entry;
    }

    @Override
    public Entry<K, V> dequeue() {
        Node toRemove = maxPriorityNode();
        if(toRemove == first){
            first = first.next;
            if(size == 1){
                last = null;
            }else{
                first.previous = null;
            }
        }else if(toRemove == last){
            last = last.previous;
            last.next = null;
        }else{
            toRemove.previous.next = toRemove.next;
            toRemove.next.previous = toRemove.previous;
        }
        size--;
        return toRemove.entry;
    }

    

}
