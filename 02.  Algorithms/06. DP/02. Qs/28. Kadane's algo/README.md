# [**Largest sum in a subarray**](https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1#)

## Using DP
 ```java
class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        
        // Your code here
        long s=arr[0],bs=arr[0];
        for(int i=1;i<n;i++){
            if(s>=0) s+=arr[i];
            else s=arr[i];
            
            bs=Math.max(bs,s);
        }
        return bs;
    }
}
```
## [**Video Reference**](https://youtu.be/VMtyGnNcdPw)