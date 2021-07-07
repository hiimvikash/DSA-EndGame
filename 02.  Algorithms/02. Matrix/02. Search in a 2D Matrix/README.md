# **[74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)**
## My Intution : - TC -  O(N Log M)
- Doing BS for each outer each N rows
```java
class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n=arr.length, m=arr[0].length;
        int start=0, end=0, mid=0;
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
**[Video Reference](https://youtu.be/ZYpYur0znng)**
