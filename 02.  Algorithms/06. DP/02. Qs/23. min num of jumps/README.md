# [**Minimum number of jumps**](https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#)

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
