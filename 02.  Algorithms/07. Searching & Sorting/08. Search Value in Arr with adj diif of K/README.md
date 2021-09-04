# [**Searching in an array where adjacent differ by at most k**](https://www.geeksforgeeks.org/searching-array-adjacent-differ-k/)
## A step array is an array of integers where each element has a difference of at most k with its neighbor. Given a key x, we need to find the index value of x if multiple-element exist to return the first occurrence of the key.
![atmostKadjDiff](https://user-images.githubusercontent.com/71629248/132084415-ac81cffd-23e9-416c-8d9f-a10181d4574d.png)

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
        System.out.println("number is " +
                                "not present!");
        return -1;
    }
```
