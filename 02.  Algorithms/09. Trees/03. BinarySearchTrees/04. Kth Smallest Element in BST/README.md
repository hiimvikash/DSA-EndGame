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
    ArrayList<Integer> in=new ArrayList<>();
    int inele=0; // count of element inside AL
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return in.get(k-1);
    }
    private void inorder(TreeNode root,int k){
        if(root==null) return;
        
        inorder(root.left,k);
        
        if(inele==k) return;
        in.add(root.val); inele++;
        
        inorder(root.right,k);
    }
}
```