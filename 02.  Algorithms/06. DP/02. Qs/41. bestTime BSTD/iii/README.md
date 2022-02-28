# [**123. Best Time to Buy and Sell Stock III(2 transaction)**](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
[**Video reference**](https://youtu.be/wuzTpONbd-0)

```java
class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int ans=0;
        
        int maxPist[]=new int[n]; //(maxProfitIfSoldByToday) this will store max P so far till this ith date(if u can sell atmost on ith date). 
        int lsf=Integer.MAX_VALUE; // least so far (buying price)
        int pist=0; // profit if sold today
        for(int i=0; i<n; i++){
            lsf=Math.min(arr[i],lsf);
            pist=arr[i]-lsf;
            ans=Math.max(pist,ans);
            
            maxPist[i]=ans;
        }
        ans=0;
        
        int maxPibt[]=new int[n]; // (maxProfitIfBoughtToday) this will store max P if bought today and sold in future.
        int msf=Integer.MIN_VALUE; // max so far(selling price)
        int pibt=0; // profit if bought today
        
        for(int i=n-1; i>=0; i--){
            msf=Math.max(arr[i],msf);
            pibt=msf-arr[i];
            ans=Math.max(pibt,ans);
            
            maxPibt[i]=ans;
        }
        
        ans=0;
        
        for(int i=0; i<n; i++){
           ans=Math.max(ans,maxPist[i]+maxPibt[i]);
        }
        return ans;
        
    }
}
```


