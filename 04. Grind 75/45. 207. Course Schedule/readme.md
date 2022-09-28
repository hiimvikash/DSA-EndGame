# [207. Course Schedule](https://leetcode.com/problems/course-schedule/)

- Concept of topological sort

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
        int indeg[]=new int[numCourses];
        
        for(int i = 0; i<prerequisites.length; i++){
            int fromN = prerequisites[i][0];
            int toN = prerequisites[i][1];
            
            graph[fromN].add(toN);
            indeg[toN]++;
        }
        
        // Now TOPOLOGICAL SORT START USING BFS
        int cnt = 0;
        Queue<Integer> q=new LinkedList<>();
        for(int i = 0; i<numCourses; i++) if(indeg[i]==0) q.add(i);
        
        while(!q.isEmpty()){
            int n = q.remove();
            cnt++;
            
            for(int adj : graph[n]){
                indeg[adj]--;
                if(indeg[adj]==0) q.add(adj);
            }
        }
        return cnt==numCourses;
        
    }
}
```