# [Minimum Cost of ropes](https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1)

```java
class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(long ele : arr) pq.add(ele);
        
        long ans = 0;
        while(pq.size() > 1){
            long ele1 = pq.remove();
            long ele2 = pq.remove();
            ans+=ele1 + ele2;
            
            pq.add(ele1+ele2);
        }
        return ans;
    }
}
```