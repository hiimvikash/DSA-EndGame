# [**Balance a BST**](https://leetcode.com/problems/balance-a-binary-search-tree/)

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
    ArrayList<Integer> ans=new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return null;
        getSortedList(root);
        return intobst(0,ans.size()-1);
    }
    private void getSortedList(TreeNode root){
        if(root==null) return;
        
        getSortedList(root.left);
        ans.add(root.val);
        getSortedList(root.right);
    }
    private TreeNode intobst(int s, int e){
        if(s > e) return null;
        
        int mid = (s + e)/2;
        TreeNode root=new TreeNode(ans.get(mid));
        
        root.left = intobst(s,mid-1);
        root.right = intobst(mid+1,e);
        
        return root;
    }
}
```