# [**646. Maximum Length of Pair Chain**](https://leetcode.com/problems/maximum-length-of-pair-chain/)


## [**Video Reference**](https://youtu.be/wy5ngBKOiiM)
### Hint : Think of LIS.

```java
class Solution {
    public int findLongestChain(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        
        int dp[]=new int[n];
        dp[0]=1;
        
        for(int i=1; i<n; i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(arr[j][1]<arr[i][0]) max=Math.max(dp[j],max);
            }
            dp[i]=max+1;
        }
        return dp[n-1];
        
    }
}
```