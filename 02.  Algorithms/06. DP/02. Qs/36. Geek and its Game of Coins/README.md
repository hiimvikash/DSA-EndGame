# [**Geek and its Game of Coins**](https://practice.geeksforgeeks.org/problems/geek-and-its-game-of-coins4043/1/#)


## [**Video Reference**](https://youtu.be/uXqoNkv_Iv0)

```java
class Solution
{
    public int findWinner(int n,int x,int y)
    {
        // Code here
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2; i<=n; i++){
            if(i-1>=0 && dp[i-1]==0) dp[i]=1;
            else if(i-x>=0 && dp[i-x]==0) dp[i]=1;
            else if(i-y>=0 && dp[i-y]==0) dp[i]=1;
            else dp[i]=0;
        }
        return dp[n];
    }
}
```