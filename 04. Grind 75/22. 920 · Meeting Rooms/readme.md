# [920 · Meeting Rooms](https://www.lintcode.com/problem/920/description)
```java
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        int n = intervals.size();
        Collections.sort(intervals, (a,b)-> a.start - b.start);

        for(int i = 1; i<n; i++){
            if(intervals.get(i).start < intervals.get(i-1).end) return false;
        }
        return true;
    }
}
```