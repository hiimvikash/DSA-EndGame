# [2873. Maximum Value of an Ordered Triplet I](https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/)

## Intuition :- 
- See you goal is to maximize ```(nums[i]-nums[j]) * nums[k]``` ```i < j < k``` which means nums[i] should appear before nums[j] and nums[j] before nums[k].
- Treat eachEle as nums[j] and assume you got leftMax & rightMax for each nums[j] then u can easily calculate your max answer.

## Approach :-
- Now to maximise ```nums[i] - nums[j]``` nums[i] should be AMAP(asMaxAsPossible) from nums[j] so
    - Let's Create leftMax[] for each ele which will give ```nums[i] in expression``` for every ele, ```leftMax[i]``` will give maximumElement from left of nums[i]...**which means leftMax[i] should be greater than equal to nums[i].**
- Now create ```rightMax[]``` which will give ```nums[k]``` for every ele.

## TC - O(N) & SC - O(N)
```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int maxLeft[] = new int[n];
        int maxRight[]= new int[n];

        //left : maxLeft[i] is maxLeft wrt nums[i]
        int max = -1;
        for(int i = 0; i<n; i++){
            if(max >= nums[i]) maxLeft[i] = max;
            else maxLeft[i] = -1;
            
            max = Math.max(max, nums[i]);
        }
        // right : maxRight[i] is just maximumEle in RightSide of nums[i]
        // [1, 10, 3, 2, 1] -> 14
        max = -1;
        for(int i = n-1; i>=0; i--){
            maxRight[i] = max;
            max = Math.max(max, nums[i]);
        }


        long ans = Long.MIN_VALUE;
        for(int i = 1; i<n-1; i++){
            if(maxLeft[i] != -1){
                ans = Math.max(ans, (maxLeft[i]-nums[i])*(long)maxRight[i]);
            }
        }
        
        return ans <= 0? 0 : ans;

    }
}
```
## TC - O(N) SC - O(1)
## Intuition
- While itterating
    - assume each ele as nums[k] and find answer
        - Now to find answer u must have maximumDifference till now
        - to find maximumDifference till now u must have maxEleinLeft
```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        int maxl = 0; int md = 0; long res = 0;
        for(int ele : nums){
            res = Math.max(res, (long)md*ele);
            md = Math.max(md, maxl - ele);
            maxl = Math.max(maxl, ele);
        }
        return res;
    }
}
```