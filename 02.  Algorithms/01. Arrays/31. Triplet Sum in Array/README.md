# **[Triplet Sum in Array](https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1#)**

## My Intution : - Two Pointer Technique TC - O(N<sup>2</sup>) SC - O(1)

For each array element **ele,** we will find pair whose sum is **X-ele,** because **ele + (X - ele) = X .** If such pair found we return true.

```java
class Solution
{
    //Function to find if there exists a triplet in the
    //array A[] which sums up to X.
    public static boolean find3Numbers(int arr[], int n, int X) {
       // Your code Here
       Arrays.sort(arr);
       for(int i=0;i<n-2;i++){
           if(twoSum(arr,X-arr[i],i+1))
            return true;
       }
        return false;
    }
    private static boolean twoSum(int a[], int x, int i){
        int j=a.length-1;
        while(i<j){
            if(a[i]+a[j]>x) j--;
            else if(a[i]+a[j]<x) i++;
            else return true;
        }
        return false;
    }
}
```
