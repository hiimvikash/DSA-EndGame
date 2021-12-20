**<h1 align="center">DP - Coding Blocks</h1>**
# 1. Fibonnaci Number
```java
// Top Down Approach:-
	static int fibn(int n, int dp[]){
	    if(n==0 || n==1) return n;
	    if(dp[n]!=0) return dp[n];
	    
	    return dp[n]=fibn(n-1,dp)+fibn(n-2,dp);
	}
	// BU Approach :-
	static int fibn(int n){
	    int dp[]=new int[n+1];
	    dp[0]=0;
	    dp[1]=1;
	    
	    for(int i=2;i<=n;i++){
	        dp[i]=dp[i-1]+dp[i-2];
	    }
	    return dp[n];
	}
	// Bottom Up Approach Space Optimized :-
	static int fibn(int n){
	    if(n==0 || n==1) return n;
	    int a=0;
	    int b=1;
	    int c=0;
	    for(int i=2;i<=n;i++){
	        c=a+b;
	        a=b;
	        b=c;
	    }
	    return c;
	}
```
