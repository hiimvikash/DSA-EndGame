# **Introduction to DP** <img src="https://media.giphy.com/media/eLp4FA7tAMi2yBwATY/giphy.gif" width="90">

## Dynamic Programming can be described as storing answers to various sub-problems to be used later whenever required to solve the main problem

### The two common dynamic programming approaches are:

- Memoization: Known as the “top-down” dynamic programming, usually the problem is solved in the direction of the main problem to the base cases.
- Tabulation: Known as the “bottom-up ” dynamic programming, usually the problem is solved in the direction of solving the base cases to the main problem

<hr>

# WHY DP ?
## We will be using the example of Fibonacci numbers here. The following series is called the Fibonacci series: 0,1,1,2,3,5,8,13,21,…

**We need to find the nth Fibonacci number, where n is based on a 0-based index.**

# Solution

### As every number is equal to the sum of the previous two terms, the recurrence relation can be written as:
![image](https://user-images.githubusercontent.com/71629248/187250848-8dfcdfb8-5de7-4439-85f3-0c4502d894c8.png)

### The basic pseudo-code for the problem will be given as:
![image](https://user-images.githubusercontent.com/71629248/187250901-c39c1bf6-49a1-4cf1-9807-2e7aa724bf9c.png)

### If we draw the recursive tree for n=5, it will be:
![image](https://user-images.githubusercontent.com/71629248/187250991-302c2bae-9bfa-402a-9652-2b8bf1b6ba6c.png)

### If there are two recursive calls inside a function, the program will run the first call, finish its execution and then run the second call. Due to this reason, each and every call in the recursive tree will be executed. This gives the recursive code its exponential time complexity.
## Can we improve on this? The answer is Yes!
![image](https://user-images.githubusercontent.com/71629248/187251037-53201dab-0569-491a-8183-d7fd80339b1f.png)
### We want to compute f(2) as the second call from f(4), but in the recursive tree we had already computed f(2) once (in the first recursive call of f(3) ) Similar is the case with f(3), therefore if we somehow store these values, the first time we calculated it then we can simply find its value in constant time whenever we need it. This technique is called Memoization. Here the cases marked in yellow are called overlapping sub-problems and we need to solve them only once during the code execution.

```java
// memonization
static int fibn(int n, int dp[]){
	    if(n==0 || n==1) return n;
	    if(dp[n]!=0) return dp[n];
	    
	    return dp[n]=fibn(n-1,dp)+fibn(n-2,dp);
	}


	// Tabulation :-
	static int fibn(int n){
	    int dp[]=new int[n+1];
	    dp[0]=0;
	    dp[1]=1;
	    
	    for(int i=2;i<=n;i++){
	        dp[i]=dp[i-1]+dp[i-2];
	    }
	    return dp[n];
	}
```
### Space optimized 
```java
static int fibn(int n){
	    if(n==0 || n==1) return n;
	    int prev2=0;
	    int prev=1;
	    int c=0;
	    for(int i=2;i<=n;i++){
	        c=prev2+prev;
	        prev2=prev;
	        prev=c;
	    }
	    return c;
	}
```
