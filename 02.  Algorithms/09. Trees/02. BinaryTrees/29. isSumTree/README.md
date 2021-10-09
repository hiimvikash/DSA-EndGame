# [**is SumTree**](https://practice.geeksforgeeks.org/problems/sum-tree/1#)
```java
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution
{
	boolean isSumTree(Node root)
	{
        // Your code here
        if(root==null || (root.left==null && root.right==null)) return true;
        
        int ls=sum(root.left);
        int rs=sum(root.right);
        
        if((root.data == ls+rs) && isSumTree(root.left) && isSumTree(root.right)) return true;
        return false;
	}
	private int sum(Node root){
	    if(root==null) return 0;
	    return sum(root.left) + root.data + sum(root.right);
	}
}
```