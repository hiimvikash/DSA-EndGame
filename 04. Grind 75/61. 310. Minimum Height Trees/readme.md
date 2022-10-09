# [310. Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/)

```java
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans=new ArrayList<>();
        if (n <= 0) return ans;
		if (n == 1) {
			ans.add(0);
			return ans;
		}

        int deg[]=new int[n];

        // make graph : adjaencyList
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph[u].add(v);
            graph[v].add(u);
            
            deg[u]++; deg[v]++;
        }
        // adjaencyList ready
        
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<n; i++) if(deg[i]==1) q.add(i);
        
        while(n>2){
            int size = q.size();
            n-=size;
            while(size-->0){
                int node = q.remove();
                for(int adj : graph[node]){
                    deg[adj]--;
                    if(deg[adj]==1) q.add(adj);
                }
            }
        }
        
        ans.addAll(q);
        return ans;
    }
}
```