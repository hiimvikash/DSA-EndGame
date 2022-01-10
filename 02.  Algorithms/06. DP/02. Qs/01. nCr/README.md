# [**nCr**](https://practice.geeksforgeeks.org/problems/ncr1019/1#)
[**Video reference**](https://youtu.be/jIb1W3ObIho)
```java
class Solution{
    static int nCr(int n, int r)
    {
        // code here
        if(r>n) return 0;
        if(n-r<r) r=n-r;
        int mod =1000000007;
        int dp[]=new int[r+1];
        dp[0]=1;
        
        for(int i=1; i<=n; i++){
            for(int j=Math.min(i,r); j>0; j--){
                dp[j]=(dp[j]+dp[j-1])%mod;
            }
        }
        return dp[r];
    }
}
```