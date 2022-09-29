# [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)

```java
class Solution {
    public int numIslands(char[][] grid) {
        int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int countOfIsland = 0;
        boolean vis[][]=new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j]!='0' && !vis[i][j]){
                    countOfIsland++;
                    // BFS START with a STARTING POINT
                    q.add(new int[]{i,j}); // add a starting point
                    while(!q.isEmpty()){
                        int cord[] = q.remove(); int x = cord[0], y = cord[1];
                        vis[x][y] = true;
                        
                        for(int k = 0; k<4; k++){
                            if(x + di[k] >=0 && x + di[k] <n &&  y + dj[k] >=0 && y + dj[k] < m && grid[x + di[k]][y + dj[k]]!='0' && !vis[x + di[k]][y + dj[k]]){
                                vis[x + di[k]][y + dj[k]] = true;
                                q.add(new int[]{x + di[k], y + dj[k]});
                            }
                        } // exploring all four directions
                    }// while loop ends
                    
                }
                
            }
        }
        return countOfIsland;
    }
}


/** conditions for exploring 4 directions are :-
    - they should be valid cordinates
    - they should not be Visited
    - they should not be ocean
    
**/
```

[video refer](https://youtu.be/muncqlKJrH0)