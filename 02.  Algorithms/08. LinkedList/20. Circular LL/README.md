# [**Circular LL ?**](https://practice.geeksforgeeks.org/problems/circular-linked-list/1#)

```java
/* Structure of LinkedList
class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/
class GfG
{
    boolean isCircular(Node head)
    {
	// Your code here
	    if(head==null) return true;
	    Node curr=head;
	    curr=head.next;
	    while(curr!=null && curr!=head){
	        curr=curr.next;
	    }
	    return curr==head;
    }
}
```
# [**Deletion from circular LL**](https://www.geeksforgeeks.org/deletion-circular-linked-list/)
