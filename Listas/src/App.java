import java.util.ArrayList;

import collections.DoublyLinkedList;
import collections.LinkedList;
import collections.List;
import collections.StaticList;

public class App {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<>();
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(2);        
        lista.insert(999);
        lista.insert(1,57);
        System.out.println(lista);
        System.out.println(lista.printReverse());
        System.out.println("Removendo: "+lista.removeLast());
        System.out.println(lista);
        System.out.println(lista.printReverse());

    }
}
