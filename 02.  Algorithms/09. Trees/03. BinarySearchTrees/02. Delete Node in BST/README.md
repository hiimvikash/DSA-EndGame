# [**Delete Node in BST**](https://leetcode.com/problems/delete-node-in-a-bst/)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        else if(key < root.val) root.left = deleteNode(root.left,key);
        else if(key > root.val) root.right = deleteNode(root.right,key);
        else{
                       
            // case 1 : if(left & right ! empty)
            if(root.left!=null && root.right!=null){
                int leftMax = leftMax(root.left);
                root.val = leftMax;
                root.left = deleteNode(root.left,leftMax);
            }
            
            // case 2 : if(left is Empty & right ! empty)
            else if(root.right!=null) return root.right;
            
            // case 3 : if(left ! empty & right is empty)
            else if(root.left!=null) return root.left;
            
            else return null;
            
            
        }
        return root;
    }
    
    private int leftMax(TreeNode root){
        if(root.right==null) return root.val;
        return leftMax(root.right);
    }
}
```