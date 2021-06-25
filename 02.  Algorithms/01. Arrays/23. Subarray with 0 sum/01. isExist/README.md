# **[Subarray with 0 sum](https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1)**

## Your Task

You only need to complete the function subArrayExists() that takes array and n as parameters and returns true or false depending upon whether there is a subarray present with 0-sum or not.

# **My Intution :- TC - O(N) SC - O(N)**

## base of my intution :-

![subArray0](https://user-images.githubusercontent.com/71629248/123395324-b361d300-d5bd-11eb-9f19-dedc0fbc66b6.png)

### We use hashing. The idea is to iterate through the array and for every element arr[i], calculate the sum of elements from 0 to i (this can simply be done as sum += arr[i]). If the current sum has been seen before, then there is a zero-sum array. Hashing is used to store the sum values so that we can quickly store sum in each step and find out whether the current sum is seen before or not.

```java
class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
        HashMap<Integer,Integer> prefixSum=new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0 || prefixSum.containsKey(sum)) return true;
            else prefixSum.put(sum,i);
        }
        return false;
    }
}
```
