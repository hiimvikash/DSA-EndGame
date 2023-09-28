# [2864. Maximum Odd Binary Number](https://leetcode.com/problems/maximum-odd-binary-number/description/)

```java
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int z = 0;
        int o = 0;
        for(char c: s.toCharArray()){
            if(c == '0') z++;
            else o++;
        }

        StringBuilder ans=new StringBuilder();
        while(o--!=1) ans.append('1');
        while(z--!=0) ans.append('0');
        ans.append('1');
        
        return ans.toString();
    }
}
```