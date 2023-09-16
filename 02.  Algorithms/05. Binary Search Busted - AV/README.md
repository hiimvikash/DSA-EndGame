[**<h1 align="center">Binary Search - Aditya Verma</h1>**](https://youtube.com/playlist?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2)
# **0. Time Complexity**
![BS2 TC](https://user-images.githubusercontent.com/71629248/131242067-5813edab-bb16-4794-bb13-ce4e663c138e.png)

# [**1. Binary Search Basic**](https://youtu.be/QNGL_t_o_QA)
![image](https://github.com/hiimvikash/DSA-EndGame/assets/71629248/0b8657f4-3d74-4f05-9b9c-e175f17b6f8a)

##  **2. BS on Ascending Order sorted array :-**
```java
private static int binarySearch(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (key > arr[mid])
                s = mid + 1;
            else if (key < arr[mid])
                e = mid - 1;
            else
                return mid; // key found
        }
        return -1;
}
```
## **2. BS on Descending Order sorted array :-**
```java
private static int binarySearch(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;

        while (start <= end) {
            int mid = s + (e-s)/2;

            if (key < arr[mid])
                s = mid + 1;
            else if (key > arr[mid])
                e = mid - 1;
            else
                return mid; // key found
        }
        return -1;
}
```
## **3. Order Agnostic Binary Search (when you don't know in which order the array is sorted):**
```java
private static int AgnosticbinarySearch(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;
        boolean isAsc= arr[s] < a[e];
        while (s <= e) {
            int mid = s + (e-s)/2;

            if (key > arr[mid])
                if(isAsc) s = mid + 1; else e = mid - 1;
            else if (key < arr[mid])
                if(isAsc) e = mid - 1; else s = mid + 1;
            else
                return mid;
        }
        return -1;
}
```
# [**4. First and last occurrences of x**](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)
## [**Video Reference**](https://youtu.be/zr_AoTxzn0Y)
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{fnl(nums,target, true), fnl(nums, target, false)};
    }

    private int fnl(int arr[], int x, boolean isF){
        int s = 0;
        int e = arr.length-1;

        int ans = -1;
        while(s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid] == x){
                ans = mid;
                if(isF) e = mid - 1;
                else s = mid + 1;
            }
            else if(x > arr[mid]) s = mid+1;
            else e = mid - 1;
        }
        return ans;
    }
}
```
# [**5. COUNT NUMBER OF OCURRENCES(or frequency) of X IN A SORTED ARRAY:**](https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1)
## [**Video Reference**](https://youtu.be/Ru_HhBFV3Xo)
## Intution :-
- lastOccurence - FirstOccurence + 1;
```java
class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int lo = fnl(arr, x, false);
        if(lo == -1) return 0;
        return lo - fnl(arr, x, true) + 1;
        
    }
    private int fnl(int arr[], int x, boolean isF){
        int s = 0;
        int e = arr.length-1;

        int ans = -1;
        while(s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid] == x){
                ans = mid;
                if(isF) e = mid - 1;
                else s = mid + 1;
            }
            else if(x > arr[mid]) s = mid+1;
            else e = mid - 1;
        }
        return ans;
    }
}
```

# 6. Floor in a sorted array
## - Floor of X is a GE from Es which are <= X
## - [2, 4, 7, 9, 10, 13, 18, 23] x = 12, Floor of X = 10(index 4)

## Approach 1 :- Whenever you find valid candidates, store it index as answer and search for greater valid index.
```java
int floor(int arr[], int x){
    int s = 0;
    int e = arr.length - 1;
    int ans = -1;
    while(s<=e){
        int mid = s+(e-s)/2;
        if(arr[mid] == x) return mid;
        if(arr[mid] < x){
            ans = mid;
            s = mid+1;
        }
        else e = mid - 1;
    }
    return ans;
}
```
## Approach 2 :- Do normal BS, if ele is not found then end will point to floor.
<hr>

# 7. Ceil in a sorted array.(Lower Bound)
## - Ceil of X is a SE from Es which are >= X
## - [2, 4, 7, 9, 10, 13, 18, 23] x = 12, Floor of X = 13(index 5)
## Approach 1 :- Whenever you find valid candidates, store it index as answer and search for smaller valid index.
```java
int ceil(int arr[], int x){
    int s = 0;
    int e = arr.length - 1;
    int ans = n;
    while(s<=e){
        int mid = s + (e-s)/2;

        if(arr[mid] == x) return mid;
        if(arr[mid] > x){
            ans = mid;
            e = mid-1;
        }
        else s = mid+1;
    }
    return ans;
}
```
## Approach 2 :- Do normal BS, if ele is not found then start will point to ceil.

<hr>

# 8. Upper Bound :- UB of X is a SE from Es which are > X
## - [2, 4, 7, 9, 10, 13, 18, 23] x = 13, Floor of X = 18(index 6)
## Approach 1 :- Whenever you find valid candidates, store it index as answer and search for smaller valid index.
```java
int ub(int arr[], int x){
    int s = 0;
    int e = arr.length - 1;
    int ans = n;
    while(s<=e){
        int mid = s + (e-s)/2;
        if(arr[mid] > x){
            ans = mid;
            e = mid-1;
        }
        else s = mid+1;
    }
    return ans;
}
```



# [**9. Number of Times a Sorted array is Rotated**](https://practice.geeksforgeeks.org/problems/rotation4723/1#)
![image](https://github.com/hiimvikash/DSA-EndGame/assets/71629248/24b785d6-a163-484e-aeca-bddf1a96b120)



```java
int findKRotation(int arr[], int n) {
        // code here
        int s = 0;
        int e = n-1;
        if(arr[s] <= arr[e]) return 0;
        while(s<=e){
            int mid = s+(e-s)/2;
            
            // answer returning situation
            if(arr[mid+1] < arr[mid]) return mid+1;
            if(arr[mid] < arr[mid-1]) return mid;
            
            // move to unsorted part
            else if(arr[s] > arr[mid]) e = mid-1;
            else if(arr[mid] > arr[e]) s = mid+1;
        }
        return 87456;
    }
```
# [**7. Search in Rotated Sorted Array LC-33**](https://leetcode.com/problems/search-in-rotated-sorted-array/)
## Intution :-
- Find Pivot.
- Now **0 to pivot** & **pivot+1 to n-1** is sorted.
- then check the range where your target lies and perform BS in that range. 
```java
class Solution {
    public int search(int[] arr, int target) {
        int n=arr.length;
        int pi=findPivot(arr,0,n); // pivot index
        if(target>=arr[0] && target<= arr[pi]) return binarySearch(arr,0,pi+1,target);
        return binarySearch(arr,pi+1,n,target);
    }
    private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = a[mid];

            if (key > midVal)
                start = mid + 1;
            else if (key < midVal)
                end = mid - 1;
            else
                return mid; // key found
        }
        return -1;  
    }
    private int findPivot(int arr[],int fromIndex,int toIndex){
        int start=fromIndex;
        int end=toIndex-1;
        if(arr[start]<=arr[end]) return 0;
        while(start<=end){
            int mid= start + (end-start)/2;
            if(mid < end && arr[mid]>arr[mid+1]) return mid;
            if(mid > start && arr[mid]<arr[mid-1]) return mid-1;
            // as we are looking for pivot that's why we r getting attracted toward unsorted part.
            else if(arr[start]>arr[mid]) end=mid-1;
            else if(arr[mid]>arr[end]) start=mid+1;
        }
        return 6778;
    }
}
```
# [**8. Search in an almost sorted array**](https://youtu.be/W3-KgsCVH1U)
```java
int BinarySearchModi(int arr[], int fromIndex, int toIndex, int key){
    int start=fromIndex,end=toIndex-1;
    while(start<=end){
        int mid = start + (end-start)/2;
        if(key==arr[mid]) return mid;
        if(mid > start && key==arr[mid-1]) return mid-1;
        if(mid < end && key==arr[mid+1]) return mid+1;
        else if(key>mid) start = mid+2;
        else if(key<mid) end = mid-2;
    }
    return -1;
}
```


# [**9. Floor in a sorted array**](https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1#) - INDEX OF MAX(No.s which are less than X) - index of GREATEST ELEMENT SMALLER THAN X
## [**Video Reference**](https://youtu.be/5cx0xerA8XY)
# Input :- [2,4,7,9,10,13,18,23] x = 12 floor = index 4(10) & ceil = index 5(13)
Intutive approach
```JAVA
class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        int s = 0;
        int e = n-1;
        int ans = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            
            if(arr[mid] < x){
                ans = Math.max(ans,mid);
                s=mid+1;
            }
            else if(arr[mid] > x) e = mid-1;
            else return mid;
        }
        return ans;
    }
    
}
```
## Approach 1 :-
```java
static int findFloor(long arr[], int n, long x)
    {
        return binarySearch(arr,0,n,x);
    }
    private static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        int start = fromIndex;
        int end = toIndex - 1;
        int ans=-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            long midVal = a[mid];

            if (midVal<key){
                ans=mid;
                start = mid + 1;
            }
                
            else if (midVal>key)
                end = mid - 1;
            else
                return mid; // key found
        }
        return ans;  // if key not found then -(thisVal+1) will give insertion point.
    }
}
```
## Approach 2 :- **When Key is not found, Start ---> ceil and End ---> floor in general** and ceil(start) is also known as insertion point.
```java
static int findFloor(long arr[], int n, long x)
    {
        return binarySearch(arr,0,n,x);
    }
    private static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        int start = fromIndex;
        int end = toIndex - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            long midVal = a[mid];

            if (midVal<key){
                start = mid + 1;
            }
                
            else if (midVal>key)
                end = mid - 1;
            else
                return mid; // key found
        }
        return end;  
    }
    
}
```
# [**10.Ceil in a sorted array or Lower Bound**](https://www.codingninjas.com/studio/problems/lower-bound_8165382?leftPanelTab=1) - INDEX OF MIN(No.s which are greater than X)

```java
public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int s = 0;
        int e = n-1;
        int ans = n;
        while(s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid] > x){
                ans = Math.min(ans,mid);
                e = mid-1;
            }
            else if(arr[mid] < x) s = mid+1;
            else return mid;
        }
        return ans;
    }
}
```
```java
static int findCeil(long arr[], int n, long x)
    {
        return binarySearch(arr,0,n,x);
    }
    private static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        int start = fromIndex;
        int end = toIndex - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            long midVal = a[mid];

            if (midVal<key){
                start = mid + 1;
            }
                
            else if (midVal>key)
                end = mid - 1;
            else
                return mid; // key found
        }
        return start;  
    }
}
```

# [**11. Next Alphabetical Element**](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)
## [**Video Reference**](https://youtu.be/X45c37QMdX0)
```java
class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        return bs(arr,0,arr.length,target);
    }
    public char bs(char arr[], int fromIndex, int toIndex, char key){
        int start=fromIndex; int end= toIndex-1;
        char ans='.';
        if(key>=arr[end]) return arr[start];
        while(start<=end){
            int mid= start + (end-start)/2;
            if(arr[mid]>key){
                ans=arr[mid];
                end=mid-1;
            }
            else if(arr[mid]<=key)
                start=(mid+1) % toIndex;             
        }
        return ans;
    }
}
```
# [**12. Find position of an element in a Infinite sorted array**](https://youtu.be/FzvK5uuaki8)
## We are Increasing our search space by 2 in each itteration.
```java
static int findPos(int arr[],int key){
		int s = 0, e = 1;
		while (key > arr[e]){
		    int currSize = e-s+1;
          	s=e+1;
          	e= e + currSize*2;
		}
		return binarySearch(arr, s, e+1, key);
}
```
# [**13. Index of First 1 in a Binary Sorted Infinite Array**](https://youtu.be/FzvK5uuaki8)
```java
static int findPos(int arr[],int key){
		int s = 0, e = 1;
		while (key > arr[e]){
		    int currSize = e-s+1;
          	s=e+1;
          	e= e + currSize*2;
		}
		return binarySearchFL(arr,s,e+1,1,true);
}
```
# [**14. Minimum Difference Element in a Sorted Array**](https://youtu.be/3RhGdmoF_ac)
```java
static int minimumDiff(long arr[], int n, long x){
     return binarySearch(arr,0,n,x);
}
    private static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        int start = fromIndex;
        int end = toIndex - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            long midVal = a[mid];

            if (midVal<key){
                start = mid + 1;
            }
                
            else if (midVal>key)
                end = mid - 1;
            else
                return 0; // key found
        }
        if(end<0) return Math.abs(arr[start]-key); // [2,4,6,8] key = 1 S-->0 E-->-1
        if(start>toIndex-1) return Math.abs(arr[end]-key); // [2,4,6,8] key = 10 S-->N E-->N-1
        return Math.min(Math.abs(arr[start]-key),Math.abs(arr[end]-key)); 
    }
}
```
# [**15. Peak Index in a Mountain Array**](https://leetcode.com/problems/peak-index-in-a-mountain-array/)
## Approach 1 : 
```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return peakIndexMountain(arr,0,arr.length);
    }
    int peakIndexMountain(int arr[], int fromIndex, int toIndex){
        int start =0,end=toIndex-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return mid;
            else if(arr[mid]<arr[mid+1]) start=mid+1; // you are in increasing part
            else if(arr[mid]<arr[mid-1]) end=mid-1; // you are in decreasing part
        }
        return -1;
    }
}
```
## Approach 2 : [Video Reference](https://youtu.be/W9QJ8HaRvJQ?t=7080)
```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return peakIndexMountain(arr,0,arr.length);
    }
    int peakIndexMountain(int arr[], int fromIndex, int toIndex){
        int start = 0;
        int end = toIndex-1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(arr[mid+1]>arr[mid]){
                // we are in ascending part so there may be more bigE further
                start=mid+1;
            }
            else if(arr[mid]>arr[mid+1]){
                // we are in descending part so our ans can be where we r standing only when there is no bigE further from behind
                end=mid;
            }
        }
        // in the end start == end point to the peak of the mountain
        return start; // return start or end since both are same
    
    }
}
```
# [**16. Find in Mountain Array**](https://leetcode.com/problems/find-in-mountain-array/)
- First find the peak index in the mountain array.
- Search in the first half (asc order) and if not found then second half.
- Use Order Agnostic Binary Search to search the target.
```java
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int pki=peakOfMountainArray(arr);
        int ans1=AgnosticbinarySearch(arr,0,pki+1,target);
        if(ans1>-1) return ans1;
        else return AgnosticbinarySearch(arr,pki+1,arr.length(),target);
    }
    
    
    private static int AgnosticbinarySearch(MountainArray a, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;
        boolean isAsc= a.get(start) < a.get(end);
        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = a.get(mid);

            if (key > midVal)
                if(isAsc) start = mid + 1; else end = mid - 1;
            else if (key < midVal)
                if(isAsc) end = mid - 1; else start = mid + 1;
            else
                return mid; // key found
        }
        return -1;  // if key not found then -(thisVal+1) will give insertion point.
    }
    
    int peakOfMountainArray(MountainArray A) {
		int start = 0;
		int end = A.length() - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;

			if (A.get(mid) > A.get(mid + 1)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
```
# [**17. Allocate minimum number of pages**](https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1#)
## [**Video Reference**](https://youtu.be/gYmWHvRHu-s)
```java
class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int n,int s)
    {
        //Your code here
        if(s>n) return -1;
        int low=0;int high=0; int ans=0;
        for(int i=0;i<n;i++){ low=Math.max(arr[i],low); high+=arr[i]; }
        while(low<=high){
            int mid=(low+high)/2;
            if(isAllocationPossible(arr,mid,s)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static boolean isAllocationPossible(int arr[], int barrier,int s){
        int studentAlc=1; int pages=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>barrier) return false;
            if(arr[i]+pages > barrier){
               studentAlc+=1;
               pages=0;
               pages+=arr[i];
            }
            else pages+=arr[i];
        }
        if(studentAlc>s) return false; else return true;
    }
    
};
```
# [**18. Split Array Largest Sum**](https://leetcode.com/problems/split-array-largest-sum/)
```java
class Solution {
    public int splitArray(int[] arr, int s) {
        int n=arr.length;
        if(s>n) return -1;
        int low=0;int high=0; int ans=0;
        for(int i=0;i<n;i++){ low=Math.max(arr[i],low); high+=arr[i]; }
        
        while(low<=high){
            int mid=(low+high)/2;
            if(isansValid(arr,mid,s)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    boolean isansValid(int arr[], int barrier, int s){
        int studentAlc=1,pages=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>barrier) return false;
            if(arr[i]+pages>barrier){
               studentAlc+=1;
                pages=0;
                pages+=arr[i];
            }
            else pages+=arr[i];
        }
        if(studentAlc>s) return false; return true;
    }
}
```
