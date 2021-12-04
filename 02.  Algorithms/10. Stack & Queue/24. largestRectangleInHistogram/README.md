# **[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)**
**TC = O(3N)**
```java
class Solution {
    public int largestRectangleArea(int[] histo) {
        int n=histo.length;
        
        int ls[]=new int[n]; int rs[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && histo[st.peek()]>=histo[i]) st.pop();
            if(st.isEmpty()) ls[i]=-1;
            else ls[i]=st.peek();
            
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && histo[st.peek()]>=histo[i]) st.pop();
            if(st.isEmpty()) rs[i]=n;
            else rs[i]=st.peek();
            
            st.push(i);
        }
        int maxA=0;
        for(int i=0;i<n;i++){
            maxA = Math.max(maxA,histo[i]*(rs[i]-ls[i]-1));
        }
        return maxA;
    }
}
```
## **[Video Reference](https://youtu.be/X0X6G-eWgQ8)**