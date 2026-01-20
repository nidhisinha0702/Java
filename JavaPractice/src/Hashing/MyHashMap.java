package Hashing;

public class MyHashMap<K, V> {
    //Node class entry
    static class Node<K, V>{
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value, Node<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        private final int capacity = 16;
        //private final float LOAD_FACTOR = 0.75f;
        //private final int TREEIFY_THRESHOLD = 8;
        private Node<K, V>[] bucket;
       // int size;
       // int threshold;

        public MyHashMap(){
            bucket = new Node[capacity];
        }

        //hash function
        private int getBucketIndex(K key){
            //int h;
            return (key == null)?0:(key.hashCode() % capacity);//improves hash distribution and reduces collision
        }

        //put operation
        public void put(K key, V value){
            int index = getBucketIndex(key);
            Node<K, V> head = bucket[index];

            //check if key already exist
            Node<K,V> current = head;
            while(current != null){
                if(current.key.equals(key)){
                    current.value = value;
                    return;
                }current = current.next;
            }

            //insert new node at head
            Node<K, V> newNode = new Node<>(key, value);
            newNode.next = head;
            bucket[index] = newNode;
        }

        //get operation
        public V get(K key){
            int index = getBucketIndex(key);
            Node<K, V> current = bucket[index];
            while(current!= null){
                if(current.key.equals(key)){
                    return current.value;
                }current = current.next;
            }return null;

        }
    }
}
