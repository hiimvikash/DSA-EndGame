# [91. Decode Ways](https://leetcode.com/problems/decode-ways/)

```java
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        int dp[]=new int[n+1]; // dp[i] signifies no.OfWays possible of ith length
        dp[0] = dp[1] = 1;
        
        for(int i = 1; i<n; i++){
            int cnum = s.charAt(i) - '0'; // current num
            int pnum = s.charAt(i-1) - '0'; // prev num
            
            int nn = pnum*10 + cnum;
            
            
            
             // Milke 
            if(cnum == 0){
                if(pnum == 0 || pnum > 2) return 0;
                dp[i+1] = dp[i-1];
            }
            // naiMilke
            else if(pnum == 0 || nn > 26){
                dp[i+1] = dp[i];
            } 
            // milke + naiMilke
            else{
                dp[i+1] = dp[i] + dp[i-1];
            }
            
        }
        return dp[n];
    }
}
```
