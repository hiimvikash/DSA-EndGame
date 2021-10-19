# [**Print Duplicate subtree in BT.**](https://leetcode.com/problems/find-duplicate-subtrees/)

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
    List<TreeNode> ans=new ArrayList<>();
    HashMap<String, Integer> hm=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return ans;
    }
    String solve(TreeNode root){
        if(root==null) return "$";
                
        String s = "(";
        s = s + String.valueOf(root.val);
        s = s + solve(root.left);
        s = s + solve(root.right);
        s = s + ")";
        
        if (hm.get(s) != null && hm.get(s)==1)
            ans.add(root);
        hm.put(s,hm.getOrDefault(s,0)+1);
        return s;
    }
}
```
