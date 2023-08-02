# [Chocolate Distribution Problem](https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1)
```java
class Solution
{
    public long findMinDiff (ArrayList<Integer> arr, int n, int m)
    {
        // your code here
        Collections.sort(arr); 
        // we sorted array coz we have to distribute packets among M student diff(maxCtoAStudent - minCtoAStudent) should be minimum.
        // as we want diff should be minimum, so choclate distributed among them should be close enough to give minimum diff
        int ans = Integer.MAX_VALUE;
        int s = 0;
        int e = m-1;
        
        while(e < n){
            ans = Math.min(ans, arr.get(e) - arr.get(s));
            s++;
            e++;
        }
        return ans;
    }
}
```