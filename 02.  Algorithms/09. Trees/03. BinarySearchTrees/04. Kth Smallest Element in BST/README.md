# [**Kth Smallest Element in BST**](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

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
    int ans=-1;
    int inele=0; // element inside AL
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }
    private void inorder(TreeNode root,int k){
        if(root==null) return;
        
        inorder(root.left,k);
        
        inele++;
        if(inele==k) ans = root.val;
        
        if(ans!=-1) return;
        inorder(root.right,k);
    }
}
```