# [55. Jump Game](https://leetcode.com/problems/jump-game/)

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = nums[0];
        for(int i = 0; i<=maxJump; i++){
            maxJump = Math.max(maxJump, nums[i]+i);
            if(maxJump >= n-1) return true;
        }
        return false;
    }
}
```