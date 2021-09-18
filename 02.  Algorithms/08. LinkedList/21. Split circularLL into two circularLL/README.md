# [**Split Circular LL into two half such that both half are circular LL**](https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1#)


## Do consider looking ```circular_LinkedList``` class in driver code.
```java
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class gfg
{
        // Function  to split a circular LinkedList
	    void splitList(circular_LinkedList list)
        {   
             // Your code here
             list.head1=list.head;
             Node middleNode=getMiddleCircularLL(list.head);
             list.head2=middleNode.next;
             
             middleNode.next=list.head1;
             list.last.next=list.head2;
	    }
	    public Node getMiddleCircularLL(Node head) {
            if (head == null || head.next==head)
                return head;
            Node s=head;
            Node f=head;
            while(f.next.next!=head && f.next!=head){
                s=s.next;
                f=f.next.next;
            }
            return s;
    }
}
```

