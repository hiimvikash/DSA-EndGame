# **[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)**
# My Intution : - Stack DS TC - O(3N)
```java
class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int leftSmall[]=new int[n]; // this will store previous small element left side of ith element
        int rightSmall[]=new int[n];// this will store next small element right side of ith element
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty()) leftSmall[i]=0;
            else leftSmall[i]=st.peek()+1;
            st.push(i);
        }
        st.clear(); // for reusablity
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty()) rightSmall[i]=n-1;
            else rightSmall[i]=st.peek()-1;
            st.push(i);
        }
        int maxA=0;
        for(int i=0;i<n;i++){
            maxA=Math.max(maxA,arr[i]*(rightSmall[i]-leftSmall[i]+1));
        }
        return maxA;
    }
}
```
# My Intution : - Stack DS onePass TC - O(N)
```java
class Solution {
    public int largestRectangleArea(int[] histo) {
       int n=histo.length;
        int maxA=0;
        Stack<Integer> st=new Stack<>(); 
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || histo[st.peek()]>=histo[i])){
                int height=histo[st.pop()];
                int width;
                if(st.isEmpty()) width=i;
                else width=i-st.peek()-1;
                maxA=Math.max(maxA,height*width);
            }
            st.push(i);
        }
        return maxA;
    }
}
```
## **[Video Reference part1](https://youtu.be/X0X6G-eWgQ8)**
## **[Video Reference part2](https://youtu.be/jC_cWLy7jSI)**