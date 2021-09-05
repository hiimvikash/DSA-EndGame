# [**198. House Robber**](https://leetcode.com/problems/house-robber/)
# Thought Process :-
## 1. Think Recurrsively
A robber has 2 options: 
- a) rob current house.
- b) don't rob current house.
1. If Option A is selected then after robbing current house he will move ahead by 2 position.
2. If Option B is selected then he will move ahead by 1 position.
## Base Case : when N<1 then ANS is Zero
```java
int rob(int arr[],int n){
    if(n<1) return 0;
    return Math.max(arr[n-1]+rob(arr,n-2),rob(arr,n-1));
}
```
## 2. Optimise reccursive code using memonization
```java
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return rob(nums,n,dp);
    }
    int rob(int arr[],int n, int dp[]){
        if(n<1) return 0;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=Math.max(arr[n-1]+rob(arr,n-2,dp),rob(arr,n-1,dp));
    }
}
```
**Here TC - O(N) and SC - O(N) and Stack Space - O(N)**
## 3. Optimise Memonised code using tabulation
```java
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        // intialise 
        dp[0]=0; dp[1]=nums[0];
        for(int i=2;i<=n;i++){ // here i signifies n
           dp[i]=Math.max(nums[i-1]+dp[i-2],dp[i-1]); 
        }
        return dp[n];
    }
}
```
**Here TC - O(N) and SC - O(N)**