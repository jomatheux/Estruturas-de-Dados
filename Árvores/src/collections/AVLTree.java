package collections;

public class AVLTree<E> extends AbstractBinaryTree<E> {

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

        updateHeight(current);
        
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

        updateHeight(current);
        current = balance(current);
        
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

    private int height(Node current){
        return current == null ? 0 : current.height;
    }

    private int max(int a, int b){
        return a>b ? a : b;
    }

    private void updateHeight(Node current){
        current.height = max(height(current.left),height(current.right))+1;
    }

    private Node rotationRight(Node x){
        Node y = x.left;
        Node t2 = y.right;
        y.right = x;
        x.left = t2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node rotationLeft(Node x){
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node balance(Node current){
        int difference1 = height(current.right) - height(current.left);
        if(difference1 > 1){
            System.out.println("Desbalanceada à direita.");
            int difference2 = height(current.right.right) - height(current.right.left);
            if(difference2 == 0 || difference2 == 1){
                current = rotationLeft(current);
            }else{
                current.right = rotationRight(current.right);
                current = rotationLeft(current);                
            }
        }else if(difference1 < - 1){
            System.out.println("Desbalanceada à esquerda.");
            int difference2 = height(current.left.right) - height(current.left.left);
            if(difference2 == 0 || difference2 == -1){
                current = rotationRight(current);
            }else{
                System.out.println("Rotação dupla esquerda direita");
                current.left = rotationLeft(current.left);
                current = rotationRight(current);

            }
        }
        return current;
    }

    private Node insert(Node current, E value){
        if(current == null){
            size++;
            return new Node(value);
        }

        if(compare(value, current)<0){
            current.left = insert(current.left, value);
        }else if(compare(value, current)>0){
            current.right = insert(current.right, value);
        }
        updateHeight(current);
        current = balance(current);
        return current;
    }

    @Override
    public void insert(E value) {
        root = insert(root, value);
        
    }

  
    private String preOrder(Node current, String data){

        if(current!=null){
            data += current +" ";
            data = preOrder(current.left, data);
            data = preOrder(current.right, data);
        }

        return data;
    }
    private String postOrder(Node current, String data){

        if(current!=null){
            data = postOrder(current.left, data);
            data = postOrder(current.right, data);
            data += current +" ";
        }

        return data;
    }
    private String inOrder(Node current, String data){

        if(current!=null){
            data = inOrder(current.left, data);
            data += current +" ";
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
