## [2824. Count Pairs Whose Sum is Less than Target](https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/)

```java
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        if(n == 1) return 0;

        Collections.sort(nums);
        int i = 0;
        int j = n-1;

        int count = 0;
        while(i<j){
            if(nums.get(i) + nums.get(j) < target){
                 count+= j-i;
                 i++;
            }
            else{
                j--;
            }
        }
        return count;
    }
}
```