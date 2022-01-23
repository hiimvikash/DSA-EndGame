# [**Max length chain**](https://practice.geeksforgeeks.org/problems/max-length-chain/1#)

 
```java
class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
       int dp[]=new int[n];
       Arrays.sort(arr,(a,b)->(a.y - b.y));
       dp[0]=1;
       int ans=1;
       for(int i=1; i<n; i++){
           int max=0;
           for(int j=i-1; j>=0; j--){
               if(arr[j].y<arr[i].x) max=Math.max(max,dp[j]);
           }
           dp[i]=max+1;
           ans=Math.max(ans,dp[i]);
       }
       return ans;
    }
}
```
