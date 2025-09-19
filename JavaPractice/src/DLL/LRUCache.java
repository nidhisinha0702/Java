package DLL;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head = new Node(-1,-1);
    Node tail = new Node(-1, -1);

    Map<Integer, Node> mpp;
    int limit;

    class Node{
        Node next, prev;
        int key, val;
        Node(int k, int v){
            key = k;
            val = v;
            next = prev = null;
        }
    }

    void addNode(Node newNode){//O(1)
        Node oldNext = head.next;

        head.next = newNode;
        oldNext.prev = newNode;

        newNode.next = oldNext;
        newNode.prev = head;

    }

    void delNode(Node oldNode){//O(1)
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
        mpp = new HashMap<>();
    }
    
    public int get(int key) {
        //if key does not exist
        if(!mpp.containsKey(key))
        return -1;
        Node ansNode = mpp.get(key);
        int ans = ansNode.val;

        mpp.remove(key);
        delNode(ansNode);

        addNode(ansNode);
        mpp.put(key, ansNode);

        return ans;
    }
    
    public void put(int key, int value) {//O(1)
        //if key exist then override the val for this delNode and add new node
        if(mpp.containsKey(key)){
            Node oldNode = mpp.get(key);
            delNode(oldNode);
            mpp.remove(key);
        }

        if(mpp.size() == limit){
            //delete LRU data
            mpp.remove(tail.prev.key);
            delNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        mpp.put(key,newNode);
    }
}

