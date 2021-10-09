# [**Binary Tree to DLL**](https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1#)
## Traverse Inorder and process node. Use prevN* to keep track of previous nodes. Use left as prev* & right as next*.
```java
/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node head=null; Node prevN=null;
    Node bToDLL(Node root)
    {
	//  Your code here
	convert(root);
	return head;
    }
    void convert(Node root){
        if(root==null) return;
        
        convert(root.left);
        
        if(head==null) head=root;
        else{
            prevN.right=root;
            root.left=prevN;
        }
        prevN=root;
        
        convert(root.right);
    }
}
```