# [**Edit Distance LC-72**](https://leetcode.com/problems/edit-distance/)

```java
class Solution {
    public int minDistance(String s, String t) {
       int sl=s.length(); int tl=t.length();
        int dp[][]=new int[sl+1][tl+1];
        
        for(int i=0;i<=tl;i++) dp[0][i]=i;
        for(int i=0;i<=sl;i++) dp[i][0]=i;
        
        for(int i=1;i<=sl;i++){
            for(int j=1; j<=tl; j++){
                if(s.charAt(i-1)!=t.charAt(j-1)){
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }else dp[i][j]=dp[i-1][j-1]; // this means we r considering the previous calulation.
            }
        }
        return dp[sl][tl];
    }
}
```
# [**Video Reference**](https://youtu.be/b6AGUjqIPsA)
