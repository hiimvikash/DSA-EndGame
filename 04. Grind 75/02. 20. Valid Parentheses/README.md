# [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch=='(' || ch=='[' || ch=='{' || st.isEmpty()) st.push(ch);
            else if( (st.peek()=='(' && ch==')') || (st.peek()=='[' && ch==']') || (st.peek()=='{' && ch=='}') ) st.pop(); 
            else st.push(ch);
            
        }
        return st.isEmpty();
    }
}
```