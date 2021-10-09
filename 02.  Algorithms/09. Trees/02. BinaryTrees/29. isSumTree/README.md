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
# Best Approach :- O(N)

Method 1 uses sum() to get the sum of nodes in left and right subtrees. Method 2 uses the following rules to get the sum directly. 
1) If the node is a leaf node then the sum of the subtree rooted with this node is equal to the value of this node. 
2) If the node is not a leaf node then the sum of the subtree rooted with this node is twice the value of this node (Assuming that the tree rooted with this node is SumTree).
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
        if(root==null || isleaf(root)) return true;
        
        if(isSumTree(root.left) && isSumTree(root.right)){
            int ls=0,rs=0;
            
            // left sum
            if(root.left==null) ls=0;
            else if(isleaf(root.left)) ls=root.left.data;
            else ls= 2*root.left.data;
            
            // right sum
            if(root.right==null) rs=0;
            else if(isleaf(root.right)) rs=root.right.data;
            else rs= 2*root.right.data;
            
            return root.data==(ls+rs);
        }
        return false;
	}
	boolean isleaf(Node root){
	    return root.left==null && root.right==null;
	}
}
```
