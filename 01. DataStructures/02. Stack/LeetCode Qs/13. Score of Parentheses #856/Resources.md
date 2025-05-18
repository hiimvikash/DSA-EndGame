### **Problem Link:**

- #### [Score of Parentheses #856](https://leetcode.com/problems/score-of-parentheses/)

### **Solution Link:**

- #### [Score of Parentheses #856 solution](./Solution.java)
```java
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        int score = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(score); // this is the previous score till '(' which we are storing and reseting the ongoing-score
                score = 0;
            }
            else {
                if(score == 0){ // if ongoing-score = 0 and I encounter a closing bracket THAT means 
                    score = st.pop() + 1; 
                }else {
                    score = st.pop() + 2 * score;
                }
            }
        }
        return score;
    }
}
```

### **Tutorial Link:** [Score of Parentheses by Nick White](https://youtu.be/jfmJusJ0qKM)
