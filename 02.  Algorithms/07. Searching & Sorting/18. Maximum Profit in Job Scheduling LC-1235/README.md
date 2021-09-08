# [**1235. Maximum Profit in Job Scheduling**](https://leetcode.com/problems/maximum-profit-in-job-scheduling/)

## Linear Search + DP O(N<sup>2</sup>)
## [**Video Reference Part 1**](https://youtu.be/CgLpOeRA6Co)
## [**Video Reference Part 2**](https://youtu.be/Iw8XtK1HCCw)
```java
class Solution {
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int n=start.length;
         // Step 1 make a job array and sort it according to finish time
        int jobs[][]=new int[n][3];
        for(int i=0;i<n;i++){
            jobs[i]= new int[]{start[i],end[i],profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        // Step 2 make a dp[] and initialize it with dp[0]
        int dp[]=new int[n];
        dp[0]=jobs[0][2];
        // Step 3 make profit for ith activity
        for(int i=1;i<n;i++){
            int including=jobs[i][2];
            int lnc=-1; // latest non conflict index
            // search for lnc index This is LINEARSEARCH
            for(int j=i-1;j>=0;j--){
                if(jobs[j][1]<=jobs[i][0]){ // jobs[j].end<=jobs[i].start then j is our lnc
                    lnc=j; break;
                }
            }
            if(lnc!=-1){
                including+=dp[lnc];
            }
            dp[i]=Math.max(including,dp[i-1]);
        }
        return dp[n-1];
    }
}
```
## Binary Search + DP O(N logN)
```java
class Solution {
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int n=start.length;
         // Step 1 make a job array and sort it according to finish time
        int jobs[][]=new int[n][3];
        for(int i=0;i<n;i++){
            jobs[i]= new int[]{start[i],end[i],profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        // Step 2 make a dp[] and initialize it with dp[0]
        int dp[]=new int[n];
        dp[0]=jobs[0][2];
        // Step 3 make profit for ith activity
        for(int i=1;i<n;i++){
            int including=jobs[i][2];
            int lnc=bs(jobs,i); // latest non conflict index
            if(lnc!=-1){
                including+=dp[lnc];
            }
            dp[i]=Math.max(including,dp[i-1]);
        }
        return dp[n-1];
    }
    private int bs(int jobs[][], int i){
        int start=0;
        int end=i-1;
        int lnc=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(jobs[mid][1]<=jobs[i][0]){ // jobs[mid].end<=jobs[i].start then j is our lnc
                lnc=mid;
                start=mid+1;
            }
            else end=mid-1;
        }
        return lnc;
    }
}
```