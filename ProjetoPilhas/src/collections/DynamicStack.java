package collections;

import exceptions.EmptyStackException;
import collections.Stack;

public class DynamicStack<E> implements Stack<E>{

    class Node{
        E value;
        Node next;
        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node top;
    private Node bottom;
    private int height;

    @Override
    public void push(E value) {
        if (isEmpty()) {
            Node newNode = new Node(value);
            top = newNode;
            bottom = newNode;
            height++;
        }else {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            height++;
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }else {
            E value = top.value;
            top = top.next;
            height--;
            return value;
        }
    }

    @Override
    public E peek() {
        E value = top.value;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return height == 0;
    }

    @Override
    public int height() {
        return this.height;
    }

    public String toString() {
        String stackData = "";
        Node aux = top;
        while (aux!= null) {
            stackData+=aux.value;
            if (aux == top){
                stackData+= "<-top";
            }
            if (aux.next!=null){
                stackData+= "\n";
            }
            aux = aux.next;
        }
        return stackData + "<- bottom\n";
    }
}
