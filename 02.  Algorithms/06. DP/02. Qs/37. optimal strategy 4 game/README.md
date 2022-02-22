# [**Optimal Strategy For A Game **](https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1#)


## [**Video Reference**](https://youtu.be/VwjKZQCaTC8)

```java
class solve
{
    //Function to find the maximum possible amount of money we can win.
    
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        long dp[][]=new long[n][n]; for(long d[]:dp) Arrays.fill(d,-1);
        return solve(arr,0,n-1,dp);
        
    }
    static long solve(int arr[], int i, int j, long dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        long x=arr[i]+Math.min(solve(arr,i+2,j,dp),solve(arr,i+1,j-1,dp));
        long y=arr[j]+Math.min(solve(arr,i+1,j-1,dp),solve(arr,i,j-2,dp));
        
        return dp[i][j]=Math.max(x,y);
    }
}
```