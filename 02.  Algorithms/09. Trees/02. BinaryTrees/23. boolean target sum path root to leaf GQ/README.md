# [**Path Sum - I**](https://leetcode.com/problems/path-sum/)

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return getPathSum(root,0,targetSum);
    }
    private boolean getPathSum(TreeNode root, int sum, int ts){
        if(root==null) return false;
        
        sum+=root.val;
        if(sum==ts && root.left==null && root.right==null) return true;
        if(getPathSum(root.left,sum,ts)) return true;
        if(getPathSum(root.right,sum,ts)) return true;
        sum-=root.val;
        return false;
    }
}
```