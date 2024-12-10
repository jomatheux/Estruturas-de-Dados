package collections;

public abstract class AbstractHash<K,V> implements Map<K,V> {

    class Node {
        Node next;
        Node previous;
        Entry<K,V> entry;
        public Node(Entry<K, V> entry) {
            this.entry = entry;
        }
        public Node(K key, V value){
            entry = new HashEntry(key, value);
        }
    }
    
    class HashEntry implements Entry<K,V>{
        K key;
        V value;
        
        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {            
            return key;
        }
        @Override
        public V getValue() {            
            return value;
        }
        @Override
        public void setValue(V value) {
            this.value = value;            
        }
        @Override
        public String toString() {
            return "{" + key + " : " + value + "}";
        }

        
        
    }


    protected Node[] hashTable;
    protected int size;

    public AbstractHash(int hashMaxSize){
        hashTable =(Node[]) new AbstractHash<?,?>.Node[hashMaxSize];
    }

    

    @Override
    public boolean isEmpty() {        
        return size==0;
    }



    @Override
    public int size() {        
        return size;
    }


    protected int hashFunction(K key){
        if(key instanceof String){
            // return compression(hashCode((String)key),89);
            return compression(hashCode((String)key),hashTable.length);
        }
        
        throw new RuntimeException("Key data type is not avaliable!");
    }

    protected int compression(int hashCode, int N){
        return hashCode>0? hashCode % N : (hashCode*-1)%N;
    }

    protected int hashCode(String key){
        int hashCode = 0;
        int a = 2;
        for(int i = 0; i < key.length(); i++){        
            hashCode = hashCode<<a | hashCode>>>(a-32);
            hashCode += key.charAt(i);
        }
        return hashCode;
    }



    @Override
    public String toString() {
        String hashData = "";
        for(int i = 0; i < hashTable.length; i++){
            hashData += "["+i+"]: ";
            Node auxNode = hashTable[i];
            while(auxNode!=null){
                hashData+= auxNode.entry;
                if(auxNode.next!=null){
                    hashData+=", ";
                }
                auxNode = auxNode.next;
            }

            hashData+="\n";
        }
        return hashData;
    }

    

}
