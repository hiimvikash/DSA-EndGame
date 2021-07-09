# **[Row with max 1s](https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#)**
## **My Intution 1 :- TC - O(N log M)**

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
## **My Intution 2 :- TC - O(N*M) but in AvgCase : O(N+M)**
Here we will check column wise and search for first instances of 1's and will return that row.
```java
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        for(int c=0;c<m;c++){
            for(int r=0;r<n;r++){
                if(arr[r][c]==1) return r;
            }
        }
        return -1;
    }
}
```
## **My Intution 3 :- TC - O(N+M)**
```java
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int row=-1;
        int firstInstance=m-count1(arr[0]);
        if(firstInstance!=m) row=0;
        int searchI=firstInstance-1;
        for(int i=1;i<n;i++){
            while(searchI>=0 && arr[i][searchI]==1){
                firstInstance=searchI;
                searchI--;
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
## **[Video Reference](https://youtu.be/ZkwtIuJvLvw)**