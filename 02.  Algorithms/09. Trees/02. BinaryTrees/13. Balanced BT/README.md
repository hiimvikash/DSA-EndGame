# [**Balanced BT**](https://leetcode.com/problems/balanced-binary-tree/)
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
    boolean isBal=true;
    public int height(TreeNode root){
        if(root==null) return -1;
        int lh=height(root.left);
        int rh=height(root.right);
        if(Math.abs(lh-rh)>1){ isBal=false; return 0;}
        
        return Math.max(lh,rh)+1;
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBal;
    }
}
```

## New Approach O(N)
```java
public boolean balancedBT(TreeNode root){
    return helperHeight(root)!=-1;
}
private int helperHeight(TreeNode root){
    if(root==null) return 0;

    int lh=helperHeight(root.left);
    if(lh==-1) return -1;

    int rh=helperHeight(root.right);
    if(rh==-1) return -1;

    if(Math.abs(lh-rh) > 1) return -1;
    return Math.max(lh,rh)+1;
}
```