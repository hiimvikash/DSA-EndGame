# [**739. Daily Temperatures**](https://leetcode.com/problems/daily-temperatures/)

```java
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st=new Stack<>();
        int n=temp.length;
        int ans[]=new int[n];
        
        for(int i=0; i<n; i++){
            int ele = temp[i];
            while(!st.isEmpty() && ele > temp[st.peek()]) ans[st.peek()] = i-st.pop() ;
            st.push(i);
        }
        return ans;
    }
}
```
