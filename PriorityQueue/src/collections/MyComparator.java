package collections;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<T> {

    @Override
    @SuppressWarnings("unchecked")
    public int compare(T o1, T o2) {        
        //
        if(o1 instanceof String){
            if(((String)o1).length() < ((String)o2).length()){
                return -1;
            }
        }
        return ((Comparable<T>)o1).compareTo(o2);
    }


}
