package collections;

import exceptions.EmptyStackException;

import exceptions.FullStackException;

public class StaticStack<E> implements Stack<E> {

    private int height;
    private E[] stack;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxSize){
        stack = (E[]) new Object[maxSize];
        
    }
    @SuppressWarnings("unchecked")
    public StaticStack(){
        stack = (E[]) new Object[10];
    }

    @Override
    public int height() {        
        return height;
    }

    @Override
    public boolean isEmpty() {        
        return height == 0;
    }

    public boolean isFull(){
        return height == stack.length;
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new EmptyStackException("Stack is Empty");
        
        return stack[height-1];
    }

    @Override
    public E pop() {
        if(isEmpty()) throw new EmptyStackException("Stack is Empty");
        // height--;
        return stack[--height];
    }

    @Override
    public void push(E value) {
        if(isFull()) throw new FullStackException("Stack is Full!");
        stack[height++] = value;
        // height++;        
    }
    @Override
    public String toString() {
        String stackData = "top -> ";
        for(int i = height-1; i > -1; i--){
            stackData+=stack[i];
            if(i>0){
                stackData+="\n       ";
            }
        }
        return stackData+=" <- bottom";
    }

    

    

}
