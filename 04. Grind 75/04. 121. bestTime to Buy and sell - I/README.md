# [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

```java
class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        
        int dp[]=new int[n];
        // dp[i] says How much profit will I make if i sell on ith-day
        int min = arr[0];
        int ans = 0;
        for(int i = 1; i<n; i++){
            min = Math.min(min, arr[i]);
            dp[i] = arr[i] - min;
            
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
```