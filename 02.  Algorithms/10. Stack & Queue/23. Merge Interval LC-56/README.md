# **[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)**
**TC = O(N + NlogN) SC = O(N)**
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null) 
            return res.toArray(new int[0][]);
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int arr[] : intervals) {
            if(arr[0] <= end) {
                end = Math.max(end, arr[1]);
            }
            else {
                res.add(new int[]{start, end});
                start = arr[0];
                end = arr[1];
            }
        }
        res.add(new int[]{start, end});
       return res.toArray(new int[res.size()][]);
    }
}
```
## **[Video Reference](https://youtu.be/2JzRBPFYbKE)**