# [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
        
        Queue<int[]> q=new LinkedList<>();
        int t = 0; // time
        int fo = 0; // fresh orange count
        
        // add all Rotten's in Queue
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                else if(grid[i][j] == 1) fo++;
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size(); int flag = 0;
            while(size > 0){
                int cord[] = q.remove(); size--;
                int x = cord[0], y = cord[1]; 
                for(int k = 0; k<4; k++){
                    if(x + di[k] >=0 && x + di[k] <n &&  y + dj[k] >=0 && y + dj[k] < m && grid[x + di[k]][y + dj[k]] == 1){
                        fo--;
                        grid[x + di[k]][y + dj[k]] = 2; // rot them
                        q.add(new int[]{x + di[k], y + dj[k]});
                        flag = 1;
                    }
                }
                
            } // inner while
            if(flag == 1) t++;
        }
        if(fo==0) return t;
        return -1;
    }
}
```