# [**114. Flatten Binary Tree to Linked List**](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
- [**Video Reference**](https://youtu.be/sWf7k1x9XR4)
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
    TreeNode prevN=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right=prevN;
        root.left=null;
        
        prevN=root;
    }
}
```
