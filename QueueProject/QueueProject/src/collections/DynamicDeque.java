package collections;

import exceptions.EmptyQueueException;

public class DynamicDeque<E> extends AbstractDeque<E> {

    class Node{
        Node next;
        Node previous;
        E value;
        public Node(E value) {
            this.value = value;
        }        
    }

    private Node first;
    private Node last;

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;
        }else{
            newNode.previous = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
        
    }

    @Override
    public E first() {
        if(isEmpty()) throw new EmptyQueueException("Deque is empty!");
        return first.value;
    }
    
    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            last = newNode;
        }else{
            newNode.next = first;
            first.previous = newNode;
        }
        first = newNode;
        size++;
        
    }
    
    @Override
    public E last() {
        if(isEmpty()) throw new EmptyQueueException("Deque is empty!");        
        return last.value;
    }
    
    @Override
    public E removeFirst() {
        E value = first();
        first = first.next;
        if(size==1){
            last = null;
        }else{
            // first.previous.next = null;
            first.previous = null;
        }

        size--;
        return value;
    }

    @Override
    public E removeLast() {
        E value = last();
        last = last.previous;
        if(size==1){
            first = null;
        }else{
            last.next = null;
        }
        size--;
        return value;

    }

    public String reverseDeque(){
        String dequeData = "";
        Node auxNode = last;
        while(auxNode!=null){
            dequeData += auxNode.value;
            if(auxNode.previous!=null){
                dequeData+=", ";
            }
            auxNode = auxNode.previous;
        }
        return dequeData;
    }

    @Override
    public String toString() {
        String dequeData = "";
        Node auxNode = first;
        while(auxNode!=null){
            dequeData += auxNode.value;
            if(auxNode.next!=null){
                dequeData+=", ";
            }
            auxNode = auxNode.next;
        }
        return dequeData;
    }

    
    

}
