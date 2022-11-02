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

OR
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        
        ps(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
    
    private void ps(TreeNode root, int ts, List<Integer> subans, List<List<Integer>> ans){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(ts-root.val==0){
                subans.add(root.val);
                ans.add(new ArrayList<>(subans));
                
                subans.remove(subans.size()-1);
            }
            return;
        }
        
        
            ts-=root.val;
            subans.add(root.val);
            ps(root.left, ts, subans, ans);
            ps(root.right, ts, subans, ans);
            ts+=root.val;
            subans.remove(subans.size()-1);
        
        
    }
}
```
