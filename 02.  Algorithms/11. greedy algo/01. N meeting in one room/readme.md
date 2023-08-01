# [N meetings in one room](https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1)
### **Problem Statement:** There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.
## Approach
**Initial Thought Process:-**
Say if you have two meetings, one which gets over early and another which gets over late. Which one should we choose?  If our meeting lasts longer the room stays occupied and we lose our time. On the other hand, if we choose a meeting that finishes early we can accommodate more meetings. Hence we should choose meetings that end early and utilize the remaining time for more meetings.

```java
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<int[]> arr=new ArrayList<>();
        for(int i = 0; i<n; i++){
            arr.add(new int[]{start[i], end[i]});
        }
        Collections.sort(arr, (a,b)-> a[1] - b[1]); // sorting according to end time
        
        int meetingCount = 1;
        int et = arr.get(0)[1];
        
        for(int i = 1; i<n; i++){
            if(arr.get(i)[0] > et){
                meetingCount++;
                et = arr.get(i)[1];
            }
        }
        return meetingCount;
    }
}
```
