# [57. Insert Interval](https://leetcode.com/problems/insert-interval/)
```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> ans=new ArrayList<>();
        
        int s = newInterval[0], e = newInterval[1];
        
        // add all the intervals which has ended before starting of newInterval
        int i = 0;
        while(i<n && intervals[i][1] < s) {
            ans.add(new int[]{intervals[i][0], intervals[i][1]}); i++; 
        }
        
        // add all the overlapping intervals : intervals.s < e
        while(i<n && intervals[i][0] <= e){
            s = Math.min(s, intervals[i][0]);
            e = Math.max(e, intervals[i][1]);
            i++;
        }
        ans.add(new int[]{s, e});
        
        // add remaining interval.s > e
        while(i<n){
            ans.add(new int[]{intervals[i][0], intervals[i][1]}); i++;
        }
        
        return ans.toArray(new int[ans.size()][]);
        
    }
}
```