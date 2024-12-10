package collections;

public class BinarySearchTree<E> extends AbstractBinaryTree<E> {

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

    private E removeRightMinValue(Node parent){
        Node minNode = parent.right;
        while(minNode.left!=null){
            parent = minNode;
            minNode = minNode.left;
        }

        if(parent.right == minNode){
            parent.right = minNode.right;
        }else{
            parent.left = minNode.right;
        }
        return minNode.value;
    }

    @Override
    public E delete(E value) {
        if(isEmpty()){
            throw new RuntimeException("Tree is empty!");
        }
        Node target = root, parent = null;
        while(target!=null && compare(value, target)!=0){
            parent = target;
            if(compare(value, target)>0){
                target = target.right;
            }else{
                target = target.left;
            }            

        }
        if(target==null) return null;
        E removedValue = target.value;
        if(target.left==null && target.right == null){
            if(target == root){
                root = null;
            }else{
                if(parent.left == target){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
        }else if(target.left!=null && target.right!=null){
            target.value = removeRightMinValue(target);
        }else{
            Node child = target.left!=null? target.left:target.right;
            if(target == root){
                root = child;
            }else{
                if(parent.left == target){
                    parent.left = child;
                }else{
                    parent.right = child;
                }
            }
        }
        size--;
        return removedValue;
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

    @Override
    public void insert(E value) {
       Node newNode = new Node(value);
       if(isEmpty()){
            root = newNode;
       }else{
            Node auxNode = root;
            while(true){
                if(compare(value, auxNode)<0){
                    if(auxNode.left==null){
                        auxNode.left = newNode;
                        break;
                    }
                    auxNode = auxNode.left;
                }else if(compare(value, auxNode)>0){
                    if(auxNode.right == null){
                        auxNode.right = newNode;
                        break;
                    }
                    auxNode = auxNode.right;
                }else{
                    return;
                }
            }
       }
       size++;
    }

    @Override
    public String treeTraversal(String type) {
        String data  = null;
        if(type.equals("preOrder")){

        }else if(type.equals("postOrder")){

        }else if(type.equals("inOrder")){

        }else{
           data = breadthFirstSearch();
        }
        return data;
    }

    protected String breadthFirstSearch(){
        String treeData = "";
        DynamicQueue<Node> queue = new DynamicQueue<>();
        if(!isEmpty()){
            queue.enqueue(root);
        }

        while(!queue.isEmpty()){
            Node auxNode = queue.dequeue();
            treeData += auxNode.value;
            if(auxNode.left!=null){
                queue.enqueue(auxNode.left);
            }
            if(auxNode.right!=null){
                queue.enqueue(auxNode.right);
            }
            if(!queue.isEmpty()){
                treeData+=", ";
            }
        }

        return treeData;
    }

    @Override
    public String toString() {
        return breadthFirstSearch();
    }

    

    

}
