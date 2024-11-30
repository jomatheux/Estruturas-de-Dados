package collections;

import exceptions.EmptyListException;
import exceptions.FullListException;

public class StaticList<E> implements List<E> {

    protected int size;
    protected E[] list;
    private final int MAX_SIZE = 5;
    
    @SuppressWarnings("unchecked")
    public StaticList(){
        // size = 0;
        list =(E[]) new Object[MAX_SIZE];
    }

    @SuppressWarnings("unchecked")
    public StaticList(int initialSize){
        // size = 0;
        list =(E[]) new Object[initialSize];
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("valid indexes are [0~"+(size-1)+"]");
    }

    public boolean isFull(){
        return size == list.length;
    }

    @Override
    public void add(E value) throws FullListException {
        if(isFull()){
            throw new FullListException("Static List is Full!");
        }
        list[size++] = value;
    }

    @Override
    public void clear() {
        size= 0;
        
    }

    @Override
    public E get(int index) throws EmptyListException, IndexOutOfBoundsException {
        if(isEmpty()) throw new EmptyListException("Static List is empty!");
        checkIndex(index);
        return list[index];
    }

    @Override
    public void insert(E value) {
        if(isFull())
            throw new FullListException("Static list is full");    

        for(int i = size; i > 0; i--){
            list[i] = list[i-1];
        }
        list[0] = value;
        size++;
    }
        
    
    @Override
    public void insert(int index, E value) throws FullListException {
            
        if(isFull())
            throw new FullListException("Static list is full");   
        if(index<=0){
            insert(value);
        }else if(index>=size){
            add(value);
        }else{
            for(int i = size; i > index; i--){
                list[i] = list[i-1];
            }
            list[index] = value;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
        if(isEmpty()) throw new EmptyListException("Static List is Empty");
        checkIndex(index);
        E value = list[index];
        size--;
        for(int i = index; i < size; i++ ){
            list[i] = list[i+1];
        }
        return value;       
        
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException("Static List is Empty");
        return removeByIndex(0);
    }

    @Override
    public E removeLast() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException("Static List is Empty");
        
        // list[size-1] = null;
        // size--;
        return list[--size];
    }

    @Override
    public void set(int index, E value) throws EmptyListException, IndexOutOfBoundsException {
        if(isEmpty()) throw new EmptyListException("Static List is empty!");
        checkIndex(index);
        list[index] = value;        
    }

    @Override
    public int size() {        
        return size;
    }

    @Override
    public String toString() {
        String data = "[";
        for(int i = 0; i < size; i++){
            data += list[i];
            if(i < size-1){
                data += ", ";
            }
        }

        return data + "]";
    }


    

    

}
