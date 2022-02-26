# [**121. Best Time to Buy and Sell Stock - II (Infinite Transaction)**](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
[**Video reference**](https://youtu.be/HWJ9kIPpzXs)

```java
class Solution {
    public int maxProfit(int[] arr) {
        int bd=0;
        int sd=0;
        int ans=0;
        int n=arr.length;
        
        for(int i=1; i<n; i++){
            if(arr[i]>=arr[i-1]) sd++;
            else{
                ans+=(arr[sd]-arr[bd]);
                sd=bd=i;
            }
        }
        ans+=(arr[sd]-arr[bd]);
        return ans;
    }
}

// participate in every transaction of BUY SELL, upstrokes are the oportunity to make profit.
```


