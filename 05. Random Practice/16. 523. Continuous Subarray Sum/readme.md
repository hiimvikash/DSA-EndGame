## [523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/)

## The Thought Process
- ### Digest this FACT
    - IF ```num1 % k = num1mod ``` & ```num2 % k = num2mod``` & ```num1mod == num2mod``` then ```(num2 - num1) % k = 0```
        - Example : k = 6, num1 = 14, num2 = 38
        - Here ```num1mod = num2mod = 2``` so ```num2 - num1 = 38 - 14 = 24``` and ```24 % 6 = 0```
## The Approach
- ### Now if we r able to find two SubArray whose PrefixSum mod are same then there difference will be divisible by k.
![image](https://github.com/hiimvikash/DSA-EndGame/assets/71629248/396da9b1-7fd5-4aa7-9fad-5628845dff14)


```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // runningSumMod -- index
        HashMap<Integer, Integer> hm=new HashMap<>();
    // corner case: if the very first subarray with first two numbers in array could form the result, we need to 
    // put mod value 0 and index -1 to make it as a true case
        hm.put(0, -1);

        int runningSum = 0;
        int runningMod = 0;
        for(int i = 0; i<n; i++){
            runningSum+=nums[i];
            runningMod = runningSum % k;

            if(hm.containsKey(runningMod)){
                if(i - hm.get(runningMod) > 1) return true;
            }
            else hm.put(runningMod, i);
        }

        return false;
    }
}
```
