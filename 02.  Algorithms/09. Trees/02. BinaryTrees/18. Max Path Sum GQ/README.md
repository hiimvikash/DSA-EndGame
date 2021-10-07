# [**Max Path Sum**](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
- [**Video reference**](https://youtu.be/WszrfSwMz58)
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
    public int maxPathSum(TreeNode root){
        int maxi[]={Integer.MIN_VALUE};
        mps(root,maxi);
        return maxi[0];
    }
    private int mps(TreeNode root, int maxi[]) {
        if(root==null) return 0;
                
        int ls=Math.max(0,mps(root.left, maxi)); 
        int rs=Math.max(0,mps(root.right, maxi));
        
        maxi[0]=Math.max(maxi[0], ls + root.val + rs);
        
        return root.val+Math.max(ls,rs);
    }
}
```