# [**Interleaved Strings**](https://practice.geeksforgeeks.org/problems/interleaved-strings/1#)


## [**Video Reference**](https://youtu.be/jaQF6FSWYdE)


```java
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
            //Your code here
            int n=a.length();
            int m=b.length();
            int len=c.length();
            
            int dp[][]=new int[n+1][m+1];
            for(int d[]:dp) Arrays.fill(d,-1);
            return solve(a,b,c,n,m,len,dp)==1? true : false;
	}
	int solve(String a, String b, String c, int n, int m, int len, int dp[][]){
	    if(len==0) return 1;
	    
	    int i=0,j=0;
	    if(dp[n][m]!=-1) return dp[n][m];
	    
	    if(n-1>=0 && a.charAt(n-1)==c.charAt(len-1)) i=solve(a,b,c,n-1,m,len-1,dp);
	    if(m-1>=0 && b.charAt(m-1)==c.charAt(len-1)) j=solve(a,b,c,n,m-1,len-1,dp);
	    if(i==1||j==1) return dp[n][m]=1;
	    return dp[n][m]=0;
	}
	
}
```