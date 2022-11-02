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
# OR
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
