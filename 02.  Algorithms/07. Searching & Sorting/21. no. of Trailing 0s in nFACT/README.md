# [**172. Factorial Trailing Zeroes**](https://leetcode.com/problems/factorial-trailing-zeroes/)
## Given an integer n, return the number of trailing zeroes in n!.
# Thought Process :-
## The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5. If we can count the number of 5s and 2s, our task is done. Consider the following examples.
## n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So a count of trailing 0s is 1.
## n = 11: There are two 5s and eight 2s in prime factors of 11! (2 8 * 34 * 52 * 7). So the count of trailing 0s is 2.
## We can easily observe that the number of 2s in prime factors is always more than or equal to the number of 5s. So if we count 5s in prime factors, we are done. 
## **How to count the total number of 5s in prime factors of n!?**

## [**Video Reference**](https://youtu.be/fx8rUY_iIms)
```java
class Solution {
    public int trailingZeroes(int n) {
        // here we will count number of 5s
        int ans=0;
        int p=5;
        while((n/p)>0){
            ans+=n/p;
            p*=5;
        }
        return ans;
    }
}
```
