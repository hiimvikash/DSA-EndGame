# [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        ArrayList<int[]> ans=new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        int i = 0;
        while(i < intervals.length){
           int currS = intervals[i][0], currE = intervals[i][1];
            if(currS <= end) end = Math.max(end, currE);
            else{
                ans.add(new int[]{start, end});
                start = currS; end = currE;
            }
            i++;
        }
        ans.add(new int[]{start, end});
        
        return ans.toArray(new int[ans.size()][]);
    }
}
```