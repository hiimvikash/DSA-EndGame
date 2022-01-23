# [**Pairs with specific difference**](https://practice.geeksforgeeks.org/problems/pairs-with-specific-difference1533/1#)

 ```java
class Solution { 
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int n, int k) 
    {
        // Your code goes here 
        Arrays.sort(arr);
        int ans=0;
        int i=n-1;
        while(i>0){
            if(arr[i]-arr[i-1]<k){
               ans+=arr[i]+arr[i-1];
               i-=2;
            }
            else i--;
        }
        return ans;
    }
    
}
```
## [**video reference**](https://youtu.be/yDZGsjc007Y)