package collections;

import exceptions.EmptyListException;

public class LinkedList<E> extends DynamicList<E> {

    

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            head = newNode;            
        }else{
            tail.next = newNode;
        }        
        tail = newNode;
        size++;
        
    }
    

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            tail = newNode;            
        }else{
            newNode.next = head;
        }        
        head = newNode;
        size++;
        
    }

    @Override
    public void insert(int index, E value) {
        
        if(index<=0){
            insert(value);
        }else if(index >= size){
            add(value);
        }else{
            Node newNode = new Node(value);
            Node auxNode = getNode(index-1);
            newNode.next = auxNode.next;
            auxNode.next = newNode;
            size++;
        }
        
    }

    

    @Override
    public E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        checkIndex(index);
        E value = null;
        if(index == 0){
            value = removeFirst();
        }else if(index == size-1){
            value = removeLast();
        }else{            
            Node auxNode = getNode(index-1);
            value = auxNode.next.value;
            auxNode.next = auxNode.next.next;
            size--;
        }
        return value;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        E value = head.value;
        if (size == 1) {
            head = null;
            tail = null;
        }else{
            head = head.next;
        }

        size--;
        return value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Linked List is Empty!");
        }
        E value = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        }else{
            Node auxNode = getNode(size-2);
            tail = auxNode;
            tail.next = null;
        }
        size--;
        return value;
    }

    

    

    

    

}
