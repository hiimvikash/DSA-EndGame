# [**ZigZag Traversal in BT**](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean LtoR=true; // left to right insertion
        while(!q.isEmpty()){
            int levelNode=q.size();
            List<Integer> subans=new ArrayList<>();
            for(int i=0;i<levelNode;i++){
                TreeNode n=q.remove();
                
                if(LtoR)subans.add(n.val);
                else subans.add(0,n.val); 
                
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            ans.add(subans);
            LtoR=!LtoR;
        }
        return ans;
    }
}
```