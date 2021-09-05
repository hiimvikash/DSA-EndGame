# [**88. Merge Sorted Array**](https://leetcode.com/problems/merge-sorted-array/)
## You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively. Merge nums1 and nums2 into a single array sorted in non-decreasing order. The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
# Thought Process :-
- Start filling the max of two array from back
```java
class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while(i>=0 && j>=0){
            arr1[k--]= (arr1[i]>arr2[j])?arr1[i--]:arr2[j--];    
        }
        while(j>=0) arr1[k--]=arr2[j--];
    }
}
```