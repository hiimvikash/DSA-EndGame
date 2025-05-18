# **[Largest subarray with 0 sum](https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)**

## Your Task:

You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

# **My Intution :- TC - O(N) SC - O(N)**

## base of my intution :-

![subArray0](https://user-images.githubusercontent.com/71629248/123395324-b361d300-d5bd-11eb-9f19-dedc0fbc66b6.png)

```java
class Solution {
    int maxLen(int arr[]) {
        // code here
        HashMap<Integer, Integer> hm=new HashMap<>();
        int n = arr.length;
        int sum =0;
        hm.put(0,-1);
        int ans = 0;
        for(int i = 0; i<n; i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                ans = Math.max(ans, i-hm.get(sum));
            }
            else hm.put(sum,i);
        }
        return ans;
    }
}
```

## **[Video Reference](https://youtu.be/xmguZ6GbatA)**
