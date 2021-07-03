# **[Smallest subarray with sum greater than x](https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1#)**
# TC - O(N<sup>2</sup>)
```java
int smallestSubWithSum(int arr[], int n, int x)
{
    //  Initialize length of smallest subarray as n+1
     int min_len = n + 1;

     // Pick every element as starting point
     for (int start=0; start<n; start++)
     {
          // Initialize sum starting with current start
          int curr_sum = arr[start];

          // If first element itself is greater
          if (curr_sum > x) return 1;

          // Try different ending points for curremt start
          for (int end=start+1; end<n; end++)
          {
              // add last element to current sum
              curr_sum += arr[end];

              // If sum becomes more than x and length of
              // this subarray is smaller than current smallest
              // length, update the smallest length (or result)
              if (curr_sum > x )
                 min_len = Math.min(min_len, end - start + 1);
          }
     }
     return min_len;
}
```
# TC - O(N) Dry Run : [1, 4, 45, -7, 50, 19] X = 51
```java
class Solution {

    public static int sb(int arr[], int n, int x) {
        // Your code goes here 
        int start=0,sum=0;
        int ans=n+1;
        for(int e=0; e<n; e++){
            if(arr[e] > x) return 1;
            if(sum <= x)sum+=arr[e];
            while(sum > x){
                ans=Math.min(ans,e+1-start);
                sum-=arr[start];
                start++;
            }
        }
        return ans;
        
    }
}
```
## **[Video Reference (Watch Logic only)](https://youtu.be/b7wMv62Y1l4)**
