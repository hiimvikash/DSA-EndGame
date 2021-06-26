# **[Maximum Product Subarray](https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1)**

## My Intution : -

If comingElement is -VE than max will become moreMINIMUM when multiplied and min will become moreMAXIMUM WHEN multiplied.

## **[Video Reference 1 (watch logic only)](https://youtu.be/lXVy6YWFcRM?t=121)**
```java
class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long maxSoFar=arr[0],minSoFar=arr[0],maxProduct=arr[0];
        for(int i=1;i<n;i++){
            // if comingElement is -VE than max will become moreMINIMUM when multiplied.
            // and min will become moreMAXIMUM WHEN multiplied.
            // so by swaping we are preparing minSoFar and maxSoFar to store their respective value for which they are born.
            if(arr[i]<0){
                long temp=maxSoFar;
                maxSoFar=minSoFar;
                minSoFar=temp;
            }
            minSoFar=Math.min(arr[i],arr[i]*minSoFar);
            maxSoFar=Math.max(arr[i],arr[i]*maxSoFar);

            maxProduct=Math.max(maxProduct,maxSoFar);
        }
        return maxProduct;
    }
}
```

## **[Video Reference 2](https://youtu.be/6EuhbMprB5Y)**

```java
class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long maxSoFar=arr[0],minSoFar=arr[0],maxProduct=arr[0],prevMax=arr[0];
        for(int i=1;i<n;i++){
            prevMax=maxSoFar; //               arr[i]-->+ve     arr[i]-->-ve
            maxSoFar=Math.max(Math.max(arr[i],arr[i]*maxSoFar),arr[i]*minSoFar);
            minSoFar=Math.min(Math.min(arr[i],arr[i]*minSoFar),arr[i]*prevMax);

            maxProduct=Math.max(maxProduct,maxSoFar);
        }
        return maxProduct;
    }
}
```

