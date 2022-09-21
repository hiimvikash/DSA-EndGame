# [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)

```java
class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        int ans[][]=new int[k][2];
        int n = points.length;
        
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((int p1[], int p2[]) -> ((p1[0]*p1[0]) + (p1[1]*p1[1])) - ((p2[0]*p2[0]) + (p2[1]*p2[1])));
        
        for(int point[] : points){
            pq.add(new int[]{point[0], point[1]});
        }
        
        while(k!=0){
            int p[] = pq.remove();
            ans[k-1][0] = p[0];
            ans[k-1][1] = p[1];
            
            k--;
        }
        return ans;
    }
}
```

## Sorting
```java
class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        int ans[][]=new int[k][2];
        int n = points.length;
        
        Arrays.sort(points, (int p1[], int p2[]) -> ((p1[0]*p1[0]) + (p1[1]*p1[1])) - ((p2[0]*p2[0]) + (p2[1]*p2[1])));
        
        
        for(int i = 0; i<k; i++){
            ans[i] = points[i];
        }
        
        return ans;
    }
}
```