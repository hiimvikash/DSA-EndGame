# [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)
```java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int dis[][]=new int[n][m];
        
        Queue<Pair> q=new LinkedList<>();
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dis[i][j] = n+m; // max;
                if(mat[i][j]==0){ dis[i][j]=0; q.add(new Pair(i,j)); }
            }
        }
        
        int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.remove();
            
            for(int k = 0; k<4; k++){
                if(p.i + di[k] >=0 && p.i + di[k] <n &&  p.j + dj[k] >=0 && p.j + dj[k] <m){
                    dis[p.i + di[k]][p.j + dj[k]] = Math.min(dis[p.i + di[k]][p.j + dj[k]], dis[p.i][p.j] + 1);
                    if(dis[p.i + di[k]][p.j + dj[k]] == dis[p.i][p.j] + 1) q.add(new Pair(p.i + di[k], p.j + dj[k]));
                }
            }
        }    
         return dis;   
    }
}

class Pair{
    int i; int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
```