**<h1 align="center">DP - Aditya Verma</h1>**
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
# **[5. Knapsacks 0-1 Top-Down.](https://youtu.be/ntCGbPMeqgg)**
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
## DP Top-Down :-
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
## DP Top-Down :-
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