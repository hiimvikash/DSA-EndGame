# [735. Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)

```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int comingAst : asteroids){
            if(comingAst < 0){
                while(!st.isEmpty() && st.peek() > 0 && -comingAst > st.peek()) st.pop();
                if(st.isEmpty() || st.peek() < 0) st.push(comingAst);
                else if(comingAst + st.peek() == 0) st.pop();
            }else st.push(comingAst);
        }
        
        int[] res = new int[st.size()];   
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
    }
}

/**
-, -, +, + {NP till here}
-, -, +, +, - {problem here, 1 -ve can either destroy many +ve or can be itself destroied}

-ve k upar +ve reh skta h NO_ISSUE
vice versa issue
**/
```