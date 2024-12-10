package collections;

public class RecursiveBinarySearchTree<E> extends AbstractBinaryTree<E> {

    @Override
    public boolean contains(E value) {
        return contains(root, value);
    }

    private boolean contains(Node current, E value) {
        if(current == null){
            return false;
        }
        if(compare(value, current)<0){
            return contains(current.left, value);
        } else if(compare(value, current)>0){
            return contains(current.right, value);
        } else{
            return true;
        }
    }

    public void mirror() {
        root = mirror(root);
    }

    private Node mirror(Node current){
        if(current == null){
            return null;
        }
        
        Node leftMirror = mirror(current.left);
        Node rightMirror = mirror(current.right);

        current.left = rightMirror;
        current.right = leftMirror;
        
        return current;
    }

    private Node minNode(Node current){
        if(current.left == null){
            return current;
        }
        return minNode(current.left);
    }

    private Node delete(Node current, E value){
        if(current == null){

            return null;
        }
        if(compare(value, current)<0){

            current.left = delete(current.left, value);
        }else if(compare(value, current)>0){
            current.right = delete(current.right, value);
        }else{
            if(current.left == null && current.right == null){
                size--;
                current = null;
            }else if(current.left!=null && current.right != null){
                current.value = minNode(current.right).value;
                current.right = delete(current.right, current.value);
                
            }else{
                size--;
                current = current.left!=null? current.left: current.right;
            }
        }
        
        return current;
    }

    @Override
    public E delete(E value) {
        int auxiliarSize = size;
        root = delete(root,value);
        if(size!=auxiliarSize){
            return value;
        }
        return null;
    }

    @Override
    public E get(E value) {
        return get(root, value);
    }

    private E get(Node current, E value){
        if(current == null){
            return null;
        }

        if(compare(value, current)==0){
            return current.value;
        }else if(compare(value, current)<0){
            return get(current.left, value);
        }else{
            return get(current.right, value);
        }
    }

    private Node insert(Node current, E value){
        if(current == null){
            size++;
            return new Node(value);
        }
        if(compare(value, current)>0){
            current.right = insert(current.right, value);
        }else if(compare(value, current)<0){
            current.left = insert(current.left, value);
            //esquerda
        }
        return current;
    }
    @Override
    public void insert(E value) {
        root = insert(root, value);
    }

    private String preOrder(Node current, String data){

        if(current!=null){
            data += current.value +" ";
            data = preOrder(current.left, data);
            data = preOrder(current.right, data);
        }

        return data;
    }
    private String postOrder(Node current, String data){

        if(current!=null){
            data = postOrder(current.left, data);
            data = postOrder(current.right, data);
            data += current.value +" ";
        }

        return data;
    }
    private String inOrder(Node current, String data){

        if(current!=null){
            data = inOrder(current.left, data);
            data += current.value +" ";
            data = inOrder(current.right, data);
        }

        return data;
    }

    @Override
    public String treeTraversal(String type) {
        String data = "";
        if(type.equals("preOrder")){
            data = preOrder(root, data);
        }else if(type.equals("postOrder")){
            data = postOrder(root, data);            
        }else if(type.equals("inOrder")){
            data = inOrder(root, data);

        }else{
        //    data = breadthFirstSearch();
        }
        return data;
    }
    

}
