# [**Path from root to Node**](https://www.interviewbit.com/problems/path-to-given-node/)

- [**Video reference**](https://youtu.be/fmflMqVOC7k)
```java
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode root, int x) {
        ArrayList<Integer> ans=new ArrayList<>();
        getPath(root,x,ans);
        return ans;
    }
    private boolean getPath(TreeNode root, int x, ArrayList<Integer> ans){
        if(root==null) return false;

        ans.add(root.val);
        if(root.val==x) return true;

        if(getPath(root.left,x,ans) || getPath(root.right,x,ans)) return true;

        ans.remove(ans.size()-1);
        return false;
    }
}
```