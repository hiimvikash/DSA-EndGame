## Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.
```java
class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {
        // code here
        ArrayList<int[]> arr=new ArrayList<>();
        for(int i = 0; i<n; i++){
            arr.add(new int[]{start[i], end[i], i+1});
        }
        Collections.sort(arr, (a,b)->a[1] - b[1]);
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr.get(0)[2]);
        
        int et = arr.get(0)[1]; // previous ET
        for(int i = 1; i<n; i++){
            if(arr.get(i)[0] > et){
                ans.add(arr.get(i)[2]);
                et = arr.get(i)[1];
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
```