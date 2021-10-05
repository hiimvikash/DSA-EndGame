# [**Vertical Order of BT**](https://youtu.be/PQKkr036wRc)
**If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.**
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        int minv=0,maxv=0;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.remove();
            minv=Math.min(minv,t.v); maxv=Math.max(maxv,t.v); // keep track of range of verticals
            if(!hm.containsKey(t.v)) hm.put(t.v,new ArrayList<>());
            if(hm.containsKey(t.v)) hm.get(t.v).add(t.n.val);
            
            if(t.n.left!=null) q.add(new Tuple(t.n.left, t.l+1, t.v-1));
            if(t.n.right!=null) q.add(new Tuple(t.n.right, t.l+1, t.v+1));
        }
        
        // Now your HM is ready.
        
        for(int i=minv;i<=maxv;i++){
            ans.add(hm.get(i));
        }
        
        return ans;
    }
}
class Tuple{
    TreeNode n;
    int l;
    int v;
    public Tuple(TreeNode node, int level, int vertical){
        n=node;
        l=level;
        v=vertical;
    }
}
```