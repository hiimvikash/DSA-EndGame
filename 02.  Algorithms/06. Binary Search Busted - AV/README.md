[**<h1 align="center">Binary Search - Aditya Verma</h1>**](https://youtube.com/playlist?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2)
# **0. Time Complexity**

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