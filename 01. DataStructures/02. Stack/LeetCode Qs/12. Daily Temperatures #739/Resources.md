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
        // to store index - nextGelementIndex in HM for all temperatures
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) st.pop();
            if(st.isEmpty()) st.push(i);
            else{
                hm.put(i, st.peek());
                st.push(i);
            }
        }

        int ans[]=new int[n];
        for(int i = 0; i<n; i++){
            ans[i] = hm.getOrDefault(i,i) - i;
        }

        return ans;
    }
}

```
