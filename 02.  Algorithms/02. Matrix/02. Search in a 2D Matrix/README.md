# **[74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)**
# **[Search a 2D Matrix gfg](https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/)** - Intution 1 & 2 applicable only.
## My Intution 1 : - TC -  O(N Log M)
- Doing BS for each outer each N rows
```java
class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n=arr.length, m=arr[0].length;
        for(int i=0;i<n;i++){
            if(binarySearch(arr[i],0,m,target)>=0) return true;
        }
        return false;
    }
    private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high)/2;
            int midVal = a[mid];

            if (key > midVal)
                low = mid + 1;
            else if (key < midVal)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
```
## My Intution 2 : O(log MN)
- Using the fact that elements are rowWise + columnWise Sorted.
```java
class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n=arr.length, m=arr[0].length;
        int miR=0,maC=m-1;
        
        while(miR < n && maC >= 0){
            // move left side
            if(target<arr[miR][maC]){
                maC--;
            }
            // move downward
            else if(target>arr[miR][maC]){
                miR++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
```
**[Video Reference](https://youtu.be/ZYpYur0znng)**
