# [Minimum Height - II GQ](https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1#)

## Step 1 : [**Understand the corner cases.**](https://youtu.be/o9WG7t6EKZo)

## Step 2 : **See my code and check for different TestCases given below.**

# Test Cases
**Note : Dry Running this 3 TCs will cover all the corner cases and will make the code more clear.**

- ## TCs 1
  **[1, 2, 3, 4], k=5** **#ANS1**
- ## TCs 2
  **[1, 5, 8, 10], k=2** **#ANS2**
- ## TCs 3
  **[2, 6, 3, 4, 7, 2, 10, 3, 2, 1], k=5** **ANS is 7**

# My Code

```java
class Solution {
    int get MinDiff(int[] arr, int n, int k) {

        Arrays.sort(arr); // justMD lies for adjacent element
        int ans=arr[n-1] - arr[0]; // this will be ans when k > allArrayElements #ANS1
    /**
     Our main aim from here is to decrease the range btw max and min. So answer will be more favourable when newMax and newMin are lieing towards the center of array.
     **/

        int big=arr[n-1]-k; // this will become newMax only if there is no newMax lieing towards center of array.
        int small=arr[0]+k; // this will become newMin only if there is no newMin lieing towards center of array.
        // big - small #ANS2

        // Now we move to find newMax and newMin lieing towards center of array. If not found then #ANS2 or #ANS1 will be return.
        int newMax,newMin; // this are the newMax & newMin
        for(int i=1; i<n; i++){
            if(arr[i] >= k){
                newMax=Math.max(arr[i-1]+k,big);
                newMin=Math.min(arr[i]-k,small);

                ans=Math.min(ans,newMax-newMin);
            }
        }
        return ans;
    }
}
```
