# [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
## Intution 
- if coming train is -VE then currEle will not join them to decrease their OWN_VALUE rather than they will START THEIR OWN TRAIN
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int trainSum = 0;
        int ans = nums[0];
        
        for(int ele : nums){
            if(trainSum >= 0){
                trainSum+=ele;
            }
            else{
                trainSum = ele;
            }
            ans = Math.max(ans, trainSum);
        }
        return ans;
    }
}
```