# [919 · Meeting Rooms II](https://www.lintcode.com/problem/919/)

## Room req = Maximum no. Of meeting goingOn at any point of timeee
```JAVA
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
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        List<int[]> timestamp=new ArrayList<>();
        for(Interval i : intervals){
            timestamp.add(new int[]{i.start,1});
            timestamp.add(new int[]{i.end,0});
        }
        Collections.sort(timestamp, (a,b)-> a[0]-b[0]);

        int count = 0; int ans = -1;
        for(int a[] : timestamp){
            if(a[1] == 1) count++;
            else count--;

            ans = Math.max(ans,count);
        }

        return ans;
    }
}
```
[video](https://youtu.be/FdzJmTCVyJU)