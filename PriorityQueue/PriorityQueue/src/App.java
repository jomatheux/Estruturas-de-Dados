import collections.Heap;
import collections.SortedPriorityQueue;
import collections.UnsortedPriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Heap<Integer,String> heap = new Heap<>();
        
        
        heap.enqueue(10, "Erfon Spanos");
        heap.enqueue(21, "Raimundo Ferreira");
        heap.enqueue(13, "Kézer Araújo");
        heap.enqueue(33, "JP");
        heap.enqueue(25, "Luma");
        heap.enqueue(14, "Sofya");
        heap.enqueue(18, "Raquel Q.");
        heap.enqueue(0, "Isaac Newton");
        System.out.println(heap);
        heap.dequeue();
        System.out.println(heap);


    }
}
