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
## 1. After seeing all the 3 example I say output is : ```Math.sqrt(N-1)```
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
- Now I say ```sqrt(X)``` by using above array = ```floor(X)+1```
![sqrtxBS](https://user-images.githubusercontent.com/71629248/131823358-9a68f47e-65e5-4cb0-858d-9fd614655be5.png)
### **So By seeing thought1 we can say we will find out the ```sqrt(N-1)``` by this concept of ```floor(N-1)+1```.** 
- ## Now we see Array is Not Given How we will find floor from array ?
    1. value in any Index ```i = Math.pow(i+1,2)``` agree ?
    2. we will use the concept of infinite sorted array to find rangeIndex of our key between start and end.
```java
class Solution {
    static int countSquares(int N) {
        // code here
        // return (int)Math.sqrt(N-1);
        // where does this N-1 lies find this out using Infinite array concept
        int key=N-1;
        int start = 0, end = 1;
        while(key>Math.pow(end+1,2)){
            int size=end-start+1;
            size=size*2;
            start=end+1;
            end=end+size;
        }
        // Now my start and end is ready and my key lies between them
        return findFloor(start,end+1,key)+1;
    }
    private static int findFloor(int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = (int)Math.pow(mid+1,2);

            if (midVal<key){
                start = mid + 1;
            }
                
            else if (midVal>key)
                end = mid - 1;
            else
                return mid; // key found
        }
        return end;  
    }
    
}
```    
# [**Similar Q in Leetcode : Sqrt(X)**](https://leetcode.com/problems/sqrtx/)
![bssqrt](https://user-images.githubusercontent.com/71629248/131841933-66a63127-c80d-4e6e-be89-be3f062f5745.png)
```java
class Solution {
    public int mySqrt(int N) {
        if(N==1) return 1;
        int low = 1, high = N/2; int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid <= N/mid) {ans = mid; low = mid+1;} // same as mid*mid <= N
            else high = mid-1;
        }
        return ans;
    }
}
```


