# 1. [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
```java
class Solution {
    
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        
        return cs(n,dp);
        
    }
    public int cs(int n, int dp[]){
        if(n<=3) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=cs(n-1,dp)+cs(n-2,dp);
    }
}
```
[Reference](https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/)