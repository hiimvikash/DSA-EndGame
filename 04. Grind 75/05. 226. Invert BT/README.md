# [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left==null && root.right==null))
		return root;
      
      // swap
      TreeNode temp=root.left;
      root.left=root.right;
      root.right=temp;
      
      root.left=invertTree(root.left);
      root.right=invertTree(root.right);

	  return root;
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode n = q.remove();
            
            // swap
             TreeNode temp=n.left;
             n.left=n.right;
             n.right=temp;
            
            if(n.left!=null) q.add(n.left);
            if(n.right!=null) q.add(n.right);
        }
        
        return root;
    }
}
```