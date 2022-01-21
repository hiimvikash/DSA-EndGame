# [**LCS Space Optimized**](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#)

Note : just write n<sup>2</sup> dp tabulation, and replace all ```i``` inside dp[][] to ```i%2``` and ```i-1``` to ```(i+1)%2```.
```java
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[2][m+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i%2][j]= 1+dp[(i+1)%2][j-1];
                }
                else{
                    dp[i%2][j]=Math.max(dp[(i+1)%2][j],dp[i%2][j-1]);
                }
            }
        }
        return dp[n%2][m];
    }
    
}
```

## [**Video reference**](https://youtu.be/Iuw2nOvYW20)