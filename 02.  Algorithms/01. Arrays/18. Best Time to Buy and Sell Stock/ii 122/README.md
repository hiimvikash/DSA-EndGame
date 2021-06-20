# **[122. Best Time to Buy and Sell Stock - II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)**

**TC = O(N) SC = O(1)**

## My Apprroach :-

```java
class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int ip=0;int p=0; // profit and initial profit
        int buy=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]<buy && p==0) buy=arr[i];
            if(arr[i]-buy>=p) p=arr[i]-buy;
            else{
                ip+=p;
                p=0;
                buy=Integer.MAX_VALUE;
                i--;
            }
        }
        ip+=p;
        return ip;
    }
}
```

## Editorial :-

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
```
