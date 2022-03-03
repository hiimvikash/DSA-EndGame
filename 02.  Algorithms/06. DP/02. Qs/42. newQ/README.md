# [**121. Best Time to Buy and Sell Stock - II**](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
[**Video reference**](https://youtu.be/4YjEHmw1MX0)

```java
class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
                
        int lsf=Integer.MAX_VALUE;
        int pisd=0;// profit if sold today
        int ans=0;
        
        for(int i=0; i<n; i++){
            lsf=Math.min(arr[i],lsf);
            
            pisd=arr[i]-lsf;
            ans=Math.max(pisd,ans);
        }
        return ans;
    }
}
```


