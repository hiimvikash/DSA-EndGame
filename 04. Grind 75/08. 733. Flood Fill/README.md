# [733. Flood Fill](https://leetcode.com/problems/flood-fill/)
## Itterative
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