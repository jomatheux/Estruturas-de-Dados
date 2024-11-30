package collections;

import exceptions.EmptyListException;

public abstract class DynamicList<E> implements List<E> {


    class Node{
        Node next;
        Node previous;
        E value;
        public Node(E value) {
            this.value = value;
            next = null;
        }
    }


    protected int size;
    protected Node head;
    protected Node tail;

    
    protected void checkIndex(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Valid indexes are [0 ~ "+(size-1)+"]");
        }
    }

    protected Node getNode(int index){
        Node auxNode = head;
        for(int i = 0; i< index;i++){
            auxNode = auxNode.next;
        }
        return auxNode;
    }

    @Override
    public void clear() {
       head = null;
       tail = null;
       size = 0;        
    }

    @Override
    public E get(int index) throws EmptyListException, IndexOutOfBoundsException {
        if(isEmpty()) throw new EmptyListException("Linked List is Empty!");
        checkIndex(index);
        return getNode(index).value;
    }

    @Override
    public boolean isEmpty() {        
        return tail == null;
    }

    @Override
    public void set(int index, E value) throws EmptyListException, IndexOutOfBoundsException {
        if(isEmpty()) throw new EmptyListException("Linked List is Empty!");
        checkIndex(index);
        getNode(index).value = value;        
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        String listData = "[";
        Node auxNode = head;

        while(auxNode!=null){
            listData += auxNode.value;
            // System.out.print(auxNode.value+"->");
            if(auxNode.next != null){
                listData+="->";
            }
            auxNode = auxNode.next;
        }
        // for(int i = 0; i < size; i++){
        //     listData += auxNode.value;
        //     if(i < size-1){
        //         listData+="->";
        //     }
        //     auxNode = auxNode.next;

        // }

        return listData+"]";
    }

}
