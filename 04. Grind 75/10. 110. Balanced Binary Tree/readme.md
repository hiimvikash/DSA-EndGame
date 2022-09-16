## [**110. Balanced Binary Tree**](https://leetcode.com/problems/balanced-binary-tree/)
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
    boolean isbal = true;
    public boolean isBalanced(TreeNode root) {
        h(root);
        return isbal;
    }
    int h(TreeNode root){
        if(root==null) return -1;
        if(root.left == null && root.right == null) return 0;
        
        int lh = h(root.left);
        int rh = h(root.right);
        
        if((int)Math.abs(lh-rh)>1){ isbal = false; return -1; }
        return Math.max(lh,rh)+1;
    }
}
```

## O(n) Approach
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
    public boolean isBalanced(TreeNode root) {
        return helperHeight(root)!=-1;
    }
    private int helperHeight(TreeNode root){
        if(root==null) return 0;
        
        int lh = helperHeight(root.left);
        if(lh==-1) return -1;
        
        int rh = helperHeight(root.right);
        if(rh==-1) return -1;
        
        if((int)Math.abs(lh-rh)>1) return -1;
        
        return Math.max(lh,rh)+1;
    }
}
```