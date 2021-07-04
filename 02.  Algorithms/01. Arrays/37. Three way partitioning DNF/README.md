# **[Three way partitioning](https://practice.geeksforgeeks.org/problems/three-way-partitioning/1#)**
# MY Intution : DNF Sort TC - O(N)
- ## Now DNF algo states that
  - **[0...low-1] will contain numbers < a**
  - **[high+1...n] will contain numbers > b**
  - ## Seeing the above condition we build following algo to sort
  - **mid will traverse throughout the array till mid<=high.**
  - **case 0: arr[mid] < a**
    - **swap(mid,low); low++; mid++;**
  - **case 1: arr[mid] >= a && arr[mid] <= b**
    - **mid++;**
  - **case 2: arr[mid] > 2**
    - **swap(mid,high); high--;**
```java
class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b)
    {
        // code here 
        int n=arr.length;
        if(n==1) return;
        int low=0,mid=0,high=n-1;
        while(mid<=high){
            if(arr[mid]<a){
                    if(low!=mid) swap(arr,low,mid);
                low++;mid++;
            }
            
            else if(arr[mid]>=a && arr[mid]<=b) mid++;
            else if(arr[mid]>b) {swap(arr,mid,high); high--;}
            
        }
    }
    void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
```
