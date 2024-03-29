# Pattern : - remove2andCombine
## In this Pattern we have to remove two element from Array(based on Q) and combine them into 1(condition given in Q).

# [1046. Last Stone Weight](https://leetcode.com/problems/last-stone-weight/description/)
- Here we generally use PQ to achieve such operation
```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        // step 1 : create PQ and insert all weights
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int w : stones){
            pq.add(w);
        }

        while(pq.size() > 1){
            int xw = pq.remove();
            int yw = pq.remove();

            if(xw != yw){
                xw = xw - yw;
                pq.add(xw);
            }
        }

        return pq.size() == 0 ? 0 : pq.remove();
    }
}
```