# [844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)
```java
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    String build(String s){
        Stack<Character> ans=new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c!='#') ans.push(c);
            else if(!ans.isEmpty()) ans.pop();
        }
        
        return ans.toString();
    }
}
```