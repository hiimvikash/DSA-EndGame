# [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
## Reccursive 
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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left==null && root.right==null)) return 0;
        
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int curd = getHeight(root.left) + getHeight(root.right) + 2;
        
        return Math.max(curd, Math.max(ld,rd));
    }
    int getHeight(TreeNode root){
        if(root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
```
## Using DiaPair Approach
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
    public int diameterOfBinaryTree(TreeNode root) {
        DiaPair ans = getBoth(root);
        return ans.d;
    }
    
    // make a function which return both HEIGHT & DIAMETER of PASSED ROOT
    DiaPair getBoth(TreeNode root){
        if(root == null) return new DiaPair(-1, 0);
        
        DiaPair lp = getBoth(root.left);
        DiaPair rp = getBoth(root.right);
        
        DiaPair rtp = new DiaPair(0,0); // returning Pair
        
        rtp.h = Math.max(lp.h, rp.h) + 1;
        rtp.d = Math.max(lp.h + rp.h + 2, Math.max(lp.d, rp.d));
        
        return rtp;
    }
}

class DiaPair{
    int h; int d;
    DiaPair(int ht, int di){
        h = ht; d = di;
    }
}
```