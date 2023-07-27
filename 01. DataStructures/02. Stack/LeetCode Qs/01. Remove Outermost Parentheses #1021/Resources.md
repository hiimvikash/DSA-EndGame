#### **Problem Link:** [Remove Outermost Parentheses #1021](https://leetcode.com/problems/remove-outermost-parentheses/)

#### **Solution Link:** [Remove Outermost Parentheses #1021 solution](./Solution.java)

## Intution
# solve for this  : (()(())) --> ()(())
- we are not accepting only 1st ( in our ans
- rest whenever we get ( we add in ans as well as stack
- we are not accepting only last ) in our ans
- rest whenever we get ) we pop() and we add in ans
```java
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c : s.toCharArray()){
            // when stack is empty
            if(st.isEmpty()) st.push(c);
            else{
                if(c == '('){
                    sb.append(c);
                    st.push(c);
                }
                else{
                    if(st.size() == 1) st.pop();
                    else if(st.size() > 1){
                        st.pop();
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
```
