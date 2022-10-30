# [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)

```java
class Solution {
    public int maxProduct(int[] nums) {
        int minSoFar = nums[0], maxSoFar = nums[0], maxP = nums[0];
        int n = nums.length;
        
        for(int i=1; i<n; i++){
            if(nums[i] == 0){
                minSoFar = maxSoFar = 1; maxP = Math.max(0,maxP); continue;
            }
            // if comingElement is -VE than max will become moreMINIMUM when multiplied.
            // and min will become moreMAXIMUM WHEN multiplied.
            // so by swaping we are preparing minSoFar and maxSoFar to store their respective value for which they are born.
            if(nums[i] < 0){
                int t = minSoFar;
                minSoFar = maxSoFar;
                maxSoFar = t;
            }
            
            minSoFar = Math.min(nums[i], nums[i]*minSoFar);
            maxSoFar = Math.max(nums[i], nums[i]*maxSoFar);
            
            
            maxP = Math.max(maxP, maxSoFar);
            
        }
        return maxP;
    }
}

/**
here minSfar or maxSfar signifies the previous running train such that coming element could add themselves in it, if beneficial orelse start their own train.

TC : 2,3,-2,4
**/
```
[video reference](https://youtu.be/lXVy6YWFcRM)