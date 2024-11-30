package collections;

import exceptions.EmptyQueueException;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    @Override
    public Entry<K, V> dequeue() { //O(1)
        Entry<K,V> entry = maxPriority();
        first = first.next;
        if(size == 1){
            last = null;
        }else{
            first.previous = null;
        }
        size--;
        return entry;
    }

    @Override
    public void enqueue(K key, V value) {
        Node newNode = new Node(key,value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            if(compare(newNode, first)<0){
                newNode.next = first;
                first.previous = newNode;
                first = newNode;
            }else if(compare(newNode,last)>=0){
                newNode.previous = last;
                last.next = newNode;
                last = newNode;
            }else{
                Node auxNode = first;
                while(compare(newNode, auxNode)>=0){
                    auxNode = auxNode.next;
                }
                newNode.next = auxNode;
                newNode.previous = auxNode.previous;
                auxNode.previous.next = newNode;
                auxNode.previous = newNode;
            }
        }
        size++;        
        
    }

    @Override
    public Entry<K, V> maxPriority() {
        if(isEmpty()) throw new EmptyQueueException("PQ is empty!");        
        return first.entry;
    }

    

}
