# [**Delete node, if having greater value on any right nodes**](https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1#)

# Delete that node which has any greater on it right.
[**Video Reference**](https://youtu.be/cI3P6L6xgpY)
```java
class Solution
{
    Node compute(Node head)
    {
        // your code here
        if(head == null || head.next==null) return head;
        head = reverseList(head);
        Node d = new Node(-1);
        Node prev = d;
        
        Node curr = head;
        int max = head.data;
        while(curr!=null){
            if(curr.data >= max){
                max = curr.data;
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null;
        
        return reverseList(d.next);
    }
    
    Node reverseList(Node h){
        if(h==null || h.next==null) return h;
        Node curr = h;
        Node prev = null;
        Node nex = null;
        
        while(curr!=null){
            nex = curr.next; // secure ur future
            curr.next = prev; // do work
            prev = curr; // store ur work
            curr = nex; // go to future
        }
        return prev;
    }
}
```

