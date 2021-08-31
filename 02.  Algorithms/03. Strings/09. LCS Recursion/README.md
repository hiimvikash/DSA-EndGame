# **[Longest-Common-Subsequence](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#)**
- **[Video Reference.](https://youtu.be/4Urd0a0BNng)**
```java
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
        return LCS(0,0,s1,s2,x,y);
    
    
    static int LCS(int i, int j, String s1, String s2, int n1, int n2){
	    if(i==n1 || j==n2) return 0;
	    if(s1.charAt(i)==s2.charAt(j))
	       return 1+LCS(i+1,j+1,s1,s2,n1,n2);
	    else
	       return Math.max(LCS(i,j+1,s1,s2,n1,n2), LCS(i+1,j,s1,s2,n1,n2));
	}    
}
```
## [**DP Memonization :-**](https://youtu.be/g_hIx4yn9zg)
**Note :** Size of 2D array depends on the changing variables in recursive calls.
```java
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int row[]:dp) {
    		Arrays.fill(row, -1);
    	}
		return LCS(n1,n2,s1,s2,dp);
    }
    static int LCS(int n1, int n2, String s1, String s2, int dp[][])
    {   // your code here
        if(n1==0||n2==0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        if(s1.charAt(n1-1)==s2.charAt(n2-1))  return dp[n1][n2] = 1+LCS(n1-1,n2-1,s1,s2,dp);
        else return dp[n1][n2] = Math.max(LCS(n1,n2-1,s1,s2,dp),LCS(n1-1,n2,s1,s2,dp));
    }
}
```
## [**DP Tabulation :-**](https://youtu.be/hR3s9rGlMTU)
```java
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
		return dp[n1][n2];
    }
}
```
