# 1. [Subset Sum Equal To K](https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0)

## Reccursive
```java
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        return ss2k(arr,n,k);
    }
    public static boolean ss2k(int arr[], int n, int k){
        if(n==0){
            if(k==0) return true;
            return false;
        }
        if(arr[n-1]<=k){
            if(ss2k(arr,n-1,k-arr[n-1])) return true;
        }
        if(ss2k(arr,n-1,k)) return true;
        
        return false;
    }
}

```

## Memonization

```java
import java.util.*;
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int dp[][] = new int[n+1][k+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        
        return ss2k(arr, n, k, dp)==1? true :false;
    }
    public static int ss2k(int arr[], int n, int k, int dp[][]){
        if(n==0){
            if(k==0) return 1;
            return 0;
        }
        if(dp[n][k]!=-1) return dp[n][k];
        
        if(arr[n-1]<=k){
            if(ss2k(arr, n-1, k-arr[n-1], dp)==1) return dp[n][k] = 1;
        }
        if(ss2k(arr, n-1, k, dp)==1) return dp[n][k] = 1;
        
        return dp[n][k] = 0;
    }
}
```

## Tabulation
```java
import java.util.*;
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int dp[][] = new int[n+1][k+1];
        // initialization k==0 return 1
        for(int i=0; i<=n; i++) dp[i][0] = 1;
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=k; j++){
                if(arr[i-1]<=j){
                    if(dp[i-1][j-arr[i-1]]==1) dp[i][j] = 1;
                    else if(dp[i-1][j]==1) dp[i][j] = 1;
                }
                else if(dp[i-1][j]==1) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }
        
        return dp[n][k]==1? true :false;
    }
}
```



## Space Optimized

```java
import java.util.*;
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int ur[]=new int[k+1]; ur[0] = 1;
        
        for(int i = 1; i<=n; i++){
            int curr[]=new int[k+1];
            curr[0]=1;
            for(int j = 1; j<=k; j++){
                if(arr[i-1]<=j){
                    if(ur[j-arr[i-1]]==1) curr[j] = 1;
                    else if(ur[j]==1) curr[j] = 1;
                }
                else if(ur[j]==1) curr[j] = 1;
                else curr[j] = 0;
            }
            ur=curr;
        }
        
        return ur[k]==1? true :false;
    }
}
```
[Reference](https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/)

# [2. 416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)

## Space optimization**
## **Solution :-**
### This question is a slight modification of the problem discussed in Subset-sum equal to target. We need to partition the array(say S) into two subsets(say S1 and S2). According to the question:

- ### Sum of elements of S1 + sum of elements of S2 = sum of elements of S.
- ### Sum of elements of S1 = sum of elements of S2.
- ### These two conditions imply that S1 = S2 = (S/2). 

### Now, 

### - If S (sum of elements of the input array) is odd , there is no way we can divide it into two equal halves, so we can simply return false.
### - If S is even, then we need to find a subsequence in the input array whose sum is equal to S/2 because if we find one subsequence with sum S/2, the remaining elements sum will be automatically S/2. So, we can partition the given array. Hence we return true.
```java
class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int e : arr) sum+=e;
        
        if(sum%2!=0) return false;
        return subsetSumToK(n,sum/2,arr);
    }
    public boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int ur[]=new int[k+1]; ur[0] = 1;
        
        for(int i = 1; i<=n; i++){
            int curr[]=new int[k+1];
            curr[0]=1;
            for(int j = 1; j<=k; j++){
                if(arr[i-1]<=j){
                    if(ur[j-arr[i-1]]==1) curr[j] = 1;
                    else if(ur[j]==1) curr[j] = 1;
                }
                else if(ur[j]==1) curr[j] = 1;
                else curr[j] = 0;
            }
            ur=curr;
        }
        
        return ur[k]==1? true :false;
    }
}
```
[Reference](https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/)

# [3. Partition Set Into 2 Subsets With Min Absolute Sum Diff](https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?)

### The Intuition is : 
- The value of S1 & S2 will lie btw :-
0------------------------------------------ArraySum
- the minimum answer will be generated when S1 & S2 lies
close to each other in above line.
- we only need to find valid S1.
- S2 can be calculated as ArraySum-S1

## Now, try figuring out the meaning of Tabulation in Q1(Subset Sum Equal To K)
- if Array of size 5 and k = 12
- what does dp[4][10] means ?
- boolean value in dp[4][10] signifies whether target sum 10 is possible or not if Array Size is till 4.
- simillarly last row dp[n-1][0....k] will say whether particular sum from 0 to ArraySum is possible or not. 
## Space Optimized
```java
public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
        int k = 0; for(int e : arr) k+=e;
        // Q1 sol :-
        int ur[]=new int[k+1]; ur[0] = 1;
        
        for(int i = 1; i<=n; i++){
            int curr[]=new int[k+1];
            curr[0]=1;
            for(int j = 1; j<=k; j++){
                if(arr[i-1]<=j){
                    if(ur[j-arr[i-1]]==1) curr[j] = 1;
                    else if(ur[j]==1) curr[j] = 1;
                }
                else if(ur[j]==1) curr[j] = 1;
                else curr[j] = 0;
            }
            ur=curr;
        }
        // Q1 sol
        
        int min = Integer.MAX_VALUE;
        for(int s1=0; s1<=k; s1++){
            if(ur[s1]==1){
                min = Math.min(min, Math.abs(s1 - (k-s1)));
            }
        }
        
        return min;
	}
}
```
[Reference](https://takeuforward.org/data-structure/partition-set-into-2-subsets-with-min-absolute-sum-diff-dp-16/)

# [4. Count subset with sum k](https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532?)
## memonization
```java
import java.util.*;
public class Solution {
    public static int findWays(int num[], int k) {
        // Write your code here..
        int n = num.length;
        int dp[][] = new int[n+1][k+1];
        for(int d[] : dp) Arrays.fill(d,-1);
        
        return fun(num,n,k,dp);
    }
    public static int fun(int arr[], int n, int k, int dp[][]){
        if(n==0){
            if(k==0) return 1;
            return 0;
        }
        if(dp[n][k]!=-1) return dp[n][k];
        int p = 0, np=0;
        if(arr[n-1]<=k){
             p = fun(arr,n-1,k-arr[n-1],dp);
        }
        np = fun(arr,n-1,k,dp) ;
        
        return dp[n][k] = p+np;
    }
}
```
## Tabulation
```java
import java.util.*;
public class Solution {
    public static int findWays(int arr[], int k) {
        // Write your code here..
        int n = arr.length;
        int dp[][] = new int[n+1][k+1];
        // initialization k==0 return 1
        for(int i=0; i<=n; i++) dp[i][0] = 1;
        
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=k; j++){
                int p = 0, np=0;
                if(arr[i-1]<=j){
                     p = dp[i-1][j-arr[i-1]];
                }
                np = dp[i-1][j];
                
                dp[i][j] = p+np;
            }
        }
        return dp[n][k];
    }
}
```
## space optimization
```java
import java.util.*;
public class Solution {
    public static int findWays(int arr[], int k) {
        // Write your code here..
        int n = arr.length;
        int ur[] = new int[k+1];
        ur[0] = 1;
        
        
        for(int i = 1; i<=n; i++){
            int curr[]=new int[k+1];
            curr[0] = 1;
            for(int j = 1; j<=k; j++){
                int p = 0, np=0;
                if(arr[i-1]<=j){
                     p = ur[j-arr[i-1]];
                }
                np = ur[j];
                
                curr[j] = p+np;
            }
            ur = curr;
        }
        return ur[k];
    }
}
```

# [5. Partitions With Given Difference](https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628?)
# Intution
- Let sum of subset 1 be s1 and subset 2 with s2
- s1 - s2 = diff (given)
- s1 + s2=sum of array (logical)
Therefore adding both eq we get :
- 2s1= diff + sum of array
- s1= (diff + sum of array)/2;
Problem reduces to find no of subsets with given sum.
so return countSubsetSum(n,arr,s1); from 10
 ## memonization
 ```java
import java.util.*;
public class Solution {
    static int mod =(int)(Math.pow(10,9)+7);
	public static int countPartitions(int n, int d, int[] nums) {
		// Write your code here.
        int sum=0;
        for(int ele:nums) sum+=ele;
        if((sum+d)%2!=0) return 0; // case 2 [5,2,2,7,3,7,9,0,2,3] 9, ANS is 0
        int reqSum=(sum+d)/2;
        int dp[][]=new int[n+1][reqSum+1];
        for(int row[]:dp) {
            Arrays.fill(row, -1);
        }
        return fun(nums,n,reqSum,dp);
        
	}
    public static int fun(int arr[], int n, int k, int dp[][]){
        if(n==0){
            if(k==0) return 1;
            return 0;
        }

        if(dp[n][k]!=-1) return dp[n][k];
        int p = 0, np=0;
        if(arr[n-1]<=k){
             p = fun(arr,n-1,k-arr[n-1],dp);
        }
        np = fun(arr,n-1,k,dp) ;
        
        return dp[n][k] = (p+np)%mod;
    }
}
 ```
# [6. 0 1 Knapsack](https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542?)

## Memonization
```java
import java.util.*;
public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
         int dp[][]=new int [n+1][maxWeight+1];
         for(int row[] : dp){
             Arrays.fill(row,-1);
         }
            return fun(weight,value,n,maxWeight,dp);
     }
    static int fun(int wt[], int val[], int n, int w, int dp[][]){
        if(n==0 || w==0) return 0;
        
        int p=0,np=0;
        if(dp[n][w]!=-1) return dp[n][w];
        if(wt[n-1]<=w){
            p = val[n-1] + fun(wt,val,n-1,w-wt[n-1],dp);
        }
        np = fun(wt,val,n-1,w,dp);
        return dp[n][w] = Math.max(p,np);
    }
}
```
## Tabulation
```java
import java.util.*;
public class Solution{
    static int knapsack(int[] wt, int[] val, int n, int w) {
         int dp[][]=new int [n+1][w+1];
         for(int i = 1; i<=n; i++){
             for(int j = 1; j<=w; j++){
                 int p = 0, np=0;
                 if(wt[i-1]<=j) p = val[i-1] + dp[i-1][j-wt[i-1]];
                 np = dp[i-1][j];
                 
                 dp[i][j] = Math.max(p,np);
             }
         }
            return dp[n][w];
     }
}
```
## Space Optimized
```java
import java.util.*;
public class Solution{
    static int knapsack(int[] wt, int[] val, int n, int w) {
         int ur[]=new int[w+1];
         for(int i = 1; i<=n; i++){
             int curr[]=new int[w+1];
             for(int j = 1; j<=w; j++){
                 int p = 0, np=0;
                 if(wt[i-1]<=j) p = val[i-1] + ur[j-wt[i-1]];
                 np = ur[j];
                 
                 curr[j] = Math.max(p,np);
             }
             ur = curr;
         }
            return ur[w];
     }
}
```


# [7. Coin Change](https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?)


## Recursion
```java
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int ans = fun(num,num.length,x);
        return ans>=(int)Math.pow(10,9)? -1 : ans;
    }
    static int fun(int arr[], int n, int t){
        if(n==1){
            if(t%arr[0]==0) return t/arr[0];
            return (int)Math.pow(10,9);
        }
        int pp = Integer.MAX_VALUE, pnp = Integer.MAX_VALUE, np = Integer.MAX_VALUE;
        if(arr[n-1]<=t){
            pnp = 1 + fun(arr,n,t-arr[n-1]);
            pp = 1 + fun(arr,n-1,t-arr[n-1]);
        }
        np = fun(arr,n-1,t);
        
        return Math.min(pnp, Math.min(pp,np));
    }

}
```

## Memonization - I
```java
import java.util.*;
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n = num.length;
        
        int dp[][]=new int[n+1][x+1];
        for(int d[] :dp) Arrays.fill(d,-1);
        
        int ans = fun(num,n,x,dp);
        return ans>=(int)Math.pow(10,9)? -1 : ans;
    }
    static int fun(int arr[], int n, int t, int dp[][]){
        if(n==1){
            if(t%arr[0]==0) return t/arr[0];
            return (int)Math.pow(10,9);
        }
        if(dp[n][t]!=-1) return dp[n][t];
        
        int pp = Integer.MAX_VALUE, pnp = Integer.MAX_VALUE, np = Integer.MAX_VALUE;
        if(arr[n-1]<=t){
            pnp = 1 + fun(arr,n,t-arr[n-1],dp); // pick NOTPASS
            pp = 1 + fun(arr,n-1,t-arr[n-1],dp); // pick PASS [12,1,4,2] t = 6
        }
        np = fun(arr,n-1,t,dp); // notPick
        
        return dp[n][t] = Math.min(pnp, Math.min(pp,np));
    }

}
```

## Memonization - II
```java
import java.util.*;
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n = num.length;
        
        int dp[][]=new int[n+1][x+1];
        for(int d[] :dp) Arrays.fill(d,-1);
        
        int ans = fun(num,n,x,dp);
        return ans>=(int)Math.pow(10,9)? -1 : ans;
    }
    static int fun(int arr[], int n, int t, int dp[][]){
        if(n==1){
            if(t%arr[0]==0) return t/arr[0];
            return (int)Math.pow(10,9);
        }
        if(dp[n][t]!=-1) return dp[n][t];
        
        int pnp = Integer.MAX_VALUE, np = Integer.MAX_VALUE;
        np = fun(arr,n-1,t,dp); // notPick
        if(arr[n-1]<=t){
            pnp = 1 + fun(arr,n,t-arr[n-1],dp); // pick NOTPASS
        }
        return dp[n][t] = Math.min(pnp, np);
    }

}
```
## Tabulation
```java
import java.util.*;
public class Solution {
    public static int minimumElements(int arr[], int t) {
        // Write your code here..
        int n = arr.length;
        
        int dp[][]=new int[n+1][t+1];
        for(int j = 0; j<=t; j++){
            if(j%arr[0]==0) dp[1][j] = j/arr[0];
            else dp[1][j] = (int)Math.pow(10,9); 
        }
        
        
        for(int i=2; i<=n; i++){
            for(int j=1; j<=t; j++){
                int pnp = Integer.MAX_VALUE, np = Integer.MAX_VALUE;
                np = dp[i-1][j]; // notPick
                if(arr[i-1]<=j){
                    pnp = 1 + dp[i][j-arr[i-1]]; // pick NOTPASS
                }
                
                dp[i][j] = Math.min(np,pnp);
            }
        }
        return dp[n][t]>=(int)Math.pow(10,9)? -1 : dp[n][t];
    }
}
```

## Space Optimization
```java
import java.util.*;
public class Solution {
    public static int minimumElements(int arr[], int t) {
        // Write your code here..
        int n = arr.length;
        
        int ur[]=new int[t+1];
        for(int j = 0; j<=t; j++){
            if(j%arr[0]==0) ur[j] = j/arr[0];
            else ur[j] = (int)Math.pow(10,9); 
        }
        
        
        for(int i=2; i<=n; i++){
            int curr[]=new int[t+1];
            for(int j=1; j<=t; j++){
                int pnp = Integer.MAX_VALUE, np = Integer.MAX_VALUE;
                np = ur[j]; // notPick
                if(arr[i-1]<=j){
                    pnp = 1 + curr[j-arr[i-1]]; // pick NOTPASS
                }
                
                curr[j] = Math.min(np,pnp);
            }
            ur = curr;
        }
        return ur[t]>=(int)Math.pow(10,9)? -1 : ur[t];
    }
}
```
[Reference](https://takeuforward.org/data-structure/minimum-coins-dp-20/)
