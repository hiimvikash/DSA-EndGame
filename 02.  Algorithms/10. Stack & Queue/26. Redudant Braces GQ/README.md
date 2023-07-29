# **[Redundant Braces](https://www.interviewbit.com/problems/redundant-braces/)**
## **TC = O(N)**
```java
public class Solution {
    public int braces(String s) {
        Stack<Character> st=new Stack<>();
        for(char c: s.toCharArray()){
            if(c==')'){
                if(st.peek()=='(') return 1;

                char t=st.pop();
                if(t!='+' && t!='-' && t!='*' && t!='/') // --> ((a+b) - (a-b)) ans - false
                    if(st.peek()=='(') return 1; // --> (a) ans - true
                st.push(t);
                
                while(!st.isEmpty() && st.peek()!='(') st.pop();
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        return 0;
    }
}

```
## **[Video Reference](https://youtu.be/aMPXhEdpXFA)**
