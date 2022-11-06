# [448 · Inorder Successor in BST](https://www.lintcode.com/problem/inorder-successor-in-bst/description)

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


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
     int f = 0;
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            // write your code here
            if(root == null) return null;

            TreeNode l = inorderSuccessor(root.left,p);
            if(l!=null) return l;

            if(f==1) return root;
            if(root==p) f=1;

            TreeNode r = inorderSuccessor(root.right, p);
            if(r!=null) return r;
            
            return null;
        }

}
```