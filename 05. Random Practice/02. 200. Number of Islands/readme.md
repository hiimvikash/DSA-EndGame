# [200. Number of Islands](https://leetcode.com/problems/number-of-islands/description/)

```java
class Solution {
    int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        // when u were given a graph they seems to be connected coz of adjaencyList
        // Here assume each 1s cordinate as a NODE, we can see them connected coz they're 4 directionally adjacent

        // u itterate from 1 to N nodes if(!vis[i])
        // then u run a BFS traversal for each Node and mark the every node visted in that traversal
        // - HERE itterate for each cordinate of 1s and run a  BFS traversal

        // and u do a component++ whenever node was not visited
        // which state - that node is not connected to previous BFS traversal NODE

        /**
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                nofComponents++;
                bfs(i);
            }
        }
         */
        // Now read point 2 again..u will get it, Here assume each 1s cordinate as a NODE


        int n = grid.length;
        int m = grid[0].length;


        // Initialise with all necesity before starting BFS traversal..

        // make a vis array for each node
        boolean vis[][] = new boolean[n][m];
        int islandCount = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    islandCount++;
                    bfs(i, j, grid, vis, n, m);
                }
            }
        }
        return islandCount;
    }

    void bfs(int i, int j, char grid[][], boolean vis[][], int n, int m){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j] = true;

        while(!q.isEmpty()){
            int cord[] = q.remove();
            i = cord[0];
            j = cord[1];

            // now traverse there adjacent
            for(int k = 0; k<4; k++){
                int nr = i+di[k];
                int nc = j+dj[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && !vis[nr][nc]){
                    q.add(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }

    }
}
```