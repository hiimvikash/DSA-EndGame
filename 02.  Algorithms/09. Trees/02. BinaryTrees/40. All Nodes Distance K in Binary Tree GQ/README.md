# [**863. All Nodes Distance K in Binary Tree**](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)
- [**Video Reference**](https://youtu.be/i9ORlEy6EsI)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> phm=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        makeParentHM(root);
        int dis=0;
        HashMap<TreeNode, Boolean> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(target);
        vis.put(target,true);
        while(!q.isEmpty() && k!=0){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode n=q.remove();
                
                // check parent left right
                TreeNode p=null;
                if(phm.containsKey(n)) p=phm.get(n);
                if(p!=null && vis.get(p)==null){
                    q.add(p);
                    vis.put(p,true);
                }
                if(n.left!=null && vis.get(n.left)==null){ q.add(n.left); vis.put(n.left,true); }
                if(n.right!=null && vis.get(n.right)==null){ q.add(n.right); vis.put(n.right,true);}
            }
            dis+=1;
            if(dis==k) break;
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
    private void makeParentHM(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n=q.remove();
            
            if(n.left!=null){
                q.add(n.left);
                phm.put(n.left,n);
            }
            if(n.right!=null){
                q.add(n.right);
                phm.put(n.right,n);
            }
        }
    }
}
```
