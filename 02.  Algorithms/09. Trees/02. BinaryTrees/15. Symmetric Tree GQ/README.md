# [**Symmetric BT**](https://leetcode.com/problems/symmetric-tree/)
## recursive
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
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null)   return true;
        if(left==null || right==null || left.val!=right.val)    return false;
        return isSymmetric(left.left, right.right) && isSymmetric(right.left,left.right);
    }
}
```
## itterative
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()){
            TreeNode left=q.remove(),
                    right=q.remove();
            if(left==null && right==null) continue;
            if(left==null || right==null || left.val!=right.val) return false;
            
            q.add(left.left); q.add(right.right);
            q.add(right.left); q.add(left.right);
        }
        return true;
    }
}
```