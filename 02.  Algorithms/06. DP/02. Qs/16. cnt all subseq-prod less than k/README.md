# [**Count all subsequences having product less than K**](#)

## Recurssive solution :-
```java
import java.io.*;

class GFG {
	public static void main (String[] args) {
		int arr[]={4,8,7,2};
		System.out.println(cnt(arr,0,arr.length,1,50)-1);
	}
	static int cnt(int arr[], int i, int n, int prod, int k){
	    if(i==n){
	        if(prod<k) return 1;
	        return 0;
	    }
	    int l=0,r=0;
	    if(prod*arr[i] < k){
	        // pick
	        prod*=arr[i];
	        l=cnt(arr,i+1,n,prod,k);
	        // not pick
	        prod/=arr[i];
	    }
	    r=cnt(arr,i+1,n,prod,k);
	    return l+r;
	}
}
```
## DP memonization
```java
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int arr[]={4,8,7,2};
		int n=arr.length;
		int k=50;
		int dp[][]=new int[n+1][k+1];
		for(int d[] : dp) Arrays.fill(d,-1);
		
		System.out.println(cnt(arr,0,arr.length,1,k,dp)-1);
	}
	static int cnt(int arr[], int i, int n, int prod, int k, int dp[][]){
	    if(i==n){
	        if(prod<k) return 1;
	        return 0;
	    }
	    if(dp[i][prod]!=-1) return dp[i][prod];
	    int l=0,r=0;
	    if(prod*arr[i] < k){
	        // pick
	        prod*=arr[i];
	        l=cnt(arr,i+1,n,prod,k,dp);
	        // not pick
	        prod/=arr[i];
	    }
	    r=cnt(arr,i+1,n,prod,k,dp);
	    return dp[i][prod]=l+r;
	}
	
}
```
