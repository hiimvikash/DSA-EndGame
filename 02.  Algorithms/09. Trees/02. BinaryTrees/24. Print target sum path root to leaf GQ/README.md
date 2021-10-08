# [**Path Sum - II**](https://leetcode.com/problems/path-sum-ii/)

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
        getPath(root,0,targetSum, new ArrayList<>(), ans);
        return ans;
    }
    private void getPath(TreeNode root, int sum, int ts, List<Integer> subans, List<List<Integer>> ans){
        if(root==null) return;
        
        sum+=root.val;
        subans.add(root.val);
        if(root.left==null && root.right == null && sum==ts){
            ans.add(new ArrayList<>(subans));
            
            sum-=root.val;
            subans.remove(subans.size()-1);
            return;
        }
        
        getPath(root.left,sum,ts,subans,ans);
        getPath(root.right,sum,ts,subans,ans);
        sum-=root.val;
        subans.remove(subans.size()-1);
    }
}
```