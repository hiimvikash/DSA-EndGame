# 1. [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
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

# 2. [Frog Jump](https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?leftPanelTab=0)
![image](https://user-images.githubusercontent.com/71629248/187431703-fee3f63e-2905-43fe-b622-9bcf8317369e.png)
![image](https://user-images.githubusercontent.com/71629248/187431763-254e2b92-2fe4-4a5f-b640-6d41f1c6b50d.png)


## Memonization

```java
import java.util.*;
public class Solution {
    public static int frogJump(int n, int h[]) {
            int dp[]=new int[n+1];
            Arrays.fill(dp,-1);
            
        return fj(n,h,dp);
    }
    public static int fj(int n, int h[], int dp[]){
        if(n<=2) return Math.abs(h[0]-h[n-1]);
        
        if(dp[n]!=-1) return dp[n];
        
        int jump1 = fj(n-1,h,dp)+Math.abs(h[n-1]-h[n-2]);
        int jump2 = fj(n-2,h,dp)+Math.abs(h[n-1]-h[n-3]);
        
        return dp[n] = Math.min(jump1,jump2);
    }

}
```

## Tabulation

```java
public class Solution {
    public static int frogJump(int n, int h[]) {

        // Write your code here..
        int dp[]=new int[n+1];
        dp[0]=dp[1]=0;
        dp[2] = Math.abs(h[1]-h[0]);
        for(int i=3; i<=n; i++){
            dp[i] = Math.min((dp[i-1]+Math.abs(h[i-1]-h[i-2])), (dp[i-2]+Math.abs(h[i-1]-h[i-3])));
        }
        return dp[n];
    }

}
```

## Space Optimized
```java
public class Solution {
    public static int frogJump(int n, int h[]) {

        // Write your code here..
        if(n<=2) return Math.abs(h[0]-h[n-1]);
        
        int prev = Math.abs(h[0]-h[1]);
        int prev2 = 0;
        int c=0;
        for(int i=3; i<=n; i++){
            c = Math.min((prev + Math.abs(h[i-1]-h[i-2])), (prev2+Math.abs(h[i-1]-h[i-3])));
            prev2=prev;
            prev=c;
        }
        return c;
    }

}
```
[Reference](https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/)
