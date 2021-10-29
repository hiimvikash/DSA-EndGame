# [**LCA in BST**](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
[**Video Reference**](https://youtu.be/5E3MeajU9XQ)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        else if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}
```
