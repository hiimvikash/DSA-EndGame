# [**Reach a given score**](https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1#)

## Using DP
 ```java
class Geeks {
    public long count(int sum) {
        int arr[]={3,5,10};
        int n=arr.length;
        
        long dp[][]=new long[n+1][sum+1];
        for(long d[]: dp) Arrays.fill(d,-1);
        
        return count(arr,n,sum,dp);
        // Add your code here.
        
       
    }
    long count(int arr[], int n, int sum, long dp[][]){
        if(n==0){
            if(sum==0) return 1;
            return 0;
        }
        
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(arr[n-1]<=sum){
            return dp[n][sum]= count(arr,n,sum-arr[n-1],dp)+count(arr,n-1,sum,dp); // pick
        }
        return dp[n][sum]=count(arr,n-1,sum,dp);
    }
}
```