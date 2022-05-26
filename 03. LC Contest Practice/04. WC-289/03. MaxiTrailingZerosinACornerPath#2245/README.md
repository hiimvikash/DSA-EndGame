# [**2245. Maximum Trailing Zeros in a Cornered Path**](https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/)

**Hint - "Trailing 0's will not be affected(in -ve way) by including more element"**
- **maintain the prefix sum for the counts of 2's and 5's**

![image](https://user-images.githubusercontent.com/71629248/169661168-b300b8d0-c9b6-4995-9355-e08885d83c26.png)
![image](https://user-images.githubusercontent.com/71629248/169661156-20f03cc4-7894-42de-802a-02ae6aa0c9ce.png)

## My Approach : 
```java
class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        
        int h[][][]=new int[n][m][2];
        int v[][][]=new int[n][m][2];
        
        makeHv(grid, h, v, n, m);
        
        
        int res=-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // take a point x, 
                            // UP part including x is v1
                           //  DOWN part including x is v2
                          //  LEFT part excluding x is h1
                         //  RIGHT part excluding x is h2
                int v1[] = v[i][j];
                int v2[] = (i==0) ? v[n-1][j] : new int[]{v[n-1][j][0] - v[i-1][j][0], v[n-1][j][1] - v[i-1][j][1]};
                
                int h1[] = (j>0)? h[i][j-1] : new int[]{0,0};
                int h2[] = new int[]{h[i][m-1][0] - h[i][j][0], h[i][m-1][1] - h[i][j][1]};
                
                res=Math.max(res,Math.min(v1[0]+h1[0],v1[1]+h1[1]));                
                res=Math.max(res,Math.min(v1[0]+h2[0],v1[1]+h2[1]));                
                res=Math.max(res,Math.min(v2[0]+h1[0],v2[1]+h1[1]));                
                res=Math.max(res,Math.min(v2[0]+h2[0],v2[1]+h2[1]));     
            }
        }
        return res;
        
    }
    
    private void makeHv(int grid[][], int h[][][], int v[][][], int n, int m){
        // h[] making
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j==0){
                    h[i][j][0] = get25(grid[i][j])[0];
                    h[i][j][1] = get25(grid[i][j])[1];
                }else{
                    h[i][j][0] = get25(grid[i][j])[0] + h[i][j-1][0];
                    h[i][j][1] = get25(grid[i][j])[1] + h[i][j-1][1];
                }
            }
        }
        // h[] made
        
        
        // v[] making
        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                if(i==0){
                    v[i][j][0] = get25(grid[i][j])[0];
                    v[i][j][1] = get25(grid[i][j])[1];
                }else{
                    v[i][j][0] = get25(grid[i][j])[0] + v[i-1][j][0];
                    v[i][j][1] = get25(grid[i][j])[1] + v[i-1][j][1];
                }
            }
        }
        // v[] made
    }
    
    private int[] get25(int n){
        int n2=0,n5=0;
        while(n%2==0){
            n/=2;
            n2++;
        }
        while(n%5==0){
            n/=5;
            n5++;
        }
        
        return new int[]{n2,n5};
    }

}
```

## [**Video Reference**](https://youtu.be/ExsNLEl4nQs)
