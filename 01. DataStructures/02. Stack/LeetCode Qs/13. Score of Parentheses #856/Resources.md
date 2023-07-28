### **Problem Link:**

- #### [Score of Parentheses #856](https://leetcode.com/problems/score-of-parentheses/)

### **Solution Link:**

- #### [Score of Parentheses #856 solution](./Solution.java)
```java
class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Integer> st=new Stack<>(); // this stack will score previous score whenever opening bracket is encountered

        for(char c : s.toCharArray()){
            if(c == '('){
                // store the previous score
                st.push(score);
                // initialize score to 0
                score = 0;
            }
            else{
                // whenever u get ) then score till that ) can be :
                score  = st.pop() + Math.max(score*2, 1);
                // st.pop() is previous score
                // Math.max....
                // this signifies whatif there is a score from inside
            }
        }
        return score;
    }
}
```

### **Tutorial Link:** [Score of Parentheses by Nick White](https://youtu.be/jfmJusJ0qKM)
