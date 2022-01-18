# [**Gold Mine Problem**](https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1#)

```java
class Solution{
    static int maxGold(int n, int m, int arr[][])
    {
        // code here
        if(n==1){
            int sum=0;
            for(int j=0;j<m;j++) sum+=arr[0][j];
            return sum;
        }
        
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++) dp[i][m-1]=arr[i][m-1];
        
        for(int j=m-2; j>=0; j--){
            for(int i=0; i<n; i++){
                if(i==0){
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);
                }
                else if(i==n-1){
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],dp[i-1][j+1]);
                }
                else{
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) ans=Math.max(ans,dp[i][0]);
        return ans;
    }
}
```
## [**Video reference**](https://youtu.be/hs0lilfJ7C0)