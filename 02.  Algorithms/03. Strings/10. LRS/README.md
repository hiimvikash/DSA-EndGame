#  [**Longest Repeating Subsequence (LCS with different index)**](https://youtu.be/hbTaCmQGqLg)
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1)
## Intution :-
- We make a copy of same string and return **LCS(s,s) with different Index** because if same subsequence will be present then it will obviously occur in different index.
```java
class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        return lcs(str.length(),str.length(),str,str);
    }
    static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
		return dp[n1][n2];
    }
}
```