#### **Problem Link:** [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

#### **Solution**
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        
         for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') st.push(c); 
            else if(!st.isEmpty() && ((c==')'&& st.peek()=='(') || (c=='}'&& st.peek()=='{') || (c==']'&& st.peek()=='[')) ) st.pop();
            else return false;
        }
        return st.isEmpty();
    }
}
```