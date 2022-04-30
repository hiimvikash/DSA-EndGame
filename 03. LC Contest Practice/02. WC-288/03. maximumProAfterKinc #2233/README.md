# [**2233. Maximum Product After K Increments**](https://leetcode.com/problems/maximum-product-after-k-increments/)

## Approach : 
```
We can increment minimum number in all k operations and take their product in end.

But why it works ?

Let's take two integers x and y and (x > y)

Now if you increment x by 1 then your product will be
product = (x + 1) * y = x * y + y

And if you increment y by 1 then your product will be
product = x * (y + 1) = x * y + x

As x * y is common in both, and as x > y so (x * y + x > x * y + y)
That's why it's always optimal to increment minimum number if you want to maximize their product

So, we do this for all k operations.
```

```java
class Solution {
    public int maximumProduct(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // insert all element in PQ
        for(int e: arr) pq.add(e);
        
        // increment smallest element by 1 for k times
        while(k-->0){
            pq.add(pq.poll()+1);
        }
        
        long res=1;
        while(!pq.isEmpty()){
            res = (res*pq.poll()) % 1000000007;
        }
        
        return (int)res;
    }
}
```