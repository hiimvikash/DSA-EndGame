# [733. Flood Fill](https://leetcode.com/problems/flood-fill/)
## BFS
```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini = image[sr][sc];
        if(ini == color) return image;
        
        int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
        int n = image.length, m = image[0].length;
        int arr[][] = image.clone();
        
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        
        while(!q.isEmpty()){
            int cord[] = q.remove(); int i = cord[0], j = cord[1];
            arr[i][j] = color;
            for(int k = 0; k<4; k++){
                if(i+di[k] >= 0 && i+di[k] < n && j+dj[k] >= 0 && j+dj[k] < m && arr[i+di[k]][j+dj[k]] == ini){
                    arr[i+di[k]][j+dj[k]] = color;
                    q.add(new int[]{i+di[k], j+dj[k]});
                }
            }
            
        }
        return arr;
    }
}
```
[Video Reference](https://youtu.be/C-2_uSRli8o)

## DFS
```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini = image[sr][sc];
        if(ini == color) return image;
        
        int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
        int n = image.length, m = image[0].length;
        int arr[][] = image.clone();
        
        dfs(arr, sr, sc, ini, color,di,dj,n,m);
        return arr;
    }
    
    public void dfs(int arr[][], int i, int j, int ini, int color, int di[], int dj[], int n, int m){
        arr[i][j] = color;
        
        for(int k = 0; k<4; k++){
            if(i+di[k] >= 0 && i+di[k] < n && j+dj[k] >= 0 && j+dj[k] < m && arr[i+di[k]][j+dj[k]] == ini){
                dfs(arr,i+di[k],j+dj[k],ini,color,di,dj,n,m);
            }
        }
    }
}
```