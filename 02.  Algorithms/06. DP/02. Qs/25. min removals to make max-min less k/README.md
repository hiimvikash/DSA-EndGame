# [**Minimum removals from array to make max – min <= K**](https://www.geeksforgeeks.org/minimum-removals-array-make-max-min-k/)

## Using DP
 ```java
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int arr[]={1, 3, 4, 9, 10, 11, 12, 17, 20};
		Arrays.sort(arr);
		int k=4;
		int n=arr.length;
		int dp[][]=new int[n][n];
		for(int d[]:dp) Arrays.fill(d,-1);
		
		System.out.println(mr(arr,0,n-1,k,dp));
	}
	static int mr(int arr[], int i, int j, int k, int dp[][]){
	    if(i>j) return 0;
	    if((arr[j]-arr[i])<=k) return 0;
	    if(dp[i][j]!=-1) return dp[i][j];
	    return dp[i][j]= 1+Math.min(mr(arr,i+1,j,k,dp),mr(arr,i,j-1,k,dp));
	}
}
```