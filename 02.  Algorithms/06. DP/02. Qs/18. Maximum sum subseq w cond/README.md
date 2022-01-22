# [**Maximum subsequence sum such that no three are consecutive**](https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/)

![dpq1](https://user-images.githubusercontent.com/71629248/150648558-d6e17b2a-9ca8-4228-a4a4-087c71dca8c0.png)

## Recurssive 
```java
class GFG {
	public static void main (String[] args) {
		int arr[]={3000, 2000, 1000, 3, 10};
		int n=arr.length;
		System.out.println(msswc(arr,n));
	}
	
	static int msswc(int arr[], int n){
	    if(n==0) return 0;
	    if(n==1) return arr[n-1];
	    if(n==2) return arr[n-1]+arr[n-2];
	    
	    return Math.max(msswc(arr,n-1), Math.max(arr[n-1]+msswc(arr,n-2), arr[n-1]+arr[n-2]+msswc(arr,n-3)));
	}
}
```
## Memonization
```java
import java.io.*;

class GFG {
	public static void main (String[] args) {
		int arr[]={3000, 2000, 1000, 3, 10};
		int n=arr.length;
		
		System.out.println(msswc(arr,n,new int[n+1]));
	}
	
	static int msswc(int arr[], int n, int dp[]){
	    if(n==0) return 0;
	    if(n==1) return arr[n-1];
	    if(n==2) return arr[n-1]+arr[n-2];
	    
	    if(dp[n]!=0) return dp[n];
	    return dp[n]= Math.max(msswc(arr,n-1,dp), Math.max(arr[n-1]+msswc(arr,n-2,dp), arr[n-1]+arr[n-2]+msswc(arr,n-3,dp)));
	}
}
```
