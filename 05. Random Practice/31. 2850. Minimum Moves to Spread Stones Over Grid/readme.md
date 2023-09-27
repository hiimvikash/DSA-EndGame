# [2850. Minimum Moves to Spread Stones Over Grid](https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/description/)

## Approach
- Visit every 0 stones cell & for each 0 stones cell
    - itterate in every cell which has stones > 1
        - find moves for a stone transfer from eachCells > 1 
        - and make a minimum answer by doing reccursive call for remaining grid. 
![Alt text](save.png)


```java
class Solution {
    public int minimumMoves(int[][] grid) {
        // base case : when grid has no cell with 0 stone then we return minimumMoves = 0;
        int zcc = 0; // count of cells having 0 stones
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(grid[i][j] == 0) zcc++;
            }
        }

        return minimumMoves(grid, zcc);
    }

    private int minimumMoves(int grid[][], int zcc){
        if(zcc == 0) return 0;

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(grid[i][j] == 0){ // identifying 0 stone cell
                    for(int ni = 0; ni<3; ni++){
                        for(int nj = 0; nj<3; nj++){
                            if(grid[ni][nj] > 1){ // going to every cell which has stones > 1
                                int moves = Math.abs(i-ni) + Math.abs(j-nj);
                                grid[ni][nj]--;
                                grid[i][j]++;
                                zcc--;
                                ans = Math.min(ans, moves + minimumMoves(grid, zcc));
                                grid[ni][nj]++;
                                grid[i][j]--;
                                zcc++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
```