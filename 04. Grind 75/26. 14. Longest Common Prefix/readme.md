# [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
## Intution
- set String pre = strs[0]
- now keep on decrease the length of prefix for every strs[i] untill that prefix is found at index 0
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        
        for(String s : strs){
            while(s.indexOf(pre)!=0) pre = pre.substring(0, pre.length()-1);
        }
        return pre;
    }
}
```
## Sort and compare last two string
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        
        String f = strs[0], l = strs[strs.length - 1];
        int i = 0;
        while(i < f.length()){
            if(f.charAt(i) == l.charAt(i)) i++;
            else break;
        }
        return f.substring(0,i);
    }
}
```