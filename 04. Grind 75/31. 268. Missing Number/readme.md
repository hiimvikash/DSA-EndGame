# [268. Missing Number](https://leetcode.com/problems/missing-number/)
## Intution
- missingElement = Sum of N natural Number - arr[i]
```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int s = (n*(n+1))/2;
        
        for(int ele : nums){
            s-=ele;
        }
        return s;
    }
}
```