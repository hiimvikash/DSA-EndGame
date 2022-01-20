# [**LIS**](https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1#)

```java
class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int arr[])
    {
        // code here
        int dp[]=new int[n];
        
        int ans=dp[0]=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i]) max=Math.max(dp[j],max);
            }
            dp[i]=max+1;
            ans=Math.max(dp[i],ans);
        }
        return ans;        
    }
}
```

## [**Video reference**](https://youtu.be/odrfUCS9sQk)