import collections.CircularStaticQueue;
import collections.DynamicDeque;
import collections.DynamicQueue;
import collections.StaticDeque;
import collections.StaticQueue;

public class App {
    public static void main(String[] args) throws Exception {
        StaticDeque<String> myDeque = new StaticDeque<>();
        myDeque.add("Alípio");
        myDeque.add("Amilton");
        myDeque.insert("Kézer");
        myDeque.insert("Sidou");
        myDeque.insert("Erfon Spanos");
        // myDeque.add("Luma");
        myDeque.removeFirst();
        System.out.println(myDeque);
        
    }   
}
