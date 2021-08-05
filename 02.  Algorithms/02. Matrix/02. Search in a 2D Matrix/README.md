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
## My Intution 2 : 
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
## My Intution 3 : **only for LC** O(log NM)
based on : -
- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.
- we do BS from 0 to n*m
- Due to 1st two properties we can give contiguous index to each box(0...n*m-1)
![2Dsearch](https://user-images.githubusercontent.com/71629248/124802453-9cd05a00-df75-11eb-9856-8ecaa86d4e99.png)

```java
class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n=arr.length, m=arr[0].length;
        
        if(binarySearch(arr,0,n*m,target,m)>=0) return true;
        return false;
    }
    private static int binarySearch(int[][] a, int fromIndex, int toIndex, int key, int m) {
        int low = fromIndex;
        int high = toIndex - 1;
        
        while (low <= high) {
            int mid = (low + high)/2;
            int midVal = a[mid/m][mid%m];

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
## **[Video Reference](https://youtu.be/ZYpYur0znng)**


# Simple BS Itterative
```java
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
```
# Simple BS Reccursive
```java
static boolean bs(int arr[],int s,int e, int x) {
		if(s<=e) {
			int mid=(s+e)/2;
			int midV=arr[mid];
			if(x==midV) return true;
			else if(x>midV) return bs(arr,mid+1,e,x);
			else if(x<midV) return bs(arr,s,mid-1,x);
		}
		return false;
}
```