package collections;

import exceptions.EmptyListException;

public class DoublyLinkedList<E> extends DynamicList<E> {

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            head = newNode;
        }else{
            newNode.previous = tail;
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
            head.previous = newNode;
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
            Node auxNode = getNode(index);
            newNode.next = auxNode;
            newNode.previous = auxNode.previous;
            auxNode.previous.next = newNode;
            auxNode.previous = newNode;
            size++;
        }
        
    }

    @Override
    public E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
        if(isEmpty()){
            throw new EmptyListException("Doubly Linked List is Empty!");
        }
        checkIndex(index);
        E value = null;
        if(index == 0){
            value = removeFirst();
        }else if(index == size-1){
            value = removeLast();
        }else{
            Node auxNode = getNode(index);
            value =  auxNode.value;
            auxNode.previous.next = auxNode.next;
            auxNode.next.previous = auxNode.previous;
            size--;
        }        
        return value;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Doubly Linked List is Empty!");
        }
        E value = head.value;
        head = head.next;
        if(size==1){
            tail = null;
        }else{
            head.previous = null;
        }
        size--;
        return value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException("Doubly Linked List is Empty!");
        E value = tail.value;
        tail = tail.previous;
        if(size == 1){
            head = null;
        }else{
            tail.next = null;
        }
        size--;
        return value;
    }

    public String printReverse(){
        String listData = "[";
        Node auxNode = tail;
        while(auxNode != null){
            listData += auxNode.value;
            if(auxNode.previous!=null){
                listData+="->";
            }
            auxNode = auxNode.previous;
        }
        return listData + "]";
    }

    

}
