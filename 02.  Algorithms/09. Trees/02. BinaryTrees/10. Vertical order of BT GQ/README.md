# [**Vertical Order of BT**](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)
**If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.**
- **1stly understand this approach**
- [**Video reference**](https://youtu.be/PQKkr036wRc)
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
**There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.**
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
        HashMap<Integer,List<Tuple>> hm=new HashMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.remove();
            minv=Math.min(minv,t.v); maxv=Math.max(maxv,t.v); // keep track of range of verticals
            if(!hm.containsKey(t.v)) hm.put(t.v,new ArrayList<>());
            if(hm.containsKey(t.v)) hm.get(t.v).add(t);
            
            if(t.n.left!=null) q.add(new Tuple(t.n.left, t.l+1, t.v-1));
            if(t.n.right!=null) q.add(new Tuple(t.n.right, t.l+1, t.v+1));
        }
        
        // Now your HM is ready.
        
        for(int i=minv;i<=maxv;i++){
            Collections.sort(hm.get(i));
            List<Integer> subans=new ArrayList<>();
            for(Tuple t : hm.get(i)){
                subans.add(t.n.val);
            }
            ans.add(subans);
        }
        
        return ans;
    }
}
class Tuple implements Comparable<Tuple>{
    TreeNode n;
    int l;
    int v;
    public Tuple(TreeNode node, int level, int vertical){
        n=node;
        l=level;
        v=vertical;
    }
    @Override
	public int compareTo(Tuple o) {
		if(this.l==o.l && this.v==o.v) return this.n.val-o.n.val; // when they overlap I sorted according to value
        else return this.v-o.v; // else according to vertical line
	}
}
```