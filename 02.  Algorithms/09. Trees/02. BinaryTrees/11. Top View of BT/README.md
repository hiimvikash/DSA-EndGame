# [**Top View of BT**](https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1#)
```java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        int minv=0,maxv=0;
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.remove();
            minv=Math.min(minv,t.v); maxv=Math.max(maxv,t.v); // keep track of range of verticals
            if(!hm.containsKey(t.v)) hm.put(t.v,new ArrayList<>());
            if(hm.containsKey(t.v) && hm.get(t.v).isEmpty()) hm.get(t.v).add(t.n.data);
            
            if(t.n.left!=null) q.add(new Tuple(t.n.left, t.l+1, t.v-1));
            if(t.n.right!=null) q.add(new Tuple(t.n.right, t.l+1, t.v+1));
        }
        
        // Now your HM is ready.
        
        for(int i=minv;i<=maxv;i++){
            ans.add(hm.get(i).get(0));
        }
        
        return ans;
    }
}
class Tuple{
    Node n;
    int l;
    int v;
    public Tuple(Node node, int level, int vertical){
        n=node;
        l=level;
        v=vertical;
    }
}
```