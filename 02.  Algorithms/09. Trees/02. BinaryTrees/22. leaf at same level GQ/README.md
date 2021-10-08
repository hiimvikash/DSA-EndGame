# [**Leafs at same level ?**](https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1#)

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
    int flevel=-1;
    boolean check(Node root)
    {
	// Your code here
	    return levelcheck(root,0);
    }
    
    boolean levelcheck(Node root, int level){
        if(root==null) return true;
        
        if(root.left==null && root.right==null){
            if(flevel==-1) flevel=level; // first time leftlevel
            return flevel==level;
        }
        
        
        boolean left=levelcheck(root.left,level+1);
        if(!left) return false;
        return levelcheck(root.right,level+1);
    }
    
}
```