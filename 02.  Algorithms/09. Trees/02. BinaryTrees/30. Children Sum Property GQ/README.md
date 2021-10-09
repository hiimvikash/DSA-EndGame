# [**Children Sum Property**](https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723)
## A binary tree is said to follow the children sum property if, for every node of that tree, the value of that node is equal to the sum of the value(s) of both left child and the right child.
- [**Video reference**](https://youtu.be/fnmisPM6cVo)
```java
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        // Write your code here.
        if(root==null) return;
        int lv = root.left!=null ? root.left.data : 0;
        int rv = root.right!=null ? root.right.data : 0;
        if(lv+rv < root.data){
            if(root.left!=null) root.left.data=root.data;
            if(root.right!=null) root.right.data=root.data;
        }
        else{
            root.data=lv+rv;
        }
        changeTree(root.left);
        changeTree(root.right);
        if((root.left!=null && root.right!=null) || root.left!=null || root.right!=null){
            lv = root.left!=null ? root.left.data : 0;
            rv = root.right!=null ? root.right.data : 0;
            
            root.data=lv+rv;
        }
    }
}
```