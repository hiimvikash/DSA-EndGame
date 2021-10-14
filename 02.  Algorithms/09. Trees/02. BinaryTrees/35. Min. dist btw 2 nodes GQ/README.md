# [**Min distance between two given nodes of a Binary Tree**](https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1#)


```java
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca=lowestCommonAncestor(root,a,b);
        if(lca!=null) return height(lca,a) + height(lca,b) - 2;
        return 0;
    }
    
    public Node lowestCommonAncestor(Node root, int p, int q) {
        if(root==null || root.data==p || root.data==q) return root;
        
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null) return root;
        if(left==null && right==null) return null;
        if(left==null) return right;
        return left;
    }
    
    int height(Node root,int x){
        if(root==null) return 0;
        
        if(root.data==x) return 1;
        int l=0,r=0;
        l = height(root.left,x);
        if(l==0){
            r = height(root.right,x);
            if(r!=0) return r+1;
        }
        if(l==0 && r==0) return 0;
        else return l+1;    
       
    }
}
```