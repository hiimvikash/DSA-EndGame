# [**2239. Find Closest Number to Zero**](https://leetcode.com/problems/find-closest-number-to-zero/)



## My Approach : 
```java
class Solution {
    public int findClosestNumber(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int dis = Integer.MAX_VALUE;
        for(int e : nums){
            dis = Math.abs(e);
            if(dis<Math.abs(ans))
                ans=e;
            else if(dis==Math.abs(ans) && e>ans) ans=e;
        }
        return ans;
    }
}
```
## concise 
```java
class Solution {
    public int findClosestNumber(int[] nums) {
        int ans=nums[0];
       for(int e : nums){
            int dis = Math.abs(e);
            if(dis<Math.abs(ans) || (dis==Math.abs(ans) && e>ans))
                ans=e;
        }
        return ans;
    }
}
```