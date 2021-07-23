# **[Max rectangle](https://practice.geeksforgeeks.org/problems/max-rectangle/1#)**
## Prerequisite : [Maximum Rectangle Area in Histogram](../../01.%20Arrays/43.%20Largest%20Rectangle%20in%20Histogram%20LC-84/README.md)
```java
class Solution {
    public int maxArea(int arr[][], int n, int m) {
        // add code here.
        int sumArr[]=new int[m];
        
        int maxA=-1;
        for(int i=0;i<n;i++){
            makeSum(sumArr,arr[i]);
            maxA=Math.max(maxA,largestRectangleArea(sumArr));
        }
        return maxA;
    }
    public void makeSum(int sum[],int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) sum[i]=0;
            else sum[i]+=arr[i];
        }
    }
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
## **[Video Reference](https://youtu.be/St0Jf_VmG_g)**