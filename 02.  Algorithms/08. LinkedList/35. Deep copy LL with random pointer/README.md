# [**138. Copy List with Random Pointer**](https://leetcode.com/problems/copy-list-with-random-pointer/)
- [**Video reference**](https://youtu.be/VNf6VynfpdM)
# Use HashMap
- make new node with same value and insert them in HM. Don't touch the pointers. Now mapped Node in HM are DeepCopies of respective Node.
- No again traverse original List
    - for each node extract deepcopy node
    - assign dc.next to DeepCopy(curr.next)
    - assign dc.random to DeepCopy(curr.random)
- return DeepCopy(head);    
```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hm=new HashMap<>();
        Node curr=head;
        while(curr!=null){
            hm.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            Node dc=hm.get(curr);
            if(curr.next!=null) dc.next=hm.get(curr.next);
            else dc.next=null;
            if(curr.random!=null) dc.random=hm.get(curr.random);
            else dc.random=null;
            curr=curr.next;
        }
        return hm.get(head);
    }
}
```
# Optimal Solution :-
```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        // Step 1 Insert DeepCopy node between original LL, Here we not touched random Pointers
        Node itr=head;
        while(itr!=null){
            Node nn=new Node(itr.val);
            nn.next=itr.next;
            itr.next=nn;
            itr=itr.next.next;
        }
        // Step 2 : Deal with random pointers
        itr=head;
        while(itr!=null){
            if(itr.random!=null) itr.next.random=itr.random.next;
            else itr.next.random=null;
            itr=itr.next.next;
        }
        // Step 3 : seperate DC list and original
        itr=head;
        Node deepCopy=new Node(-1);
        Node last=deepCopy;
        
        while(itr!=null){
            Node front=itr.next.next;
            
            last.next=itr.next;
            last=last.next;
            
            itr.next=front;
            itr=front;
        }
        return deepCopy.next;
    }
}
```