# **[Count Zero Sum Subarrays](https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1#)**

## Your Task:

You don't need to read input or print anything. Complete the function findSubarray() that takes the array arr and its size n as input parameters and returns the total number of sub-arrays with 0 sum.

# **My Intution :- TC - O(N) SC - O(N)**

## base of my intution :-

![subArray0](https://user-images.githubusercontent.com/71629248/123395324-b361d300-d5bd-11eb-9f19-dedc0fbc66b6.png)

```java
class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long,Integer> hm=new HashMap<>();
        long sum=0,count=0;
        hm.put(sum,1);
        for(long ele: arr){
            sum+=ele;
            if(hm.containsKey(sum)) count+=hm.get(sum);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
```

## **[Video Reference](https://youtu.be/C9-n_H7dsvU)**
