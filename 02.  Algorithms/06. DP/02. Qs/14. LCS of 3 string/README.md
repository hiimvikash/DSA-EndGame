# [**LCS of 3**](https://practice.geeksforgeeks.org/problems/lcs-of-three-strings0028/1#)

```java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
        int dp[][][]=new int[n1+1][n2+1][n3+1];
        for(int t[][] : dp){
            for(int d[] : t){
                Arrays.fill(d,-1);
            }
        }
        return lcs3(A,B,C,n1,n2,n3,dp);
        
    }
    int lcs3(String s1, String s2, String s3, int n1, int n2, int n3, int dp[][][]){
        if(n1==0||n2==0||n3==0) return 0;
        if(dp[n1][n2][n3]!=-1) return dp[n1][n2][n3];
        if(s1.charAt(n1-1)==s2.charAt(n2-1) && s2.charAt(n2-1)==s3.charAt(n3-1))
            return dp[n1][n2][n3]=1+lcs3(s1,s2,s3,n1-1,n2-1,n3-1,dp);
        return dp[n1][n2][n3]=Math.max(lcs3(s1,s2,s3,n1-1,n2,n3,dp),Math.max(lcs3(s1,s2,s3,n1,n2-1,n3,dp),lcs3(s1,s2,s3,n1,n2,n3-1,dp)));    
    }
}
```

