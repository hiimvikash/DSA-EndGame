# [**222. Count Complete Tree Nodes**](https://leetcode.com/problems/count-complete-tree-nodes/)
- [**Video Reference**](https://youtu.be/u-yWemKGWO0)
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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        int lh=getlefth(root);
        int rh=getrighth(root);
        
        if(lh==rh) return (int)Math.pow(2,lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int getlefth(TreeNode root){
        int c=0;
        while(root!=null){
            c++;
            root=root.left;
        }
        return c;
    }
    private int getrighth(TreeNode root){
        int c=0;
        while(root!=null){
            c++;
            root=root.right;
        }
        return c;
    }
}
```
