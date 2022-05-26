# [**2246. Longest Path With Different Adjacent Characters**](https://leetcode.com/problems/longest-path-with-different-adjacent-characters/)

## My Approach : 
```java
class Solution {
    int res=0;
    public int longestPath(int[] parent, String s) {
        ArrayList<Integer> children[]=new ArrayList[parent.length];
        for(int i=0; i<parent.length; i++) children[i] = new ArrayList<>();
        
        for(int i=1; i<parent.length; i++){
            children[parent[i]].add(i);
        }
        dfs(children,s,0);
        return res;
    }
    
    public int dfs(ArrayList<Integer> children[], String s, int src){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int node : children[src]){
            int cur = dfs(children,s,node);
            if(s.charAt(src)!=s.charAt(node)) pq.add(cur);
        }
        // Now your PQ is filled with longest path from each children
        int big1 = pq.isEmpty()? 0 : pq.remove();
        int big2 = pq.isEmpty()? 0 : pq.remove();
        
        res = Math.max(res, big1+big2+1);
        return big1+1;
    }
}
```

