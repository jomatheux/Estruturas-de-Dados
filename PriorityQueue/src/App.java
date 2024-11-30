import collections.Heap;
import collections.MaxHeap;
import collections.SortedPriorityQueue;
import collections.UnsortedPriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        MaxHeap<Integer,String> maxHeap = new MaxHeap<>();
        
        
        maxHeap.enqueue(10, "Erfon Spanos");
        maxHeap.enqueue(21, "Raimundo Ferreira");
        maxHeap.enqueue(13, "Kézer Araújo");
        maxHeap.enqueue(33, "JP");
        maxHeap.enqueue(25, "Luma");
        maxHeap.enqueue(14, "Sofya");
        maxHeap.enqueue(18, "Raquel Q.");
        maxHeap.enqueue(0, "Isaac Newton");
        maxHeap.enqueue(0, "Isaac deagle");
        System.out.println(maxHeap);
        maxHeap.deleteEntry( 0);
        System.out.println(maxHeap);


        


    }
}
