# [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/description/)

# Approach :-
- Here we will use Dijkstra Algo to find shortest path
## What is Dijkstra ?
- This algo is use to find shortest path from given Node to every other node
- For Dijkstra u need :- 
    - a dis[] array initialise with INF(this dis[] stores the distance from source node) & dis[src] = 0
    - A minPQ(based on disFsrc) which will store a node and distanceFromSrc to reach that node
    - initially PQ will be initialsed with srcNode and disFsrc = 0
    - Till Pq is not empty
        - remove one node whose disFsrc is minimum
        - Traverse it's Adjacent
            - calculate there disFsrc and add in dis[adj] if(calculativeDisFSrc < dis[adj])
            - now add this in PQ

```java
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // make graph
        ArrayList<int[]> graph[] = new ArrayList[n+1];
        for(int i = 0; i<=n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i<times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            graph[u].add(new int[]{v,w});
        }
        // graph made

        // dis[] 
        int inf = Integer.MAX_VALUE;
        int dis[]=new int[n+1];
        Arrays.fill(dis,inf);
        dis[k] = 0;
        // dis[] madeee

        // pq made
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.disFsrc - b.disFsrc);
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int v = p.v;
            int disFsrc = p.disFsrc;

            for(int adjarr[]: graph[v]){
                int adj = adjarr[0];
                int adjdis = adjarr[1];

                if(disFsrc + adjdis < dis[adj]){
                    dis[adj] = disFsrc + adjdis;
                    pq.add(new Pair(adj,dis[adj]));
                }
            }
        }
        int ans = -1;
        for(int i = 1; i<=n; i++){
            if(dis[i]==inf) return -1;
            ans = Math.max(dis[i],ans);
        }
        return ans;
    }
}

class Pair{
    int v;
    int disFsrc;

    public Pair(int a, int b){
        v = a;
        disFsrc = b;
    }
}
```