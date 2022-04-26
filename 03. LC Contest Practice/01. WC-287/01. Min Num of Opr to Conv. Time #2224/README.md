## [**2224. Minimum Number of Operations to Convert Time**](https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/)
```java
class Solution {
    public int convertTime(String current, String correct) {
        int cur = Integer.parseInt(current.substring(0,2))*60 + Integer.parseInt(current.substring(3)); // to min
        int cor = Integer.parseInt(correct.substring(0,2))*60 + Integer.parseInt(correct.substring(3)); // to min   
        
        int d = cor-cur;
        return d/60 + (d%60)/15 + (d%60)%15/5 + (d%60)%15%5/1 ;
    }
}
```
