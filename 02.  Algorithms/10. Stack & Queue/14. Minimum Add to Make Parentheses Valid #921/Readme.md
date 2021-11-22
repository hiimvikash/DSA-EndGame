# [**921. Minimum Add to Make Parentheses Valid**](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)

```java
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        
        // invalid Parentheses are made either by extra '(' or ')'
        for(char c: s.toCharArray()){
            if(c=='(') st.push(c);
            else if(!st.isEmpty() && st.peek()=='(' && c==')' ) st.pop();
            else st.push(c); // ( ( ) ) ) ) (
        }
        return st.size();
    }
}
```
