# [**BBT Counter**](https://practice.geeksforgeeks.org/problems/bbt-counter4914/1#)

## Using DP
 ```java
class Solution {
    static long countBT(int h){
        // code here
        // height H is known as BBT when its (HLST - HRST)<=1
        // so possible heights of LST,RST are
        // (h-1, h-2) (h-2, h-1) (h-1, h-1)
        // (h-1 * h-2) + (h-2 * h-1) + (h-1 * h-1) => h-1(2(h-2)+(h-1))
        long mod=1000000007;
        long dp[]=new long[h+1];
        dp[0]=1%mod; dp[1]=1%mod;
        
        for(int i=2;i<=h;i++){
            dp[i]=(dp[i-1]*( (2*dp[i-2]) + dp[i-1] ) ) % mod;
        }
        return dp[h];
        
    }
}
```