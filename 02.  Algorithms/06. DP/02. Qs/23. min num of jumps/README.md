# [**Minimum number of jumps**](https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#)

## Using DP
 ```java
class Solution{
    static int minJumps(int[] arr){
        // your code here
        int n=arr.length;
        if(n==1) return 0;
        if(arr[0]==0) return -1;
        
        int dp[]=new int[n];
        
        for(int i=1; i<n; i++){
            int min=Integer.MAX_VALUE;
            for(int j=i-1; j>=0; j--){
                if(arr[j]>=i-j) min=Math.min(min,dp[j]);
            }
            dp[i]=min+1;
        }
        return dp[n-1]<0? -1 : dp[n-1];
    }
}
```
## O(n) approach
```java
class Solution{
    static int minJumps(int[] arr){
        // your code here
        if(arr[0]==0) return -1;
        int n=arr.length;
        int maxReach=arr[0]; // this will store the maximum reachable index
        int step=arr[0]; // this will make the lader i.e., no. of steps required to reach MaxReach
        int jump=1; // we will always need to take at least one jump.
        
        for(int i=1;i<n;i++){
            if(i==n-1) return jump; // whether we have reached the end of the array, in that case we just need to return the jump variable.
            maxReach=Math.max(maxReach,arr[i]+i); // earlier approach we use to find MaxPowerIndex, this is similar.
            step--; // decrement of this signifies how much step we have taken 
            
            if(step==0){ // this means step has 
                jump++;
                if(i>=maxReach) return -1; // TC like [1 2 1 0 1]  before re-initializing step, we also check whether a step is becoming zero or negative.
                step=maxReach-i; // re-initializing step means we are making lader.here we are storing No. of step left to reach MaxReach from current index i.
            }
        }
        return -1;
    }
}
```