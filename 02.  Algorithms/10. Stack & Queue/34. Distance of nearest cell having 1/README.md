# **[Distance of nearest cell having 1](https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1#)**

```java
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length; int m=grid[0].length;
        Queue<index> q=new LinkedList<>();
        int ans[][]=new int[n][m];
        
        // fill Q with 1's index, fill ans[][] of 1's place with 0 and other with M 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    q.add(new index(i,j));
                    ans[i][j]=0;
                }else{
                    ans[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        
        // Q is not empty
        while(!q.isEmpty()){
            index pos=q.poll();
            // up
            if(pos.i-1 >=0){
                                            // existingVal         currVal+1
                ans[pos.i-1][pos.j]=Math.min(ans[pos.i-1][pos.j],ans[pos.i][pos.j]+1);
               if(ans[pos.i-1][pos.j]==ans[pos.i][pos.j]+1) q.add(new index(pos.i-1,pos.j));
            }
            // down
            if(pos.i+1<n){
                ans[pos.i+1][pos.j]=Math.min(ans[pos.i+1][pos.j],ans[pos.i][pos.j]+1);
                if(ans[pos.i+1][pos.j]==ans[pos.i][pos.j]+1) q.add(new index(pos.i+1,pos.j));
            }
            // right
            if(pos.j+1<m){
               ans[pos.i][pos.j+1]=Math.min(ans[pos.i][pos.j+1],ans[pos.i][pos.j]+1);
               if(ans[pos.i][pos.j+1]==ans[pos.i][pos.j]+1) q.add(new index(pos.i,pos.j+1));
            }
            // left
            if(pos.j-1>=0){
                ans[pos.i][pos.j-1]=Math.min(ans[pos.i][pos.j-1],ans[pos.i][pos.j]+1);
                if(ans[pos.i][pos.j-1]==ans[pos.i][pos.j]+1) q.add(new index(pos.i,pos.j-1));
            }
        }
        return ans;
    }
    class index{
        int i, j;
        public index(int i, int j){
            this.i=i; this.j=j;
        }
    }
}
```

[**Video reference**](https://youtu.be/7AhF1h1fGnk)