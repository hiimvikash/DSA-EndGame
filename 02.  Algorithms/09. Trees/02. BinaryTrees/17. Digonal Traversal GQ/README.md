# [**Digonal Traversal in BT**](https://www.interviewbit.com/problems/diagonal-traversal/)
- Same logic as Vertical order traversal, **if two nodes lie in same digonal distance then they will appear in ans in level order.**
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
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int maxd=0;
        while(!q.isEmpty()){
            Pair p=q.remove();
            maxd=Math.max(maxd,p.d); // maximum digonal distance

            if(!hm.containsKey(p.d)) hm.put(p.d,new ArrayList<>());
            if(hm.containsKey(p.d)) hm.get(p.d).add(p.n.val);

            if(p.n.left!=null) q.add(new Pair(p.n.left,p.d+1));
            if(p.n.right!=null) q.add(new Pair(p.n.right,p.d));
        }

        // now my HM is ready
        for(int i=0;i<=maxd;i++){
            for(Integer ele : hm.get(i)){
                ans.add(ele);
            }
        }
        return ans;
    }
}
class Pair{
    TreeNode n;
    int d;
    public Pair(TreeNode r, int di){
        n=r;
        d=di;
    }
}
```
- Same logic as Vertical order traversal, **if two nodes lie in same digonal distance then they will appear in ans in preorder.**
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
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(root,0));
        int maxd=0;
        while(!st.isEmpty()){
            Pair p=st.pop();
            maxd=Math.max(maxd,p.d); // maximum digonal distance

            if(!hm.containsKey(p.d)) hm.put(p.d,new ArrayList<>());
            if(hm.containsKey(p.d)) hm.get(p.d).add(p.n.val);

            if(p.n.right!=null) st.push(new Pair(p.n.right,p.d));
            if(p.n.left!=null) st.push(new Pair(p.n.left,p.d+1));
        }

        // now my HM is ready
        for(int i=0;i<=maxd;i++){
            for(Integer ele : hm.get(i)){
                ans.add(ele);
            }
        }
        return ans;
    }
}
class Pair{
    TreeNode n;
    int d;
    public Pair(TreeNode r, int di){
        n=r;
        d=di;
    }
}
```

## Best Approach
- [**Video reference**](https://youtu.be/e9ZGxH1y_PE)
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
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n=q.remove();
            while(n!=null){
                ans.add(n.val);
                if(n.left!=null) q.add(n.left);
                n=n.right;
            }
        }
        return ans;
    }
}
```
