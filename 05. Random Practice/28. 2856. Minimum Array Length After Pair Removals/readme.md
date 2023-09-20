# [2856. Minimum Array Length After Pair Removals](https://leetcode.com/problems/minimum-array-length-after-pair-removals/description/)
![Alt text](image.png)
```java
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int i=0,j=n/2;
        if(n%2 != 0) j++;

        int rc = 0; // remove count
        while(j<n){
            if(!nums.get(i).equals(nums.get(j))) rc+=2;
            i++; j++;
        }
        return n-rc;
    }
}
```