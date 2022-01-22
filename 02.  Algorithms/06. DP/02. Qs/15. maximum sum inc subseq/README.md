# [**Maximum sum increasing subsequence**](https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1#)

```java
class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int dp[]=new int[n];
	    dp[0]=arr[0];
	    int ans=dp[0];
	    for(int i=1; i<n; i++){
	        int max=0;
	        for(int j=i-1; j>=0; j--){
	            if(arr[j]<arr[i]) max=Math.max(max,dp[j]);
	        }
	        dp[i]=max+arr[i];
	        ans=Math.max(ans,dp[i]);
	    }
	    return ans;
	}  
}
```

