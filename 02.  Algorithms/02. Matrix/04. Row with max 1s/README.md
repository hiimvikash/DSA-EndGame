# **[Row with max 1s](https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#)**
## **My Intution :- TC - O(N log M)**

```java
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        
        int maxCount=Integer.MIN_VALUE;int row=-1;
        for(int i=0;i<n;i++){
            int count=0;
            count=count1(arr[i]);
            // count > maxCount because we have been ask to"Find the 0-based index of the first row that has the maximum number of 1's." 
            // count != 0 because we want to return -1 when count is 0.
            if(count>maxCount && count!=0){
                maxCount=count;
                row=i;
            }
        }
        return row;
    }
    private int count1(int arr[]){
        // here we will find number which is exactly first greater than key
        int key=0;
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            int midVal=arr[mid];

            if(key>=midVal) low=mid+1; 
            else if(key<midVal) high=mid-1;
        }
        // returning low means returning no. of elements <= key
        if(low==n) return 0; // means all number is <= key
        return n-low;// here we are returning remaining elements which are not <=key.
    }
}
```
