package collections;

import exceptions.EmptyStackException;

public class DynamicStack<E> implements Stack<E> {

    class Node{
        Node next;
        E value;
        public Node(E value) {
            this.value = value;
        }
        
    }

    private int height;
    private Node top;
    private Node bottom;

    @Override
    public int height() {        
        return height;
    }

    @Override
    public boolean isEmpty() {        
        return height == 0;
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new EmptyStackException("Stack is empty!");        
        return top.value;
    }

    @Override
    public E pop() {
        if(isEmpty()) throw new EmptyStackException("Stack is empty!");
        E value = top.value;
        if(height == 1){
            bottom = null;
        }
        top = top.next;
        height--;
        return value;
    }

    @Override
    public void push(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            bottom = newNode;
        }
        newNode.next = top;
        top = newNode;
        height++;        
    }

    @Override
    public String toString() {
        String stackData = "";
        Node auxNode = top;
        while(auxNode!=null){
            stackData+=auxNode.value;
            if(auxNode == top){
                stackData+=" <- top";
            }
            if(auxNode.next!=null){
                stackData+="\n";
            }
            auxNode = auxNode.next;
        }
        return stackData + " <- bottom\n";
    }


    
    

}
