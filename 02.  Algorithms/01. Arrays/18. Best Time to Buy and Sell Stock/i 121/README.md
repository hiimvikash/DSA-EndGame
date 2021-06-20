# **[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)**

**TC = O(N) SC = O(1)**

```java
class Solution {
    public int maxProfit(int[] arr) {
       int n=arr.length;
       int profit=0;
       int buy=Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
           if(arr[i] < buy) buy=arr[i];
           if(arr[i]-buy > profit) profit=arr[i]-buy;
       }
        return profit;
    }
}
```

## **[Video Reference](https://youtu.be/eMSfBgbiEjk)**
