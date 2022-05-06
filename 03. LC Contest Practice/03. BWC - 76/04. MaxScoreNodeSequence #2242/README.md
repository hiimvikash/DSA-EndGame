# [**2242. Maximum Score of a Node Sequence**](https://leetcode.com/problems/maximum-score-of-a-node-sequence/)

## [**video reference**](https://youtu.be/-lRBr0IEO2A)

## My Approach : 
```java
class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length; // noOfNodes
        
        ArrayList<Integer> adjl[]=new ArrayList[n]; // adjacency List
        // initialization of adjList
        for(int i=0;i<n;i++) adjl[i]=new ArrayList<>();
        
        // making of adj list
        for(int i=0; i<edges.length; i++){
            adjl[edges[i][0]].add(edges[i][1]);
            adjl[edges[i][1]].add(edges[i][0]);
        }
        
        // sorting
        for(ArrayList<Integer> al : adjl){
            Collections.sort(al,(a,b)-> scores[b]-scores[a]);
        }
        
        int ans = -1;
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            int least = scores[u] + scores[v];
            
            for(int j=0; j<Math.min(3,adjl[u].size()); j++){
                int adjU = adjl[u].get(j);
                if(adjU==v) continue;
                
                for(int k=0; k<Math.min(3,adjl[v].size()); k++){
                    int adjV = adjl[v].get(k);
                    if(adjV==u || adjU==adjV) continue;
                    
                    ans = Math.max(ans, least+scores[adjU]+scores[adjV]);
                                      
                }
            }
        }
        return ans;
    }
}
```