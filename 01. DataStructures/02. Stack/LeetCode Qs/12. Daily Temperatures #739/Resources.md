### **Problem Link:**

- #### [Daily Temperatures #739](https://leetcode.com/problems/daily-temperatures/)

### **Solution Link:**

- #### [Daily Temperatures #739 solution](./Solution.java)
## Same as NGE
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int n = temperatures.length;
        int ans[]=new int[n];
        // to store index - nextGelementIndex in HM for all temperatures
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) st.pop();
            if(st.isEmpty()){
                 ans[i] = 0;
            }
            else{
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }
}
```
