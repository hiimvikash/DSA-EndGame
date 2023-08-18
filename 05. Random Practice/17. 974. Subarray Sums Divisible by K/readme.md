# [974. Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/)


### Same concept as [previous Q](../16.%20523.%20Continuous%20Subarray%20Sum/readme.md)
```java
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int runningSum = 0,runningMod = 0, count = 0; 
        // prefixSumMod -- freqOfOccurence
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(0, 1);
        for(int i = 0; i<n; i++){
            runningSum+= nums[i];
            runningMod = runningSum % k;

            if(runningMod < 0) runningMod+=k; // Because -1 % 5 = -1, but we need the positive mod 4 failed TCs : [-1, 2, 9] k = 2 & [2, -2, 2, 4] k = 6
            // System.out.println(runningSum+"-->"+runningMod);
            if(hm.containsKey(runningMod)){
                count += hm.get(runningMod);
            }
            hm.put(runningMod, hm.getOrDefault(runningMod, 0)+1);
        }

        return count;
    }
}
```