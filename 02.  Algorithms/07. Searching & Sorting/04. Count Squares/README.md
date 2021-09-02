# [**Count Squares**](https://practice.geeksforgeeks.org/problems/count-squares3649/1#)

## Consider a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on. You are given a number N, you have to output the number of integers less than N in the sample space S.
**Basically, count number of Perfect square less than N**
```
Example 1:
Input :
N = 9
Output:
2
Explanation:
1 and 4 are the only Perfect Squares
less than 9. So, the Output is 2.
```
```
Example 2:
Input :
N = 3
Output:
1
Explanation:
1 is the only Perfect Square
less than 3. So, the Output is 1.
```
```
Example 3:
Input :
N = 17
Output:
4
Explanation:
1, 4, 9, 16 this all are the perfect square less than 17
```
# Thought process :-
## 1. After seeing all the 3 example I say output is : Math.sqrt(N-1)
```java
class Solution {
    static int countSquares(int N) {
        // code here
        return (int)Math.sqrt(N-1);
    }
}
```
## 2. Now Try to see Array : 
```
 0  1  2   3  4   5   6   7   8    9
[1, 4, 9, 16, 25, 36, 49, 64, 81, 100....]
```

- ## [1, 4, 9, 16, 25, 36, 49, 64, 81, 100....]
- This is a Infinite sorted array of Squares.
- Now I say sqrt(X) in above array = floor(X)+1
![sqrtxBS](https://user-images.githubusercontent.com/71629248/131822907-f0a31980-50d1-4db3-9f34-e485a1c894e2.png)
![sqrtxBS](https://user-images.githubusercontent.com/71629248/131823358-9a68f47e-65e5-4cb0-858d-9fd614655be5.png)



