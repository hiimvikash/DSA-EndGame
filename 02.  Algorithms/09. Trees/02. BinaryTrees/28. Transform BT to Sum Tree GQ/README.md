# [**Transform BT to SumTree**](https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1#)
## Convert this to a tree where each node contains the sum of the left and right sub trees of the original tree. The values of leaf nodes are changed to 0.

## Thought process :-
- for each node get LSubTreeSum & RSubTreeSum
- Now prepare your returning value (i.e., LSubTreeSum + RSubTreeSum + currNode.val)
- Now modify the currNode value with LSubTreeSum + RSubTreeSum
```java
/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}*/

class Solution{
    public void toSumTree(Node root){
         //add code here.
         transform(root);
    }
    private int transform(Node root){
        if(root==null) return 0;
        
        int ls=transform(root.left); // left sum
        int rs=transform(root.right); // right sum
        int rv=ls+rs+root.data; // prepare your return value b4 modifying current node val
        root.data = ls+rs;
        
        return rv;
    }
}
```