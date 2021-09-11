# **[Three way partitioning](https://practice.geeksforgeeks.org/problems/three-way-partitioning/1#)**
# MY Intution : DNF Sort TC - O(N)

```java
class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b)
    {   int n=arr.length;
        /*    0 to i-1  <a
              i to curr-1 atob
              curr to k unk
              k+1 to e  >b
        */
        // code here
        int i=0,curr=0,k=n-1;
        while(curr<=k){
            int ch=compare(arr[curr],a,b);
            switch(ch){
                case -1 : swap(arr,curr,i); i++; curr++;
                break;
                case 0: curr++;
                break;
                case 1: swap(arr,curr,k); k--;
            }
        }
    }
    public int compare(int ele,int a, int b){
        if(ele<a) return -1;
        else if(ele>=a && ele<=b) return 0;
        else return 1;
    }
    private void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
```
