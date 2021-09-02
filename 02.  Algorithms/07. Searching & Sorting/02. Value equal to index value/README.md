# [**Value equal to index value**](https://practice.geeksforgeeks.org/problems/value-equal-to-index-value1330/1#)
```java
class Solution {
    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]==i+1){
                ans.add(arr[i]);
            }
        }
        return ans;
    }
}
```

# Similar Qs : -
## **1.** Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point in the array, if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i such that arr[i] is equal to i. Note that integers in array can be negative. **No Dublicates allowed**
## Examples :-
```
  Input: arr[] = {-10, -5, 0, 3, 7}
  Output: 3  // arr[3] == 3 

  Input: arr[] = {0, 2, 5, 8, 17}
  Output: 0  // arr[0] == 0 


  Input: arr[] = {-10, -5, 3, 4, 7, 9}
  Output: -1  // No Fixed Point
```
## Approach 1 :  Do Linear Search
## Approach 2 : BS
## Thought Process :- 
- Sorted Array think of BS.
- when arr[mid]==mid we return mid.
- when arr[mid] > mid ANS will lie in **left half**
- when arr[mid] < mid ANS will lie in **right half**
```java
int findFixedPoint(int arr[],int fromIndex, int toIndex){
    int start = fromIndex;
    int end = toIndex-1;
    while(start<=end){
        int mid = start + (end-start)/2;
        if(arr[mid]==mid) return mid;
        else if(arr[mid]>mid) end=mid-1;
        else if(arr[mid]<mid) start = mid+1;
    }
    return -1;
}
```
## **2. Dublicates allowed**
## Thought Process :- 
- Sorted Array think of BS.
- when arr[mid]==mid we return mid.
- when arr[mid] != mid it can lie any of the side Left/Right so here we have choice so we will do recursion.
    - **left half** ---> **start = start, end = min(arr[midIndex], midIndex-1)**
        - This is because Let's say mid = 5 and arr[mid] = 2
        - Here you will choose end = 2 because as array is sorted so its impossible to get your ans in indexes 4,3
    - **right half** ---> **start = max(arr[midIndex], midIndex+1), end = end**
        - This is because Let's say mid = 5 and arr[mid] = 8
        - Here you will choose start = 8 because as array is sorted so its impossible to get your ans in indexes 6,7
```java
int findFixedPoint(int arr[],int start, int end){
    int mid= start + (end-start)/2;
    if(arr[mid]==mid) return mid;
    
        int left =findFixedPoint(arr, start, Math.min(mid-1,arr[mid]));
        if(left>-1) return left;
        return findFixedPoint(arr, Math.max(mid+1,arr[mid]) , end);
}
```    
