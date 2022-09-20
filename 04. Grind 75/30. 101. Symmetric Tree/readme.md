[101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val!=right.val) return false;
        
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
```
## Itterative
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
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root.left); q.add(root.right);
        
        while(!q.isEmpty()){
            TreeNode left = q.remove(), 
                     right = q.remove();
            
            if(left == null && right == null) continue;
            if(left==null || right == null || left.val != right.val) return false;
            
            q.add(left.left); q.add(right.right);
            q.add(left.right); q.add(right.left);
        }
        return true;
    }
}
```