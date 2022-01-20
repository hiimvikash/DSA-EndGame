# [**Maximize The Cut Segments**](https://practice.geeksforgeeks.org/problems/cutted-segments1642/1#)

```java
class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
      int ans= mcs(n,x,y,z,new int[n+1]);
      return ans<0 ? 0: ans;
    }
    int mcs(int n, int x, int y, int z, int dp[]){
        if(n==0) return 0;
        
        if(dp[n]!=0) return dp[n];
        
        int op1=Integer.MIN_VALUE, op2=Integer.MIN_VALUE, op3=Integer.MIN_VALUE;
        
        if(n>=x) op1=mcs(n-x,x,y,z,dp);
        if(n>=y) op2=mcs(n-y,x,y,z,dp);
        if(n>=z) op3=mcs(n-z,x,y,z,dp);
        
        return dp[n]=1+Math.max(op1, Math.max(op2,op3));
    }
}
```
## Tabulation
```java
class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       int dp[]=new int[n+1];
       dp[0]=0;
       
       for(int i=1;i<=n;i++){
           int op1=Integer.MIN_VALUE, op2=Integer.MIN_VALUE, op3=Integer.MIN_VALUE;
           
            if(i>=x) op1=dp[i-x];
            if(i>=y) op2=dp[i-y];
            if(i>=z) op3=dp[i-z];
            
            dp[i]=1+Math.max(op1, Math.max(op2,op3));
       }
       return dp[n]<0? 0 : dp[n];
    }
}
```
## [**Video reference**](https://youtu.be/O0N4xn38Ncg)