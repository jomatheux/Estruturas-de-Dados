package collections;

import exceptions.EmptyQueueException;

public class DynamicQueue<E> implements Queue<E> {
    class Node {
        Node next;
        E value;
        public Node(E value) {
            this.value = value;
        }
        
    }

    private Node first;
    private Node last;
    private int size;
    
    @Override
    public E dequeue() {
        if(isEmpty()) throw new EmptyQueueException("Queue is empty!");
        E value = first.value;
        first = first.next;
        if(size == 1){
            last = null;
        }
        size--;        
        return value;
    }

    @Override
    public void enqueue(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;            
        }else{
            last.next = newNode;
        }
        last = newNode;
        size++;
        
    }

    @Override
    public E first() {
        if(isEmpty()) throw new EmptyQueueException("Queue is empty!");
        return first.value;
    }

    @Override
    public boolean isEmpty() {        
        return first == null;
    }

    @Override
    public int size() {        
        return size;
    }
    
    @Override
    public String toString(){
        String queueData = "\\/ first\n";
        Node auxNode = first;
        while(auxNode!=null){
            queueData += auxNode.value;
            if(auxNode.next!=null){
                queueData+=", ";
            }
            auxNode = auxNode.next; 
        }
        String last = "\n";
        for(int i = 0; i < queueData.length()-11;i++){
            last+=" ";
        }
        return queueData + last +"/\\ last";
    }
}
