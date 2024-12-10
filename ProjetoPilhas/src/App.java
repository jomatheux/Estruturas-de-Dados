import collections.DynamicStack;
import collections.StaticStack;

public class App {
    public static void main(String[] args) throws Exception {
        DynamicStack<Integer> minhaPilha = new DynamicStack<>();
        
        minhaPilha.push(7);
        minhaPilha.push(8);
        minhaPilha.push(1);
        minhaPilha.push(8);
        minhaPilha.push(5);
        System.out.println(minhaPilha);
    }
}
