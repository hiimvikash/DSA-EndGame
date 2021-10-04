# [**Right View of BT**](https://leetcode.com/problems/binary-tree-right-side-view/)
## thought Process : **ANS will be last Value  of each level**
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
    public List<Integer> rightSideView(TreeNode root) {
        return levelOrder(root);
    }
    private List<Integer> levelOrder(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelNode=q.size();
            for(int i=0;i<levelNode;i++){
                TreeNode n=q.remove();
                if(i==0) ans.add(n.val);
                if(n.right!=null) q.add(n.right);
                if(n.left!=null) q.add(n.left);
            }
        }
        return ans;
    }
}
```