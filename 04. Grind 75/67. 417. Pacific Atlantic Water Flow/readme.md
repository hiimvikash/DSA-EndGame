# [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)

```java
class Solution {
    int di[] = {-1, 0, 1, 0}; int dj[] = {0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
         List<List<Integer>> res = new ArrayList<>();
        
        boolean po[][] = new boolean[n][m];
        boolean ao[][] = new boolean[n][m];
        
        for(int j = 0; j<m; j++){
            dfs(heights, 0, j, n, m, po);
            dfs(heights, n-1, j, n, m, ao);
        }
        for(int i = 0; i<n; i++){
            dfs(heights, i, 0, n, m, po);
            dfs(heights, i, m-1, n, m, ao);
        }
        
        // preparing answer
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(po[i][j] && ao[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }
  
        return res;
    }
    
    
    private void dfs(int heights[][], int i, int j, int n, int m, boolean o[][]){
        o[i][j] = true;
        
        for(int k = 0; k<4; k++){
            if(i+di[k] >= 0 && i+di[k]<n && j+dj[k] >=0 && j+dj[k]<m && !o[i+di[k]][j+dj[k]] && heights[i+di[k]][j+dj[k]] >= heights[i][j]) dfs(heights, i+di[k], j+dj[k], n, m, o);
        }
    }
}
```

[video reference](https://youtu.be/krL3r7MY7Dc)