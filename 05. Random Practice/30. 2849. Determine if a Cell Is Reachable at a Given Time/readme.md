# [2849. Determine if a Cell Is Reachable at a Given Time](https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/description/)

![Alt text](save.png)
```java
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int diffx = Math.abs(sx-fx);
        int diffy = Math.abs(sy-fy);

        if(diffx == 0 && diffy == 0 && t == 1) return false;
        return Math.min(diffx, diffy) + Math.abs(diffx-diffy) <= t;
    }
}
```

[**video reference**](https://youtu.be/2DNQHCls0Kw?si=11WK9YjGbZg7xJzP)