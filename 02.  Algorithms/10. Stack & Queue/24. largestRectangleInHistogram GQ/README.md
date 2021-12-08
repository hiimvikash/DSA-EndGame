# **[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)**
## **TC = O(3N)**
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
## **[Video Reference P1](https://youtu.be/X0X6G-eWgQ8)**
## **TC - O(N)**
```java
class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> st=new Stack<>();
        int maxA=0;
        int n=h.length;
        for(int i=0; i<=n; i++){
           if(st.isEmpty()) st.push(i); // case 1
            
           else if(i==n && !st.isEmpty()){ // case 2
               while(!st.isEmpty()){
                   int ht=h[st.pop()];
                   int rs=n;
                   int ls=-1;
                   if(!st.isEmpty())
                    ls=st.peek();
                   maxA=Math.max(maxA,ht*(rs-ls-1));
               }
           }
            
           else if(!st.isEmpty()){
               if(h[i] >= h[st.peek()]) st.push(i); // case 3
               else{
                   while(!st.isEmpty() && h[st.peek()]>=h[i]){ // case 4
                       int ht=h[st.pop()];
                       int rs=i;
                       int ls=-1;
                       if(!st.isEmpty())
                        ls=st.peek();
                       maxA=Math.max(maxA,ht*(rs-ls-1));  
                   }
                   st.push(i);
              }
           }
        }
        return maxA;
    }
}

/**
if stack empty hoe toh push
if(h[i]>h[peek]) push

while(h[peek]>h[i]){
    pop wala scene
    joh pop hua woh height
    jiske waja se pop hua wo rs
    ls=peek() else -1 if stack empty
}
push(i)

if(i==n) then pop wala scene
**/
```
## **[Video Reference P2](https://youtu.be/jC_cWLy7jSI)**