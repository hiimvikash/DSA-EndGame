# [**33. Search in Rotated Sorted Array**](https://leetcode.com/problems/search-in-rotated-sorted-array/)

# Thought process :-
- Find Pivot Index (Index of maximum element)
- do BS form 0 to pivotIndex
- do BS form pivotIndex+1 to n

    # Properties of Pivot Index :-
    1. arr[mid] > arr[mid+1] return mid;
    1. arr[mid] < arr[mid-1] return mid-1;
    1. Pivot will always lie in unsorted part.
```java
class Solution {
    public int search(int[] arr, int target) {
        int n=arr.length;
        int pi = findPivot(arr,0,n);
        if(target>=arr[0] && target<= arr[pi]) return bs(arr,0,pi+1,target);
        return bs(arr,pi+1,n,target);
    }
    int findPivot(int arr[], int fromIndex, int toIndex){
        int start = fromIndex;
        int end = toIndex-1;
        
        while(start<=end){
            if(arr[start]<=arr[end]) return start;
            int mid = start + (end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]) return mid;
            if(mid>start && arr[mid-1]>arr[mid]) return mid-1;
            else if(arr[start]>arr[mid]) end=mid-1;
            else if(arr[mid]>arr[end]) start = mid+1;
        }
        return -157;
    }
    int bs(int arr[], int fromIndex, int toIndex, int x){
        int start = fromIndex;
        int end = toIndex-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==x) return mid;
            else if(x>arr[mid]) start = mid+1;
            else if(x<arr[mid]) end = mid-1;
        }
        return -1;
    }
}
```    

