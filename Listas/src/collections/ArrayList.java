package collections;

import exceptions.FullListException;

public class ArrayList<E> extends StaticList<E> {

    @SuppressWarnings("unchecked")
    public ArrayList(){
        list = (E[]) new Object[5];
    }
    @SuppressWarnings("unchecked")
    public ArrayList(int initialMaxSize){
        if(initialMaxSize <=1){
            initialMaxSize = 2;
        }
        list = (E[]) new Object[initialMaxSize];
    }
    
    @SuppressWarnings("unchecked")
    private void recreateArray(){
        E[] auxiliarList = (E[]) new Object[list.length + list.length*2/3];

        for(int i = 0; i < size; i++){
            auxiliarList[i] = list[i];
        }
        list = auxiliarList;
    }

    @Override
    public void add(E value) throws FullListException {
        if(isFull()){
            recreateArray();
        }

        list[size++] = value;
    }

    @Override
    public void insert(E value) {
        if(isFull())
            recreateArray();   

        for(int i = size; i > 0; i--){
            list[i] = list[i-1];
        }
        list[0] = value;
        size++;
    }

    @Override
    public void insert(int index, E value) throws FullListException {
        if(isFull())
            recreateArray();
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

    

    

}
