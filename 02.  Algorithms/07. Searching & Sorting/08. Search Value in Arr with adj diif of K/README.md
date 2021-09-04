# [**Majority Element**](https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1#)
## Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.

```java
static int search(int arr[], int n,
                            int x, int k)
    {
         
        // Traverse the given array starting
        // from leftmost element
        int i = 0;
         
        while (i < n) {
             
            // If x is found at index i
            if (arr[i] == x)
                return i;
 
            // Jump the difference between
            // current array element and x
            // divided by k We use max here
            // to make sure that i moves
            // at-least one step ahead.
            i = i + Math.max(1, Math.abs(arr[i]
                                      - x) / k);
        }
```