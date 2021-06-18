# **[31. Next Permutation](https://leetcode.com/problems/next-permutation/)**
**TC = O(N) SC = O(1)**
# Algorithm 
-  From back find index of that element whose adjacent is greater than it. Let's store that index in breakPoint.
-   from back find that element who is greater than arr[breakPoint] and swap them.
- reverse(arr, breakPoint+1, n-1).
```java
class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        int breakPoint=-1;
        for(int i=n-2; i>=0; i--){
            if(arr[i]<arr[i+1])
            {
                breakPoint=i;
                break;
            }
        }
        if(breakPoint!=-1){
            for(int i=n-1;i>=0;i--){
                if(arr[i]>arr[breakPoint]){
                    swap(arr,breakPoint,i);
                    break;
                }
            }
            reverse(arr,breakpoint+1,n-1);
        }
        else
            reverse(arr,0,n-1);
    }
    public void swap(int arr[], int breakPoint, int i){
        int temp=arr[i];
        arr[i]=arr[breakPoint];
        arr[breakPoint]=temp;
    }
    public void reverse(int arr[],int start,int end){
        while(start<end){
            swap(arr,start,end);
            start++;end--;
        }
    }
}
```
## **[Video Reference](https://youtu.be/LuLCLgMElus)**