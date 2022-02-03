# [**Count Palindromic Subsequences **](https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1#)

![](https://media.geeksforgeeks.org/wp-content/uploads/20190804162927/00011.jpg)


## Using memonization
 ```java
class Solution
{
    
    long countPS(String str)
    {
        
        int n=str.length();
        // Your code here
        long dp[][]=new long[n][n];
        for(long d[]: dp) Arrays.fill(d,-1);
        
        return c(str,0,str.length()-1,dp);
    }
    long c(String s, int i, int j, long dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==j) return dp[i][j]=1;
        
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]= c(s,i+1,j,dp)+c(s,i,j-1,dp)+1;
        }
        else return dp[i][j]= c(s,i+1,j,dp)+c(s,i,j-1,dp)-c(s,i+1,j-1,dp);
    }
}
```
