# **[994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)**

```java
class Solution {
    class index{
        int i; int j;
        public index(int i, int j){
            this.i=i; this.j=j;
        }
    }
    public int orangesRotting(int[][] arr) {
        int n=arr.length; int m=arr[0].length; // n rows, m col
        Queue<index> q=new LinkedList<>();
        int fo=0; // store the count of freshOranges
        int t=0; //  returning time
        
        // Step 1 : add rotten oranges position in Q
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==2) q.add(new index(i,j));
                if(arr[i][j]==1) fo++; // count of fo;
            }
        }
        
        // Step 2: do bfs
        while(!q.isEmpty()){
            int size=q.size();
            int flag=0;
            while(size>0){
                index pos=q.poll();
                // up
                if(pos.i-1 >= 0){ // if up possible
                    if(arr[pos.i-1][pos.j]==1){
                        arr[pos.i-1][pos.j]=2;
                        q.add(new index(pos.i-1,pos.j));
                        flag=1;
                        fo--;
                    }
                }
                // down
                if(pos.i+1 < n){ // if down possible
                   if(arr[pos.i+1][pos.j]==1){
                        arr[pos.i+1][pos.j]=2;
                        q.add(new index(pos.i+1,pos.j));
                       flag=1;
                       fo--;
                    } 
                }
                // left
                if(pos.j-1 >=0){
                    if(arr[pos.i][pos.j-1]==1){
                        arr[pos.i][pos.j-1]=2;
                        q.add(new index(pos.i,pos.j-1));
                        flag=1;
                        fo--;
                    }
                }
                // right
                if(pos.j+1 < m){
                    if(arr[pos.i][pos.j+1]==1){
                        arr[pos.i][pos.j+1]=2;
                        q.add(new index(pos.i,pos.j+1));
                        flag=1;
                        fo--;
                    }
                }
                size--;
            }
            if(flag==1) t++;
        }
        if(fo==0) return t;
        return -1;
    }
}
```
[**Video reference**](https://youtu.be/pUAPcVlHLKA)