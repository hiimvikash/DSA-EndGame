# [662. Maximum Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/)

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
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0));
        
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            int si = 0,ei=0;
            for(int i = 1; i<=size; i++){
                Pair p = q.remove();
                TreeNode n = p.node; int idx = p.index;
                if(i==1) si = idx;
                if(i==size) ei = idx;
                
                if(n.left!=null) q.add(new Pair(n.left, 2*idx+1));
                if(n.right!=null) q.add(new Pair(n.right, 2*idx+2));
            }
            res = Math.max(res, ei-si+1);
                        
        }
        return res;
    }
}

class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode n, int i){
        node = n;
        index = i;
    }
}
```