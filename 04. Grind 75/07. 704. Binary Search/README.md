# [704. Binary Search](https://leetcode.com/problems/binary-search/)
## Itterative
```java
class Solution {
    public int search(int[] arr, int x) {
        int s = 0, e = arr.length-1;
        
        while(s<=e){
            int mid = s + (e-s)/2;
            
            if(x > arr[mid]) s = mid+1;
            else if(x < arr[mid]) e = mid-1;
            else return mid;
        }
        return -1;
    }
}
```
## Reccursive
```java
class Solution {
    public int search(int[] arr, int x) {
        int s = 0, e = arr.length-1;
        
        int ans = fun(arr,s,e,x);
        return ans;
        
    }
    
    int fun(int arr[], int s, int e, int x){
        if(s>e) return -1;
        int mid = s + (e-s)/2;
        
        if(x > arr[mid]) return fun(arr, mid+1, e, x);
        else if(x < arr[mid]) return fun(arr, s, mid-1, x);
        else return mid;
    }
    
}
```