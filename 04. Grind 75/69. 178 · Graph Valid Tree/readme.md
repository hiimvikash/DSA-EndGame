# [178 · Graph Valid Tree](https://www.lintcode.com/problem/178/discuss?fromId=222&_from=collection)

```java
public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        // any graph without a cycle is a validTree so we will go for cycle detection

        // making adj list
        ArrayList<Integer> adj[]=new ArrayList[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        for(int edge[] : edges){
            int u = edge[0], v = edge[1];
            adj[u].add(v); adj[v].add(u);
        }
        //
        boolean isCycle = false;
        // cycle detection start
        boolean vis[]=new boolean[n];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,-1}); vis[0]=true;

        while(!q.isEmpty()){
            int nd[] = q.remove();
            int v = nd[0];
            int par = nd[1];

            for(Integer adje : adj[v]){
                if(!vis[adje]){
                    vis[adje] = true;
                    q.add(new int[]{adje, v});
                }else if(adje!=par){ isCycle = true; break;}
            }
            if(isCycle) break;
        }
    for(int i = 0 ; i < n ; ++i){
            if(!vis[i]) return false;
    }
        return !isCycle;
    }
}
```

