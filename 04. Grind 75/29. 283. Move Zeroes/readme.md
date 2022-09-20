# [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int snowBallSize = 0;
        
        for(int i = 0; i<n; i++){
            if(nums[i]==0) snowBallSize++;
            else if(snowBallSize > 0){
                int t = nums[i];
                nums[i] = 0;
                nums[i-snowBallSize] = t;
            }
        }
    }
}
```