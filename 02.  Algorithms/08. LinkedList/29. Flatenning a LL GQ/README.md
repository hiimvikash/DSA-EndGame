# [**Flattening a Linked List**](https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#)
[**Video Reference**](https://youtu.be/ysytSSXpAI0)
```java
/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
    	// Your code here
    	if(root==null || root.next==null) return root;
	    root.next=flatten(root.next);
	    return mergeTwoLists(root,root.next);
    }
    public Node mergeTwoLists(Node l1, Node l2) {
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(l1!=null && l2!=null){
            int val1=l1.data;
            int val2=l2.data;
            if(val1<=val2){
                temp.bottom=l1;
                l1=l1.bottom;
            }
            else if(val2<val1){
                temp.bottom=l2;
                l2=l2.bottom;
            }
            temp=temp.bottom;
        }
        if(l1!=null) temp.bottom=l1;
        else temp.bottom=l2;
        
        return dummy.bottom;
    }
}
```

