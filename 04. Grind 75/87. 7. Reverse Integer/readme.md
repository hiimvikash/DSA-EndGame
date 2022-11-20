# [7. Reverse Integer](https://leetcode.com/problems/reverse-integer/)

```java
class Solution {
    public int reverse(int x) {
        
        int rev = 0;
        int nr = 0;
        while(x!=0){
            int d = x%10;
            rev = rev*10+d;
            
            if((rev-d)/10 != nr) return 0;
            nr = rev;
            
            x/=10;
        }
        return rev;
    }
}
```