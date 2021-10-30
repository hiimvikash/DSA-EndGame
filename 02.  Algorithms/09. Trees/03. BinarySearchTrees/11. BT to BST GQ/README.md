# [**BT to BST**](https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1#)
[**Video Reference**](https://youtu.be/8AnntMKIWlQ)
```java
/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    ArrayList<Integer> ans=new ArrayList<>();
    int i=0;
    Node binaryTreeToBST(Node root)
    {
       // Your code here
       if(root==null || (root.left==null && root.right==null)) return root;
       
       inorder(root);
       Collections.sort(ans);
       dcinorder(root);
       
       return root;
    }
    
    void dcinorder(Node root){
        if(root==null) return;
        
        dcinorder(root.left);
        root.data = ans.get(i++);
        dcinorder(root.right);
    }
    
    void inorder(Node root){
        if(root==null) return;
        
        inorder(root.left);
        ans.add(root.data);
        inorder(root.right);
    }
}
```