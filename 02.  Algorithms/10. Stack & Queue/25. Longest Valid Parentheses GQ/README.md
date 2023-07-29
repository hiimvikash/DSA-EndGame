# **[32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)**
## **TC = O(N)**
```java
class Solution {
    public int longestValidParentheses(String s) {
        // see length of continuousValidParentheses lies from closingBracketIndex - problemIndex
        Stack<Character> st=new Stack<>();
        Stack<Integer> pi=new Stack<>();
        pi.push(-1);
        int len = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                // assume it as a problem index
                pi.push(i);
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    if(st.peek() == '('){
                        st.pop();
                        pi.pop();

                        len = Math.max(len, i-pi.peek());
                    }
                }else pi.push(i);
            }
        }
        return len;
    }
}
```
## **[Video Reference](https://youtu.be/qC5DGX0CPFA)**
