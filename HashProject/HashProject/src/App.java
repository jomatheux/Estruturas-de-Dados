import collections.HashTable;
import java.util.Hashtable;

public class App {
    public static void main(String[] args) throws Exception {
        HashTable<String,Integer> samsungEstoque = new HashTable<>(17);
        samsungEstoque.set("Celular", 300);
        samsungEstoque.set("Celular", 30);
        samsungEstoque.set("Tablet", 45);
        samsungEstoque.set("Smart Watch", 65);
        samsungEstoque.set("Televisão", 65);
        samsungEstoque.set("Laptop", 65);
        samsungEstoque.set("Headphone", 65);
        samsungEstoque.set("Headset", 65);
        samsungEstoque.set("Celular", 300);
        System.out.println(samsungEstoque);
        System.out.println(samsungEstoque.get("Cerular"));
    }


    
}
