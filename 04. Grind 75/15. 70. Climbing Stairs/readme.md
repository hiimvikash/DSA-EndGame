# [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
![image](https://user-images.githubusercontent.com/71629248/187269865-cf0ddb0a-79c9-4b40-914d-159e4bb30fbf.png)

## Memonization

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

## Tabulation
```java
class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
```

## Space Optimized
Here f(4) will say ```"My number of distinct way is distinctWay(3)+distinctWay(2)"```

```java
class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;

        int prev2=1,prev=1,c=0;
        for(int i=2; i<=n; i++){
            c=prev+prev2;
            prev2=prev;
            prev=c;
        }
        return c;
    }
}
```
[Reference](https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/)