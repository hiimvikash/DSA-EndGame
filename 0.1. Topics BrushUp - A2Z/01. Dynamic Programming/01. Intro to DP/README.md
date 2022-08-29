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
![](https://lh4.googleusercontent.com/BwLei4kILFynlSL-V4ivRy_OeswgUijuLkPhFq1XeEVQk83XIgLq1MqVWolT4fLqAgIxz3j3TBys45yTmZSiVga-9D_PJSxgYtOsgyQMNf40Yxja90kr50ViVpHzUXjYXmq96Nzv)
### The basic pseudo-code for the problem will be given as:
![](https://lh5.googleusercontent.com/UK4N8ZsaDe1E50UvVoW5QMGpHztH6dHArb8pAQ-prDBSz5ZYAYCYgavuAZXny9WbD1eZOtGNf5_tYo3rmM3TcB5RKKTeWeZ1is1mrSkwr1UbiXfP830F8Y-mkN0Zo5WyyClpTUOe)
### If we draw the recursive tree for n=5, it will be:
![](https://lh6.googleusercontent.com/1yzhsKxugdFd9BWYVLv_SmvKuisHhq51jRo8VYRlJIinu4nWoP6aGlsIP3BWbE0Rb9SUQSuNPs7ZuxdLQIfMKwTMbIvu6o4divTyrjZ60VfXY1S60dpxgXstOSCsWuccy3Ajhkiw)
### If there are two recursive calls inside a function, the program will run the first call, finish its execution and then run the second call. Due to this reason, each and every call in the recursive tree will be executed. This gives the recursive code its exponential time complexity.
## Can we improve on this? The answer is Yes!
![](https://lh3.googleusercontent.com/TYx2Wy_b2i3p7jTkfzML-JjR4zeiptdrE57y3b-vpUaRn0ybU_m9TXqGs-RdObLwy90CB88q4oh_k9TRFLXaovZgsu7EMr5Wa11rq9ryYiz5Z7-ycsjLej3fgMM2tnsPEM3YmVv8)
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
