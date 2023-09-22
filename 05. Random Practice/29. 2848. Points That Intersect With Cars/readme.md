# [2848. Points That Intersect With Cars](https://leetcode.com/problems/points-that-intersect-with-cars/description/)

## Q : In a number line from point 1 to 100, you will be given ranges where cars are placed, you need to count no.OfPoints where the points are covered with any part of car.

## Thought Process
![Alt text](image.png)

```java
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int n = nums.size();

        int points[]=new int[101];

        for(int i = 0; i<n; i++){
            int s = nums.get(i).get(0);
            int e = nums.get(i).get(1);

            points[s]+=1;
            if(e+1 < 101) points[e+1]-=1;
        }
        int c = 0;
        for(int i = 1; i<101; i++){
            points[i] = points[i]+points[i-1];
            if(points[i] > 0) c++;
        }
        return c;
    }
}
```