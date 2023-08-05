# [455. Assign Cookies] (https://leetcode.com/problems/assign-cookies/description/)

```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Just assign the cookies starting from the child with less greediness to maximize the number of happy children .
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gn = g.length;
        int sn = s.length;
        if(sn == 0) return 0;

        int i = 0;
        int j = 0;
        
        while(i<gn && j<sn){
            if(s[j] >= g[i]){
                i++; j++;
            }else j++;
        }
        return i;
    }
}
```