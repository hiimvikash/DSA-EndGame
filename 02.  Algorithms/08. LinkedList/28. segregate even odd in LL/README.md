# [**Segregate even and odd nodes in a Link List .**](https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1#)
```java
/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        // code here
        Node evenHead=new Node(-1), oddHead=new Node(-1);
        Node evenlast=evenHead, oddlast=oddHead;
        
        while(head!=null){
            int data=head.data%2;
            if(data==0){
                evenlast.next=head;
                evenlast=head;
            }
            else {
                oddlast.next=head;
                oddlast=head;
            }
            head=head.next;
        }
        evenlast.next=oddHead.next;
        oddlast.next=null;
        
        return evenHead.next;
    }
}
```
