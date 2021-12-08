# **[32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)**
## **TC = O(N)**
```java
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> cs=new Stack<>();
        Stack<Integer> is=new Stack<>();
        is.push(-1);
        int len=0;
        int n=s.length();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch=='('){
                cs.push('(');
                is.push(i);
            }
            else if(ch==')' && !cs.isEmpty()){
                cs.pop();
                is.pop();
                len=Math.max(len,i-is.peek());
            }
            else{
                is.push(i);
            }
        }
        return len;
    }
}
```
## **[Video Reference](https://youtu.be/qC5DGX0CPFA)**