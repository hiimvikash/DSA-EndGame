# [**Given a linked list of 0s, 1s and 2s, sort it.**](https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1#)
```java
/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node zeroHead=new Node(-1), oneHead=new Node(-1), twoHead=new Node(-1);
        Node zerolast=zeroHead, onelast=oneHead, twolast=twoHead;
        
        while(head!=null){
            int data=head.data;
            if(data==0){
                zerolast.next=head;
                zerolast=head;
            }
            else if(data==1){
                onelast.next=head;
                onelast=head;
            }
            else{
                twolast.next=head;
                twolast=head;
            }
            head=head.next;
        }
        zerolast.next = (oneHead.next!=null) ? (oneHead.next) : (twoHead.next);
        onelast.next = twoHead.next;
        twolast.next = null;
        
        return zeroHead.next;
    }
}
```
