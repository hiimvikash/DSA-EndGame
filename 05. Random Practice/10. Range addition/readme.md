# [903 · Range Addition](https://www.lintcode.com/problem/903/)

```java
public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here

        int relH[]=new int[length];
        int k = updates.length;
        for(int i = 0; i<k; i++){
            int lr = updates[i][0];
            int rr = updates[i][1];
            int inc = updates[i][2];

            relH[lr]+=inc;
            if(rr+1 < length) relH[rr+1]-=inc;
        }
        for(int i = 1; i<length; i++){
            relH[i] = relH[i] + relH[i-1];
        }

        return relH;
    }
}
```

#### [Concept video reference](https://youtu.be/R-PBfqsRGP0)