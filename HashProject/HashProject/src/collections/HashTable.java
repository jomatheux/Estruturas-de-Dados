package collections;

public class HashTable<K, V> extends AbstractHash<K, V> {

    public HashTable(int hashMaxSize) {
        super(hashMaxSize);
    }

    private Node getNodeByIndex(int index, K key) {
        if(isEmpty()) throw new RuntimeException("Hash Table is empty!");
        Node auxNode = hashTable[index];
        while (auxNode != null) {
            if (auxNode.entry.getKey().equals(key)) {
                return auxNode;
            }
            auxNode = auxNode.next;
        }
        return auxNode;
    }

    @Override
    public Entry<K, V> delete(K key) {
        int index = hashFunction(key);
        Node auxNode = getNodeByIndex(index , key);
        if(auxNode == null) return null;
        if(hashTable[index] == auxNode){
            hashTable[index] = hashTable[index].next;
            if(hashTable[index]!=null){
                hashTable[index].previous = null;
            }
        }else if(auxNode.next == null){
            auxNode.previous.next = null;
        }else{
            auxNode.previous.next = auxNode.next;
            auxNode.next.previous = auxNode.previous;
        }
        size--;
        return auxNode.entry;
    }

    @Override
    public Entry<K, V> get(K key) {
        int index = hashFunction(key);
        Node auxNode = getNodeByIndex(index, key);
        return auxNode == null ? null : auxNode.entry;
    }

    @Override
    public void set(K key, V value) { // put
        Node newNode = new Node(key, value);
        int index = hashFunction(key);
        if (hashTable[index] == null) {
            hashTable[index] = newNode;
        } else {
            Node auxNode = hashTable[index];
            while (auxNode != null) {
                if (auxNode.entry.getKey().equals(key)) {
                    auxNode.entry.setValue(value);
                    return;
                }

                auxNode = auxNode.next;
            }

            newNode.next = hashTable[index];
            hashTable[index].previous = newNode;
            hashTable[index] = newNode;

        }
        size++;

    }

}
