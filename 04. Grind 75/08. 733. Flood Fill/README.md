# [733. Flood Fill](https://leetcode.com/problems/flood-fill/)
## BFS
```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc]; int n = image.length, m = image[0].length;
        
        if(initial == color) return image;
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        
        while(!q.isEmpty()){
            Pair nd = q.remove();
            if(image[nd.i][nd.j] == initial) image[nd.i][nd.j] = color;
            
            if(nd.i+1 < n && image[nd.i+1][nd.j] == initial) q.add(new Pair(nd.i+1, nd.j));
            if(nd.i-1 >=0 && image[nd.i-1][nd.j] == initial) q.add(new Pair(nd.i-1, nd.j));
            
            if(nd.j+1 < m && image[nd.i][nd.j+1] == initial) q.add(new Pair(nd.i, nd.j+1));
            if(nd.j-1 >= 0 && image[nd.i][nd.j-1] == initial) q.add(new Pair(nd.i, nd.j-1));
        }
        return image;
    }
}

class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i; this.j = j;
    }
}
```
[Video Reference](https://youtu.be/C-2_uSRli8o)

## DFS
```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};
        int ans[][] = image.clone();
        dfs(ans,image, image.length, image[0].length, image[sr][sc], color, dr, dc,  sr, sc);
        return ans;
    }
    
    
    public void dfs(int arr[][], int img[][], int n, int m, int initial, int color, int dr[], int dc[], int i, int j){
            arr[i][j] = color;
        
            for(int k=0; k<4; k++){
                int nr = i+dr[k];
                int nc = j+dc[k];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && img[nr][nc]==initial && arr[nr][nc]!=color) dfs(arr,img,n,m,initial,color,dr,dc, nr,nc);
            }
        
    }
}
```