# **[Largest subarray with 0 sum](https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)**

## Your Task:

You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

# **My Intution :- TC - O(N) SC - O(N)**

## base of my intution :-

![subArray0](https://user-images.githubusercontent.com/71629248/123395324-b361d300-d5bd-11eb-9f19-dedc0fbc66b6.png)

```java
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int sum=0,maxL=0;
        HashMap<Integer,Integer> si = new HashMap<>(); // <sum,index>
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0) maxL=i+1;
            else{
               if(si.containsKey(sum))
                    maxL=Math.max(maxL,i-si.get(sum));
               else
                    si.put(sum,i);
            }
        }
        return maxL;
    }
}
```

## **[Video Reference](https://youtu.be/xmguZ6GbatA)**
