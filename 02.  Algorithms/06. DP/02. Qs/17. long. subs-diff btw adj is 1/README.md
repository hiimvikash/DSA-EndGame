# [**Longest subsequence-1**](https://practice.geeksforgeeks.org/problems/longest-subsequence-such-that-difference-between-adjacents-is-one4724/1#)

```java
class Solution{
    static int longestSubsequence(int n, int arr[])
    {
        // code here
        int dp[]=new int[n];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(Math.abs(arr[j]-arr[i])==1) max=Math.max(dp[j],max);
            }
            dp[i]=max+1;
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}
```
