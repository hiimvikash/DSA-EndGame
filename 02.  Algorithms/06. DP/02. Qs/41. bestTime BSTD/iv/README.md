# [**188. Best Time to Buy and Sell Stock IV(k transaction)**](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
[**Video reference**](https://youtu.be/3YILP-PdEJA)

```java
class Solution {
    public int maxProfit(int k, int[] prices) {
        int c=prices.length; // no. of days
        if(c==0 || k==0) return 0;
        int dp[][]=new int[k+1][c];
        
        for(int i=0;i<c;i++){
            dp[0][i]=0; // if K is 0, profit is 0
        }
        
        for(int j=0; j<=k; j++){
            dp[j][0]=0; // profit in a day is 0, no matter of K transaction
        }
        
        
        for(int i=1; i<=k; i++){
            for(int j=1;j<c;j++){
                int maxy=Integer.MIN_VALUE;
                for(int p=j-1;p>=0;p--){
                    maxy=Math.max(maxy,prices[j]-prices[p] + dp[i-1][p]);
                }
                dp[i][j] = Math.max(dp[i][j-1],maxy);
            }
        }
        return dp[k][c-1];
    }
}
```


