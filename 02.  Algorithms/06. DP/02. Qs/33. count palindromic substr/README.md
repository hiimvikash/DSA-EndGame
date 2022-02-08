# [**count Palindromic Substring**](https://leetcode.com/problems/palindromic-substrings/)


## Using memonization
 ```java
class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int ans=0;
        for(int g=0; g<n; g++){
            for(int i=0,j=g; i<n-g; i++,j++){
                if(g==0) dp[i][j]=true;
                else if(g==1) dp[i][j]=s.charAt(i)==s.charAt(j)?true:false;
                else{ 
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) dp[i][j]=true;
                }
                if(dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
```
[**Video reference**](https://youtu.be/XmSOWnL6T_I)