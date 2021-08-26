# Given an Array A and an Integer M. Your task is to find M elements from an A[] and store it in a new Array say B such that this functions F=Max(B)-Min(B) return minimum Value.
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/minimum-difference-among-k5805/1#)
**Hint: Think of Sliding window technique**
```java
class Solution
{
    long minDiff(long a[] ,int n,int k)
    {
        Arrays.sort(a);
        long ans=Long.MAX_VALUE;
        for(int i=0;i<=n-k;i++)
            ans=Math.min(a[i+k-1]-a[i],ans);
        return ans;
    }
}
```