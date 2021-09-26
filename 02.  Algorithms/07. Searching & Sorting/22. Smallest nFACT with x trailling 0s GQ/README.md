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

# [**Smallest factorial number**](https://practice.geeksforgeeks.org/problems/smallest-factorial-number5929/1#)
## Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.

5!  has 1 trailing zeroes 
[All numbers from 6 to 9
 have 1 trailing zero]

10! has 2 trailing zeroes
[All numbers from 11 to 14
 have 2 trailing zeroes]

15! to 19! have 3 trailing zeroes

20! to 24! have 4 trailing zeroes

25! to 29! have 6 trailing zeroes
### We can notice that, the maximum value whose factorial contain n trailing zeroes is 5*n. So, to find minimum value whose factorial contains n trailing zeroes, use binary search on range from 0 to 5*n.
```java
class Solution
{
    int findNum(int n)
    {
        if(n==1) return 5;
        int low=0;
        int high=5*n;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(midPossibleAns(mid,n)){
                ans=mid;
                high=mid-1; // find smallest number
            }
            else low=mid+1;
        }
        return ans;
    }
    public boolean midPossibleAns(int n, int count) {
        // here we will count number of 5s
        int ans=0;
        int p=5;
        while((n/p)>0){
            ans+=n/p;
            p*=5;
        }
        return ans>=count; // atleast 'count' trailling 0s
    }
}
```