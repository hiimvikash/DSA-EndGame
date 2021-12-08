# **[146. LRU Cache](https://leetcode.com/problems/lru-cache/)**

```java
class LRUCache {
    
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    HashMap<Integer,Node> hm;
    int capacity;
    public LRUCache(int cap) {
       hm=new HashMap<>();
       capacity=cap;
       head.next=tail;
       tail.prev=head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node rn=hm.get(key); // returning node
            remove(rn);
            insert(rn);
            return rn.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            remove(hm.get(key));
        }
        if(hm.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    
    
    class Node{
        Node next;
        Node prev;
        int key; int val;
        public Node(int k,int v){
            key=k; val=v;
        }
    }
    private void insert(Node nn){
        hm.put(nn.key,nn);
        Node d=head.next;
        head.next=nn;
        nn.prev=head;
        nn.next=d;
        d.prev=nn;
    }
    private void remove(Node n){
        hm.remove(n.key);
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```
## **[Video Reference](https://youtu.be/xDEuM5qa0zg)**