# [**Minimum cost to fill given weight in a bag**](https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1#)

## Using DP
 ```java
class Solution
{
    int inf=100000000;
	public int minimumCost(int cost[], int n,int w)
	{
	    int dp[][]=new int[n+1][w+1];
	    for(int d[] : dp)Arrays.fill(d,-1);
	    
		int ans= mc(cost,n,w,dp);
		return ans>=inf? -1 : ans;
	}
	int mc(int arr[], int n, int w, int dp[][]){
	    if(w==0 && n==0) return 0;
	    
	    if(n==0) return inf;
	    
	    if(dp[n][w]!=-1) return dp[n][w];
	    
	    if(arr[n-1]==-1) return dp[n][w]= mc(arr,n-1,w,dp);
	    else if(n<=w) return dp[n][w]= Math.min(arr[n-1]+mc(arr,n,w-n,dp),mc(arr,n-1,w,dp));
	    else return dp[n][w]= mc(arr,n-1,w,dp);
	    
	}
}
```