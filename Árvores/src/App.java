import collections.AVLTree;
import collections.BinarySearchTree;
import collections.RecursiveBinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
        AVLTree<Integer> myBst = new AVLTree<>();
        // 50 32 40 9 345 1 30 25 35 0
        myBst.insert(50);
        myBst.insert(32);
        myBst.insert(40);
        myBst.insert(9);
        myBst.insert(345);
        myBst.insert(1);
        myBst.insert(30);
        myBst.insert(25);
        myBst.insert(35);
        myBst.insert(0);
        
        
       
 
 
        System.out.println(myBst.treeTraversal("preOrder"));
        // System.out.println(myBst.delete(50));
        // System.out.println(myBst.treeTraversal("preOrder"));
        // System.out.println(myBst.treeTraversal("postOrder"));
   

    }
}
