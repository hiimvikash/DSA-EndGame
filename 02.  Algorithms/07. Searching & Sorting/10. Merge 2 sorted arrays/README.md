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
# [**Merge Without Extra Space GFG**](https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1#)
## Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space. Modify aar1 & arr2 such that when arr2 is kept behind arr1 then its merged.
## Injection Method.
```java
class Solution {

    public void merge(int arr1[], int arr2[], int n1, int n2) {
        // code here
        // Made the largest element possible from both array
            int inf=-1;
            for(int ele : arr1) inf=Math.max(ele,inf);
            for(int ele : arr2) inf=Math.max(ele,inf);
            inf=inf+1;
        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            // extract original element to compare
            int e1=arr1[i]%inf;
            int e2=arr2[j]%inf;
            if(e1<=e2){
                if(k<n1)
                    arr1[k]+=(e1*inf);
                else
                    arr2[k-n1]+=(e1*inf);
                    i++;
            }
            else{
                if(k<n1)
                    arr1[k]+=(e2*inf);
                else
                    arr2[k-n1]+=(e2*inf);
                j++;  
            }
            k++;
        }
        // when elements left in arr1 [3,4,5] [1,2]
        while(i<n1){
            int e1=arr1[i]%inf;
            if(k<n1)
                arr1[k]+=(e1*inf);
            else
                arr2[k-n1]+=(e1*inf);
            k++;i++;
        }
        // when elements left in arr2, this means all elements arr1 is placed correctly
        while(j<n2){ // [1,2,4,5] [3,9,10]
            int e2=arr2[j]%inf;
            arr2[k-n1]+=(e2*inf);
            k++;j++;
        }
        // till here my injection are over. now only need to modify arr1 & arr2 with injected element
        for(i=0;i<n1;i++){
            arr1[i]/=inf;
        }
        for(i=0;i<n2;i++){
            arr2[i]/=inf;
        }
    }
}
```