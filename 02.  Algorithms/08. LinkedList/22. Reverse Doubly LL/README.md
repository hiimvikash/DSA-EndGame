# [**Reverse Doubly LL**](https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1#)


```java
/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/
public static Node reverseDLL(Node  head)
{
    //Your code here
    Node curr=head;
    Node pre=null;
    Node nex=null;
    while(curr!=null){
        nex=curr.next;// secure your next
        // do main operations
        curr.next=pre;
        curr.prev=nex;
        pre=curr; // secure your prev
        curr=nex;
    }
    return pre;
}
```