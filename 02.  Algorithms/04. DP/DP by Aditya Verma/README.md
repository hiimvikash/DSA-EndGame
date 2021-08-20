**<h1 align="center">DP - Aditya Verma</h1>**

**<h1 align="center">Knapsack pattern</h1>**
# **[1. Introduction To DP .](https://youtu.be/nqowUJzG-iM)**
![Dp1](https://user-images.githubusercontent.com/71629248/129444754-20341388-4964-432c-99bb-eac2c8095208.png)
# **[2. Types of Knapsacks.](https://youtu.be/l02UxPYRmCQ)**
## **Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.**
![Dp2](https://user-images.githubusercontent.com/71629248/129445456-61d9b8dd-22b3-4470-93af-636b9abfe41b.png)
# **[3. Knapsacks 0-1 Recursive.](https://youtu.be/kvyShbFVaY8)**
![Dp3](https://user-images.githubusercontent.com/71629248/129447231-d8bd3e39-1465-449b-84a6-32181d2fe983.png)
# **[4. Knapsacks 0-1 Memoization.](https://youtu.be/fJbIuhs24zQ)**
## **[Problem Link](https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#)**
### **Note : We made 2d array of [n][w] coz they are only changing in every recurssion**
```java
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]=new int [n+1][w+1];
         for(int row[] : dp){
             Arrays.fill(row,-1);
         }
         return knapsack(w,wt,val,n,dp);
    }
    static int knapsack(int w, int wt[], int val[], int n, int dp[][]) 
    { 
         // your code here 
         if(w==0 || n==0) return 0;
         else if(dp[n][w]!=-1) return dp[n][w];
         else if(wt[n-1]<=w){
             return dp[n][w] = Math.max(val[n-1]+knapsack(w-wt[n-1], wt, val, n-1,dp),knapsack(w, wt, val, n-1,dp));
         }
         else
            return dp[n][w] = knapsack(w, wt, val, n-1,dp);
    }
}
```
# **[5. Knapsacks 0-1 DP Tabulation.](https://youtu.be/ntCGbPMeqgg)**
## **[Problem Link](https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#)**
### **Note : We made 2d array of [n][w] coz they are only changing in every recurssion**
![Dp4-01TopD](https://user-images.githubusercontent.com/71629248/129471551-6e36b031-8fea-488a-9cd6-4689e5928956.png)
## **Implemented Code :-**
```java
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here
         // Step 1 : Declare
         int dp[][]=new int[n+1][w+1];
         // Step 2 : Initialization
         for(int c=0; c < w+1; c++)
            dp[0][c] = 0;
         for(int r=0; r < n+1; r++)
            dp[r][0] = 0;
        // Step 3 : coding choice diagram
        
        for(int i=1;i<n+1;i++)
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j)
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                else if(wt[i-1]>j)
                    dp[i][j]=dp[i-1][j];
            }
        return dp[n][w];
    } 
}
```
# **[6. Identification of subproblems  based on Knapsacks 0-1 .](https://youtu.be/iBnWHZmlIyY)**
## Any Problem  with an Array and Knapsack like Target. Treat that array as **wt[]** and target as **W.**
# **[7. Subset Sum Problem.](https://youtu.be/_gPcYovP7wc)**
## Recursive Solution :-
```java
class Solution{
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        if(n==0){
            if(sum==0)
                return true;
            return false;    
        }
        if(arr[n-1]<=sum){
            if(isSubsetSum(n-1,arr,sum-arr[n-1])) return true; // pick
            if(isSubsetSum(n-1,arr,sum)) return true; // notPick
        }
        else
            if(isSubsetSum(n-1,arr,sum)) return true; // notPick
        return false;    
    }
}
```
## DP Memonization :-
## **[Problem Link](https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/#)**
```java
class Solution{
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        int dp[][]=new int[n+1][sum+1];
        for(int row[] : dp){
             Arrays.fill(row,-1);
         }
         if(isSubsetSums(n,arr,sum, dp)==1)
            return true;
        else return false;    
    }
    static int isSubsetSums(int n, int arr[], int sum,int dp[][]){
        // code here
        if(n==0){
            if(sum==0)
                return 1;
            return 0;    
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(arr[n-1]<=sum){
            dp[n][sum]=isSubsetSums(n-1,arr,sum-arr[n-1],dp); // pick
            if(dp[n][sum]==1) return 1;
            dp[n][sum]=isSubsetSums(n-1,arr,sum,dp); // notPick 
            if(dp[n][sum]==1) return 1; 
        }
        else{
            dp[n][sum]=isSubsetSums(n-1,arr,sum,dp); // notPick 
            if(dp[n][sum]==1) return 1; 
        }
        return 0;    
    }
}
```
## DP Tabulation :-
```java
class Solution{
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        // Step 1 : Declaration & Initialization
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int r=0;r<n+1;r++)
            dp[r][0]=true;
        // Step 2 : code your choice diagram
        for(int i=1;i<n+1;i++)
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        return dp[n][sum];    
    }
}
```
# **[8. Partition Equal Subset Sum.](https://youtu.be/UmMh7xp07kY?t=670)**
# **Intution :**
- When sum(arr[]) is odd then equal sum partition is not possible.
- When sum(arr[]) is even then we search for subset with sum=sum/2 **because if subset with sum=sum(arr[])/2 is available then obviously other elements will add up to give sum=sum(arr[])/2.**
- If found return true; else return false;
## Recursive Solution :-
```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        return isSubsetSum(nums.length,nums,sum/2);
    }
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        if(n==0){
            if(sum==0)
                return true;
            return false;    
        }
        if(arr[n-1]<=sum){
            if(isSubsetSum(n-1,arr,sum-arr[n-1])) return true; // pick
            if(isSubsetSum(n-1,arr,sum)) return true; // notPick
        }
        else
            if(isSubsetSum(n-1,arr,sum)) return true; // notPick
        return false;    
    }
}
```
## DP Memonization :-
## **[Problem Link](https://leetcode.com/problems/partition-equal-subset-sum/)**
```java
class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
        for(int ele:arr){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        int dp[][]=new int[arr.length+1][sum+1];
        for(int row[] : dp){
             Arrays.fill(row,-1);
         }
         if(isSubsetSums(arr.length,arr,sum/2, dp)==1)
            return true;
        else return false;    
    }
    static int isSubsetSums(int n, int arr[], int sum,int dp[][]){
        // code here
        if(n==0){
            if(sum==0)
                return 1;
            return 0;    
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(arr[n-1]<=sum){
            dp[n][sum]=isSubsetSums(n-1,arr,sum-arr[n-1],dp); // pick
            if(dp[n][sum]==1) return 1;
            dp[n][sum]=isSubsetSums(n-1,arr,sum,dp); // notPick 
            if(dp[n][sum]==1) return 1; 
        }
        else{
            dp[n][sum]=isSubsetSums(n-1,arr,sum,dp); // notPick 
            if(dp[n][sum]==1) return 1; 
        }
        return 0;    
    }
}
```
## DP Tabulation :-
```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        return isSubsetSum(nums.length,nums,sum/2);
    }
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        // Step 1 : Declaration & Initialization
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int r=0;r<n+1;r++)
            dp[r][0]=true;
        // Step 2 : code your choice diagram
        for(int i=1;i<n+1;i++)
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        return dp[n][sum];    
    }
}
```
# **[9. Count Subset Sums.](https://youtu.be/F7wqWbqYn9g)**
## Recursive Solution:-
```java
static int countSubsetSum(int n, int arr[], int sum){
        // code here
        if(n==0){
            if(sum==0)
                return 1;
            return 0;    
        }
        if(arr[n-1]<=sum){
            return countSubsetSum(n-1,arr,sum-arr[n-1])+countSubsetSum(n-1,arr,sum);
        }
        else
            return countSubsetSum(n-1,arr,sum); // notPick
    }
```
## DP Memonization :-
```java
public static void main(String[] args) {
		int arr[]={1,1,1,1,1};
		int sum=2;
		int n=arr.length;
		int dp[][]=new int[n+1][sum+1];
		for(int row[]:dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(countSubsetSum(n,arr,sum,dp));
	}
static int countSubsetSum(int n, int arr[], int sum,int dp[][]){
        // code here
        if(n==0){
            if(sum==0)
                return 1;
            return 0;    
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(arr[n-1]<=sum){
            return dp[n][sum]= countSubsetSum(n-1,arr,sum-arr[n-1],dp)+ countSubsetSum(n-1,arr,sum,dp);
        }
        else
            return dp[n][sum]= countSubsetSum(n-1,arr,sum,dp); // notPick
}
```
## DP Tabulation :-
```java
static int countSubsetSum(int n, int arr[], int sum){
        int dp[][]=new int[n+1][sum+1];
        for(int row=0;row<n+1;row++) {
        	dp[row][0]=1;
        }
        for(int i=1;i<n+1;i++)
        	for(int j=1;j<sum+1;j++) {
        		if(arr[i-1]<=j) {
        			dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
        		}
        		else dp[i][j]=dp[i-1][j];
        	}
        return dp[n][sum];
    }
```
# **[10. Minimum Subset Sum Difference](https://youtu.be/-GtpxG6l_Mc)**
- ## [**Problem Link**](https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1)
## **Problem Statement :** Partition a set into two subsets such that the difference of subset sums is minimum.
## **Intution :**
- We will find s1 only.
- s1 will lie between 0 to Arraysum/2 and here we will consider maximum s1.
- s2=Arraysum-s1.
- s1 is sum of subset1 and s2 is a sum of subset2.
## Recursive Solution:-
```java
class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    for(int ele:arr) sum+=ele;
	    int s1=-1;
	    for(int i=0;i<=sum/2;i++){
	        if(isSubsetSum(n,arr,i))
	            s1=i;
	    }
	    return Math.abs(s1-(sum-s1));
	}
	static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        if(n==0){
            if(sum==0)
                return true;
            return false;    
        }
        if(arr[n-1]<=sum){
            if(isSubsetSum(n-1,arr,sum-arr[n-1])) return true; // pick
            if(isSubsetSum(n-1,arr,sum)) return true; // notPick
        }
        else
            if(isSubsetSum(n-1,arr,sum)) return true; // notPick
        return false;    
    }
}
```
## DP Memonization :-
```java
class Solution
{

	public int minDifference(int arr[], int n) 
	{ // Your code goes here
	    int sum=0;
	    for(int ele:arr) sum+=ele;
	    // dp initialization
	    int dp[][]=new int[n+1][(sum/2)+1];
        for(int row[] : dp){
             Arrays.fill(row,-1);
         }
        // dp initialization
	    int s1=-1;
	    for(int i=0;i<=sum/2;i++){
	        if(isSubsetSums(n,arr,i,dp)==1)
	            s1=i;
	    }
	    return Math.abs(s1-(sum-s1));
	}
	static int isSubsetSums(int n, int arr[], int sum,int dp[][]){
        // code here
        if(n==0){
            if(sum==0)
                return 1;
            return 0;    
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(arr[n-1]<=sum){
            dp[n][sum]=isSubsetSums(n-1,arr,sum-arr[n-1],dp); // pick
            if(dp[n][sum]==1) return 1;
            dp[n][sum]=isSubsetSums(n-1,arr,sum,dp); // notPick 
            if(dp[n][sum]==1) return 1; 
        }
        else{
            dp[n][sum]=isSubsetSums(n-1,arr,sum,dp); // notPick 
            if(dp[n][sum]==1) return 1; 
        }
        return 0;    
    }
}
```
## DP Tabulation :-
```java
class Solution
{

	public int minDifference(int arr[], int n) 
	{ // Your code goes here
	    int sum=0;
	    for(int ele:arr) sum+=ele;
	    int s1=-1;
	    boolean range[]=isSubsetSum(n,arr,sum/2);
	    for(int i=0;i<range.length;i++){
	        if(range[i])s1=i;
	    }        
	    return (sum-s1)-s1;
	}
	// this () will make a 2d array and return last row.
	static boolean[] isSubsetSum(int n, int arr[], int sum){
        // code here
        // Step 1 : Declaration & Initialization
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int r=0;r<n+1;r++)
            dp[r][0]=true;
        // Step 2 : code your choice diagram
        for(int i=1;i<n+1;i++)
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        return dp[n];    
    }
}
```
# **[11. Count no of subsets with given difference](https://youtu.be/ot_XBHyqpFc)**
## **Intution**
- Let sum of subset 1 be s1 and subset 2 with s2
- s1 - s2 = diff (given)
- s1 + s2=sum of array (logical)
- Therefore adding both eq we get :
- 2s1= diff + sum of array
- s1= (diff + sum of array)/2;
- Problem reduces to find no of subsets with given sum.
- so return countSubsetSum(n,arr,s1); **from 10**
# **[12. Target Sum](https://youtu.be/Hw6Ygp3JBYw)**
### **Q is ditto same as Number 11, way of asking is different.**
## [**Problem Link**](https://leetcode.com/problems/target-sum/)
## DP Memonization :-
```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int ele:nums) sum+=ele;
        if((sum+target)%2!=0) return 0; // case 2 [5,2,2,7,3,7,9,0,2,3] 9, ANS is 0
        int reqSum=(sum+target)/2;
        int dp[][]=new int[nums.length+1][reqSum+1];
		for(int row[]:dp) {
			Arrays.fill(row, -1);
		}
        return countSubsetSum(nums.length,nums,reqSum,dp);
    }
    static int countSubsetSum(int n, int arr[], int sum,int dp[][]){
        // code here
        if(n==0){
            if(sum==0)
                return 1;
            return 0;    
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(arr[n-1]<=sum){
            return dp[n][sum]= countSubsetSum(n-1,arr,sum-arr[n-1],dp)+ countSubsetSum(n-1,arr,sum,dp);
        }
        else
            return dp[n][sum]= countSubsetSum(n-1,arr,sum,dp); // notPick
    }
}
```
<hr>
<hr>

# **[13. Unbounded Knapsack](https://youtu.be/aycn9KO8_Ls)**
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1)
Examples:

- Input : 
    - W = 100
    - val[]  = {1, 30}
    - wt[] = {1, 50}
- Output : 100
### There are many ways to fill knapsack:-
1. 2 instances of 50 unit weight item.
2. 100 instances of 1 unit weight item.
3. 1 instance of 50 unit weight item and 50
   instances of 1 unit weight items.
- **We get maximum value with option 2.**
## DP Memonization :-
```java
class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // code here
         // your code here 
         int dp[][]=new int [n+1][w+1];
         for(int row[] : dp){
             Arrays.fill(row,-1);
         }
         return knapsack(w,wt,val,n,dp);
    }
    static int knapsack(int w, int wt[], int val[], int n, int dp[][]) 
    { 
         // your code here 
         if(w==0 || n==0) return 0;
         else if(dp[n][w]!=-1) return dp[n][w];
         else if(wt[n-1]<=w){
             return dp[n][w] = Math.max(val[n-1]+knapsack(w-wt[n-1], wt, val, n,dp),knapsack(w, wt, val, n-1,dp));
         }
         else
            return dp[n][w] = knapsack(w, wt, val, n-1,dp);
    }
    
}
```
## DP Tabulation :-
```java
class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // your code here
         // Step 1 : Declare
         int dp[][]=new int[n+1][w+1];
         // Step 2 : Initialization
         for(int c=0; c < w+1; c++)
            dp[0][c] = 0;
         for(int r=0; r < n+1; r++)
            dp[r][0] = 0;
        // Step 3 : coding choice diagram
        
        for(int i=1;i<n+1;i++)
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j)
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                else if(wt[i-1]>j)
                    dp[i][j]=dp[i-1][j];
            }
        return dp[n][w];
    }
}
```
# **[14. Rod Cutting](https://youtu.be/aycn9KO8_Ls)**
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/rod-cutting0840/1#)
## This Problem is same as Unbounded Knapsack.
### Here's are the Matchings :-
- W ---> N
- val[] ---> price[]
- wt[] ---> length[] is 1 to N arranged here termed as lt variable which decreaseBy1 always when recursion decrease.
- N ---> N
## DP Memonization :-
```java
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]=new int [n+1][n+1];
         for(int i=0;i<=n;i++){
             for(int j=0;j<=n;j++){
                 dp[i][j]=-1;
             }
         }
        return unknapsack(n,price,n,dp,n);
    }
    static int unknapsack(int l, int val[], int n, int dp[][],int lt) 
    { 
         // your code here 
         if(l==0 || n==0) return 0;
         else if(dp[n][l]!=-1) return dp[n][l];
         else if(lt<=l){
             return dp[n][l] = Math.max(val[n-1]+unknapsack(l-lt,val, n,dp,lt),unknapsack(l,val, n-1,dp,lt-1));
         }
         else
            return dp[n][l] = unknapsack(l,val, n-1,dp,lt-1);
    }
}
```
## DP Tabulation :-
```java
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]=new int[n+1][n+1];
        int l=n;
        int lt=1;
        // main code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<l+1;j++){
                if(lt<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-lt],dp[i-1][j]);
                }
                else dp[i][j]=dp[i-1][j];
            }
            lt++;
        }
        return dp[n][l];   
    }
}
```
# **[15. Coin Change II](https://youtu.be/I4UR2T6Ro3w)**
## [**Problem Link**](https://leetcode.com/problems/coin-change-2)
**Note :** Same as Number 9 **Count Subset Sums.**
## DP Memonization :-
```java
class Solution {
    public int change(int sum, int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+1][sum+1];
		for(int row[]:dp) {
			Arrays.fill(row, -1);
		}
		return countSubsetSum(n,arr,sum,dp);
    }
    static int countSubsetSum(int n, int arr[], int sum,int dp[][]){
        // code here
        if(n==0){
            if(sum==0)
                return 1;
            return 0;    
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(arr[n-1]<=sum){
            return dp[n][sum]= countSubsetSum(n,arr,sum-arr[n-1],dp)+countSubsetSum(n-1,arr,sum,dp);
        }
        else
            return dp[n][sum]= countSubsetSum(n-1,arr,sum,dp); // notPick
    }
}
```
## DP Tabulation :-
```java
class Solution {
    public int change(int sum, int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+1][sum+1];
        for(int row=0;row<n+1;row++) {
        	dp[row][0]=1;
        }
        for(int i=1;i<n+1;i++)
        	for(int j=1;j<sum+1;j++) {
        		if(arr[i-1]<=j) {
        			dp[i][j]=dp[i][j-arr[i-1]]+dp[i-1][j];
        		}
        		else dp[i][j]=dp[i-1][j];
        	}
        return dp[n][sum];
    }
}
```
# **[16. Coin Change I](https://youtu.be/I-l6PBeERuc)**
## [**Problem Link**](https://leetcode.com/problems/coin-change/)
## DP Memonization :-
```java
class Solution {
    public int coinChange(int[] arr, int sum) {
        int n=arr.length;
        int dp[][]=new int[n+1][sum+1];
		for(int row[]:dp) {
			Arrays.fill(row, -1);
		}
        return countSubsetSum(n,arr,sum,dp)==Integer.MAX_VALUE-1 ? -1 : countSubsetSum(n,arr,sum,dp) ;
   }
    static int countSubsetSum(int n, int arr[], int sum,int dp[][]){
        // code here
        if(sum==0)
            return 0; 
        if(n==0){
           return Integer.MAX_VALUE-1;  
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(arr[n-1]<=sum){
            return dp[n][sum]= Math.min(1+countSubsetSum(n,arr,sum-arr[n-1],dp),countSubsetSum(n-1,arr,sum,dp));
        }
        else
            return dp[n][sum]= countSubsetSum(n-1,arr,sum,dp); // notPick
    }
}
```
## DP Tabulation :-
```java
class Solution {
    public int coinChange(int[] arr, int sum) {
        int n=arr.length;
        int dp[][]=new int[n+1][sum+1];
        for(int col=1;col<sum+1;col++) {
        	dp[0][col]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<n+1;i++)
        	for(int j=1;j<sum+1;j++) {
        		if(arr[i-1]<=j) {
        			dp[i][j]=Math.min(1+dp[i][j-arr[i-1]],dp[i-1][j]);
        		}
        		else dp[i][j]=dp[i-1][j];
        	}
        return dp[n][sum]==Integer.MAX_VALUE-1 ? -1 : dp[n][sum];
    }
}
```
<hr>
<hr>
<hr>

**<h1 align="center">LCS pattern</h1>**

# **[17. LCS](https://youtu.be/4dMlCZTONj8)**
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#)
## [**Recursive Solution :-**](https://youtu.be/4Urd0a0BNng)
```java
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int n1, int n2, String s1, String s2)
    {   // your code here
        if(n1==0||n2==0) return 0;
        if(s1.charAt(n1-1)==s2.charAt(n2-1)) return 1+lcs(n1-1,n2-1,s1,s2);
        else return Math.max(lcs(n1,n2-1,s1,s2),lcs(n1-1,n2,s1,s2));
    }
}
```
## [**DP Memonization :-**](https://youtu.be/g_hIx4yn9zg)
**Note :** Size of 2D array depends on the changing variables in recursive calls.
```java
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int row[]:dp) {
    		Arrays.fill(row, -1);
    	}
		return LCS(n1,n2,s1,s2,dp);
    }
    static int LCS(int n1, int n2, String s1, String s2, int dp[][])
    {   // your code here
        if(n1==0||n2==0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        if(s1.charAt(n1-1)==s2.charAt(n2-1))  return dp[n1][n2] = 1+LCS(n1-1,n2-1,s1,s2,dp);
        else return dp[n1][n2] = Math.max(LCS(n1,n2-1,s1,s2,dp),LCS(n1-1,n2,s1,s2,dp));
    }
}
```
## [**DP Tabulation :-**](https://youtu.be/hR3s9rGlMTU)
```java
class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
		return dp[n1][n2];
    }
}
```
#  [**18. LCsubstring**](https://youtu.be/Lj90FqNCIJE)
TCs to consider :-
- s1="BBMQH" s2="QBBQ"
- s1="ABCD" s2="ABC"
- s1="WSS" S2="WS" **VVI**
## Recursive solution :-
```java
static int LCS(int n1, int n2, String s1, String s2,int count)
{   // your code here
	        if(n1==0||n2==0) return count;
	        if(s1.charAt(n1-1)==s2.charAt(n2-1)) 
	        	count= LCS(n1-1,n2-1,s1,s2,count+1);
	        count= Math.max(count,Math.max(LCS(n1,n2-1,s1,s2,0),LCS(n1-1,n2,s1,s2,0)));
	        return count;
}
```
## DP Tabulation :-
```java
class Solution{
    int longestCommonSubstr(String s1, String s2, int n1, int n2){
        // code here
        int dp[][]=new int[n1+1][n2+1];
        int ans=0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                else dp[i][j]=0;
            }
        }
        return ans;
    }
}
```
#  [**19. Print LCS**](https://youtu.be/x5hQvnUcjiM)
```java
static String printlcs(int n1, int n2, String s1, String s2)
{   
        int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int i=n1,j=n2;
        String ans="";
		while(i>0 && j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				ans=s1.charAt(i-1)+ans;
				i--;
				j--;
			}
			else {
				if(dp[i][j-1]>dp[i-1][j]) j--;
				else i--;
			}
		}
		return ans;
}
```
#  [**20. Shortest Common Supersequence**](https://youtu.be/823Grn4_dCQ)
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1)
## Intution :-
- Find LCS
- Minus it with totalStringLength. If you do so you are making sure that common elements occur one's.
```java
class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1,String s2,int n1,int n2)
    {
        //Your code here
        int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return (n1+n2)-dp[n1][n2];
    }
}
```
#  [**21. Print SCS**](https://youtu.be/VDhRg-ZJTuc)
```java
static String printscs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int i=n1,j=n2;
        String ans="";
		while(i>0 && j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				ans=s1.charAt(i-1)+ans;
				i--;
				j--;
			}
			else {
				if(dp[i][j-1]>dp[i-1][j]) {
					ans=s2.charAt(j-1)+ans;
					j--;
				}
				else {
					ans=s1.charAt(i-1)+ans;
					i--;
				}
			}
		}
		while(i>0) {
			ans=s1.charAt(i-1)+ans;
			i--;
		}
		while(j>0) {
			ans=s1.charAt(j-1)+ans;
			j--;
		}
		return ans;
    }
```
#  [**22. Minimum Number of Insertion and Deletion to convert String a to String b**](https://youtu.be/-fx6aDxcWyg)
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1)
## Intution :-
- Find LCS
- Insertion : str2.length()-lcs
- Deletion :  str1.length()-lcs
```java
class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int lcs=lcs(str1.length(),str2.length(),str1,str2);
	    return (str2.length()-lcs)+(str1.length()-lcs); // insertion + deletion
	}
	static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
		return dp[n1][n2];
    }
}
```
#  [**23. Longest Palindromic Subsequence**](https://youtu.be/wuOOOATz_IA)
## [**Problem Link**](https://leetcode.com/problems/longest-palindromic-subsequence/)
## Intution :-
- return LCS(s1,reverse(s1))
```java
class Solution {
    public int longestPalindromeSubseq(String s1) {
        int n=s1.length();
        return lcs(n,n,s1,reverseWord(s1));
    }
    static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
		return dp[n1][n2];
    }
    private static String reverseWord(String str)
    {
        // Reverse the string str
        //Your code here
      char arr[]=str.toCharArray();
      int s=0;
      int e=arr.length-1;
  
      while(s<e){
          char temp=arr[s];
          arr[s]=arr[e];
          arr[e]=temp;
          s++;
          e--;
      }
      return String.valueOf(arr);
  }
}
```
#  [**24. Minimum number of deletions to make a string palindrome**](https://youtu.be/CFwCCNbRuLY)
## **NOTE : Minimum # of deletion=Minimum # of Insertion. this is bcz in deletion we remove single occuring element and in Insertion we try to make that single element into couple by introducing new element.**
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1)
## Intution
- Find LPS
- return n-LPS
- because no. of deletion is inversely propotional to lengthOfPS.
```java
class Solution{
    static int minimumNumberOfDeletions(String s1) {
        //your code here
        int n=s1.length();
        return n-lcs(n,n,s1,reverseWord(s1));
    }
    static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
		return dp[n1][n2];
    }
    private static String reverseWord(String str)
    {
        // Reverse the string str
        //Your code here
      char arr[]=str.toCharArray();
      int s=0;
      int e=arr.length-1;
  
      while(s<e){
          char temp=arr[s];
          arr[s]=arr[e];
          arr[e]=temp;
          s++;
          e--;
      }
      return String.valueOf(arr);
  }
}
```
#  [**25. Longest Repeating Subsequence (LCS with different index)**](https://youtu.be/hbTaCmQGqLg)
## [**Problem Link**](https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1)
## Intution :-
- We make a copy of same string and return **LCS(s,s) with different Index** because if same subsequence will be present then it will obviously occur in different index.
```java
class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        return lcs(str.length(),str.length(),str,str);
    }
    static int lcs(int n1, int n2, String s1, String s2)
    {   int dp[][]=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
		return dp[n1][n2];
    }
}
```