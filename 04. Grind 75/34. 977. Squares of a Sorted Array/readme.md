# [977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        
        int res[]=new int[n];
        int i = 0, j = n-1;
        
        for(int p = n-1; p>=0; p--){
            if(Math.abs(nums[i]) >= Math.abs(nums[j])){ res[p] = nums[i]*nums[i]; i++;}
            else{ res[p] = nums[j]*nums[j]; j--; }
        }
        return res;
    }
}
```