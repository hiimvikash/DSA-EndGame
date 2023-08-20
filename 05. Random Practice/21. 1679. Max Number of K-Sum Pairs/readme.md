## [1679. Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/description/)

```java
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0; 
        int j = n-1;
        int count =0;
        while(i<j){
            if((nums[i] + nums[j]) < k) i++;
            else if((nums[i] + nums[j]) > k) j--;
            else{
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}
```