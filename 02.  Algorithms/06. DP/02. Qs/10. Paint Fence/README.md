# [**Paint Fence**](https://www.lintcode.com/problem/paint-fence/description)

```java
public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        int dp[][]=new int[3][n+1];
        
        if(n==1) return k;        
        dp[0][2]=k;
        dp[1][2]=k*(k-1);
        dp[2][2]=dp[0][2]+dp[1][2];

        for(int j=3;j<=n;j++){
            dp[0][j]=dp[1][j-1];
            dp[1][j]=(k-1)*dp[2][j-1];
            dp[2][j]=dp[0][j]+dp[1][j];
        }
        return dp[2][n];
    }
}
```
## [**Video reference**](https://youtu.be/ju8vrEAsa3Q)