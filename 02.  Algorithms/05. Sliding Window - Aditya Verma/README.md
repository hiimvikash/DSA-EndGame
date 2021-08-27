**<h1 align="center">Sliding Window - Aditya Verma</h1>**


# **[1. Sliding Windows Need .](https://youtu.be/EHCGAZBbB88)**
[**GFG Article**](https://www.geeksforgeeks.org/window-sliding-technique/)
![sw1](https://user-images.githubusercontent.com/71629248/131081293-996a541a-c339-4545-b2f2-101187e3f9e1.png)
# **[2. Max Sum Subarray of size K .](https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)**
```java
class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        // code here
        int sum=0;
        int s=0,e=k-1;
        for(int i=s;i<=e;i++)
            sum+=arr.get(i);
        int max=sum;
        s++;
        e++;
        while(e<n){
            sum=sum-arr.get(s-1)+arr.get(e);
            max=Math.max(sum,max);
            s++;
            e++;
        }
        return max;
    }
}
```