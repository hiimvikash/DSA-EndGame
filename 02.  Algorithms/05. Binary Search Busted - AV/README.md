[**<h1 align="center">Binary Search - Aditya Verma</h1>**](https://youtube.com/playlist?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2)
# **0. Time Complexity**
![BS2 TC](https://user-images.githubusercontent.com/71629248/131242067-5813edab-bb16-4794-bb13-ce4e663c138e.png)

# [**1. Binary Search Basic**](https://youtu.be/QNGL_t_o_QA)
![BS1](https://user-images.githubusercontent.com/71629248/131240871-ce657d2c-4880-4504-93ed-e577916ae295.png)
##  **2. BS on Ascending Order sorted array :-**
```java
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
        return -(start + 1);  // if key not found then -(thisVal+1) will give insertion point.
}
```
## **2. BS on Descending Order sorted array :-**
```java
private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = a[mid];

            if (key < midVal)
                start = mid + 1;
            else if (key > midVal)
                end = mid - 1;
            else
                return mid; // key found
        }
        return -(start + 1);  // if key not found then -(thisVal+1) will give insertion point.
}
```
## **3. Order Agnostic Binary Search (when you don't know in which order the array is sorted):**
```java
private static int AgnosticbinarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;
        boolean isAsc= a[start] < a[end]
        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = a[mid];

            if (key > midVal)
                if(isAsc) start = mid + 1; else end = mid - 1;
            else if (key < midVal)
                if(isAsc) end = mid - 1; else start = mid + 1;
            else
                return mid; // key found
        }
        return -(start + 1);  // if key not found then -(thisVal+1) will give insertion point.
}
```
# [**4. First and last occurrences of x**](https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1)
## [**Video Reference**](https://youtu.be/zr_AoTxzn0Y)
```java
class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        ArrayList<Long> ans=new ArrayList<>();
        ans.add(binarySearchFL(arr,0,n,x,true));
        ans.add(binarySearchFL(arr,0,n,x,false));
        return ans;
        
    }
    private static long binarySearchFL(long[] a, int fromIndex, int toIndex, int key, boolean isF) {
        int start = fromIndex;
        int end = toIndex - 1;
        int ansF=-1; // this will store 1stOcurrence
        int ansL=-1; // this will store LastOcurrence
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            long midVal = a[mid];

            if ((long)key > midVal)
                start = mid + 1;
            else if ((long)key < midVal)
                end = mid - 1;
            else{
                if(isF){
                ansF=mid;
                end = mid - 1;// key found
                }
                else{
                    ansL=mid;
                    start = mid + 1;// key found
                }
            }
        }
        if(ansF!=-1 && isF) return (long)ansF;
        if(ansL!=-1 && !isF) return (long)ansL;
        return -1;  // if key not found 
    }
    
}
```
# [**5. COUNT NUMBER OF OCURRENCES(or frequency) of X IN A SORTED ARRAY:**](https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1)
## [**Video Reference**](https://youtu.be/Ru_HhBFV3Xo)
```java
class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int fo=binarySearchFL(arr,0,n,x,true);
        int lo=binarySearchFL(arr,0,n,x,false);
        if(fo==-1 || lo==-1) return 0;
        if(fo==lo) return 1;
        return lo-fo+1;
    }
    private static int binarySearchFL(int[] a, int fromIndex, int toIndex, int key, boolean isF) {
        int start = fromIndex;
        int end = toIndex - 1;
        int ansF=-1; // this will store 1stOcurrence
        int ansL=-1; // this will store LastOcurrence
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            long midVal = a[mid];

            if ((long)key > midVal)
                start = mid + 1;
            else if ((long)key < midVal)
                end = mid - 1;
            else{
                if(isF){
                ansF=mid;
                end = mid - 1;// key found
                }
                else{
                    ansL=mid;
                    start = mid + 1;// key found
                }
            }
        }
        if(ansF!=-1 && isF) return ansF;
        if(ansL!=-1 && !isF) return ansL;
        return -1;  // if key not found 
    }

}
```
# [**6. Number of Times a Sorted array is Rotated**](https://practice.geeksforgeeks.org/problems/rotation4723/1#)
![BSRC](https://user-images.githubusercontent.com/71629248/131263220-94ca2379-b795-4450-be19-d35af48e42c2.png)

```java
class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        return findPivot(arr,0,n)+1;
    }
    // this will return pivot
    int findPivot(int arr[],int fromIndex,int toIndex){
        int start=fromIndex;
        int end=toIndex-1;
        if(arr[start]<=arr[end]) return -1;
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
# [**9. Floor in a sorted array**](https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1#)
## [**Video Reference**](https://youtu.be/5cx0xerA8XY)
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
## Approach 2 :- **When Key is not found Start will point to Ceil and End will point floor in general** and start is also known as insertion point.
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
# [**10.Ceil in a sorted array**](https://youtu.be/uiz0IxPCUeU)
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