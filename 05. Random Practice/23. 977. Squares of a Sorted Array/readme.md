## [977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/description/)

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // The Approach :
        // as u can see in both end u will get the maximumNo. after squaring
        // so we will start filling up the res array from back

        int res[] = new int[n];
        int i = 0;
        int j = n-1;
        for(int idx = n-1; idx >= 0; idx--){
            // now for fillingAnswer in idx I have 2 options(arr[i] or arr[j]), I will prefer which ever is maximum
            if(Math.abs(nums[i]) >= Math.abs(nums[j])){
                res[idx] = nums[i] * nums[i];
                i++;
            }else{
                res[idx] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }
}
```