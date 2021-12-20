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
# [2. Min Steps to 1](https://practice.geeksforgeeks.org/problems/minimum-steps-to-minimize-n-as-per-given-condition0618/1#)
 ## Top Down
```java
class Solution{


	public int minSteps(int n) 
	{ 
	    int dp[]=new int[n+1];
	    Arrays.fill(dp,-1);
	    return minStep(n,dp);
	}
	private int minStep(int n,int dp[]){
	    // Your code goes here
	    if(n==1||n==2) return n-1;
	    
	    int ans1=Integer.MAX_VALUE,ans2=Integer.MAX_VALUE,ans3=Integer.MAX_VALUE;
	    if(dp[n]!=-1) return dp[n];
	    if(n%3==0){
	        ans1=minStep(n/3,dp);
	    }
	    if(n%2==0){
	        ans2=minStep(n/2,dp);
	    }
	    ans3=minStep(n-1,dp);
	    return dp[n]=Math.min(ans1,Math.min(ans2,ans3))+1;
	}
}
```
## Bottom Up
```java
class Solution{

	public int minSteps(int n) 
	{ 
	    // Your code goes here
	    int dp[]=new int[n+1];
	    dp[1]=0;
	    for(int i=2; i<=n; i++){
	        int min=Integer.MAX_VALUE;
	        if(i%2==0){
	            min=Math.min(dp[i/2],min);
	        }
	        if(i%3==0){
	            min=Math.min(dp[i/3],min);
	        }
	        min=Math.min(dp[i-1],min);
	        
	        dp[i]=min+1;
	   }
	   return dp[n];
	} 
}
```
