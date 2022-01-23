# [**Largest square formed in a matrix**](https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1#)

 Note : each cell in matrix denotes **"largest square possible if that position is considered as top-left 1"**
```java
class Solution{
    static int maxSquare(int n, int m, int arr[][]){
        // code here
        int dp[][]=new int[n][m];
        int ans=0;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if((i==n-1 || j==m-1) && arr[i][j]==1) dp[i][j]=1;
                else if(arr[i][j]==0) continue;
                else{
                    dp[i][j]=Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i+1][j+1]))+1;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
```
## [**video reference**](https://youtu.be/UagRoA3C5VQ)