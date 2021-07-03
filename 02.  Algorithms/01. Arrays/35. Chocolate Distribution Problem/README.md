# **[Chocolate Distribution Problem](https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#)**
## When you will read the Qs and see the TCs then you'll realise actual Q is **Make a subsequence of size M such that MAX-MIN in that subsequence is MINIMUM than all the possible subsequence**

## My Intution : - Extra Space TC - O(N Log N) SC - O(1)
## Why we sorted ?
Here we sorted because:- 
- we have to find MINIMUM DIFF btw MAX & MIN, this is only possible when MAX and MIN will lie close to each other in Number Line so elements btw MIN & MAX will also be a part of subsequence.
- So basically when we get subsequence they are sorted, so last - first give us the check of our ANS.

```java
class Solution
{
    public long findMinDiff (ArrayList<Long> arr, long n, long m)
    {
        // your code here
        Collections.sort(arr);
        int i=0,j=(int)m-1;
        long ans=arr.get(j)-arr.get(i);
        while(i<j && j < arr.size()-1){
            i++;
            j++;
            ans=Math.min(ans,arr.get(j)-arr.get(i));
        }
        return ans;
    }
}
```

