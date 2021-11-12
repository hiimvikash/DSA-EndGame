# [**1021. Remove Outermost Parentheses**](https://leetcode.com/problems/remove-outermost-parentheses/)

# Thought Process
## Traverse throught the string and for each character do following :-
- As it is a valid string so for every opening Bracket there will be a closing bracket, whenever Stack is empty means there is a opening of valid parenthesis that means this is a outermost parentheses '(' so we just add it in stack.
- Whenever stack is not empty
	- that means there is outermost parentheses in stack so we will keep on appending character untill unless we found ```ch=')' and stack size is 1``` and asSas we foud this we will just pop() without appending in ANS.
```java
class Solution {
    public String removeOuterParentheses(String s) {
        if(s=="") return s;
        Stack<Character> st=new Stack<>();
        
        StringBuilder ans=new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(st.isEmpty()) st.push(ch);
            else{
                if(ch=='('){
                    st.push(ch);
                    ans.append(ch);
                }
                else if(ch==')' && st.size()==1) st.pop();
                else if(ch==')'){
                    st.pop(); ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
```