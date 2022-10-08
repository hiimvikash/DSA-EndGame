# [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
```java
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int maxA = 0 ;
        while(l<r){
            maxA = Math.max(maxA, (Math.min(height[l],height[r]) * (r-l)));
            if(height[l]<height[r]) l++;
            else r--;
        }
        return maxA;
    }
}
```