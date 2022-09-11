# 1. [Longest Common Subsequence](https://www.codingninjas.com/codestudio/problems/longest-common-subsequence_624879)

## Memonization

```java
import java.util.*;
public class Solution {

	public static int lcs(String s1, String s2) {
		//Your code goes here
        int n1 = s1.length(); int n2 = s2.length();
        
        int dp[][]=new int[n1+1][n2+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        
        return fun(s1,s2,n1,n2,dp);
    }
    static int fun(String s1, String s2, int n1, int n2, int dp[][]){
        if(n1<=0 || n2<=0) return 0;
        
        if(dp[n1][n2]!=-1) return dp[n1][n2];
            
        if(s1.charAt(n1-1)==s2.charAt(n2-1)) return dp[n1][n2] = 1 + fun(s1,s2,n1-1,n2-1,dp);
        else return dp[n1][n2] = Math.max(fun(s1,s2,n1-1,n2,dp), fun(s1,s2,n1,n2-1,dp));
    }

}
```

## Tabulation
```java
import java.util.*;
public class Solution {

	public static int lcs(String s1, String s2) {
		//Your code goes here
        int n1 = s1.length(); int n2 = s2.length();
        
        int dp[][]=new int[n1+1][n2+1];
        for(int i = 1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n1][n2];
    }
}
```



## Space Optimized

```java
import java.util.*;
public class Solution {

	public static int lcs(String s1, String s2) {
		//Your code goes here
        int n1 = s1.length(); int n2 = s2.length();
        
        int ur[]=new int[n2+1];
        for(int i = 1; i<=n1; i++){
            int curr[]=new int[n2+1];
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) curr[j] = 1 + ur[j-1];
                else curr[j] = Math.max(ur[j], curr[j-1]);
            }
            ur=curr;
        }
        
        return ur[n2];
    }
}
```
[Reference](https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/)






















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
## Memonization - II
```java
import java.util.*;
public class Solution {
    public static int findWays(int arr[], int tar) {
        // Write your code here..
        int n = arr.length;
        int dp[][]=new int[n+1][tar+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        
        return fun(arr,tar,n,dp);
    }
    static int fun(int arr[], int tar, int n, int dp[][]){
        if(n==1){
            if(tar==0 && arr[0]==0) return 2;
            if(tar==0 || tar==arr[0]) return 1;
            return 0;
        }
        if(dp[n][tar]!=-1) return dp[n][tar];
        int p = 0, np = 0;
        if(arr[n-1]<=tar){
            p = fun(arr,tar-arr[n-1],n-1,dp);
        }
        np = fun(arr,tar,n-1,dp);
        
        return dp[n][tar] = p+np;
    }
}
```
## Tabulation
```java
import java.util.*;
public class Solution {
    public static int findWays(int arr[], int tar) {
        int n = arr.length;
        int dp[][]=new int[n+1][tar+1];
        // initialisation
        if(arr[0]==0) dp[1][0] = 2;
        else dp[1][0] = 1;

        if(arr[0]!=0  && arr[0]<=tar) dp[1][arr[0]] = 1;
//         for(int j=1; j<=tar; j++){
//             if(j==arr[0]) dp[1][j] =1;
//         }
        
        
        for(int i=2; i<=n; i++){
            for(int j = 0; j<=tar; j++){
                int p=0, np=0;
                if(arr[i-1]<=j){
                    p  = dp[i-1][j-arr[i-1]];
                }
                np = dp[i-1][j];
                
                dp[i][j] = p+np;
            }
        }
        
        return dp[n][tar];
    }
}
```
## space optimization
```java
import java.util.*;
public class Solution {
    public static int findWays(int arr[], int tar) {
        int n = arr.length;
        int ur[]=new int[tar+1];
        // initialisation
        if(arr[0]==0) ur[0] = 2;
        else ur[0] = 1;

        if(arr[0]!=0  && arr[0]<=tar) ur[arr[0]] = 1;
//         for(int j=1; j<=tar; j++){
//             if(j==arr[0]) dp[1][j] =1;
//         }
        
        
        for(int i=2; i<=n; i++){
            int curr[]=new int[tar+1];
            for(int j = 0; j<=tar; j++){
                int p=0, np=0;
                if(arr[i-1]<=j){
                    p  = ur[j-arr[i-1]];
                }
                np = ur[j];
                
                curr[j] = p+np;
            }
            ur=curr;
        }
        
        return ur[tar];
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
so return countSubsetSum(n,arr,s1);
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


# [8. Target Sum](https://www.codingninjas.com/codestudio/problems/target-sum_4127362?)
## -  Same as ```5. Partition with given difference```
```java
public class Solution {
    public static int targetSum(int n, int target, int[] arr) {
    	// Write your code here.
        int sum=0;
        for(int ele:arr) sum+=ele;
        if((sum+target)%2!=0) return 0; // case 2 [5,2,2,7,3,7,9,0,2,3] 9, ANS is 0
        int reqSum=(sum+target)/2;
        
        
        
        int ur[]=new int[reqSum+1];
        // initialisation
        if(arr[0]==0) ur[0] = 2;
        else ur[0] = 1;

        if(arr[0]!=0  && arr[0]<=reqSum) ur[arr[0]] = 1;
//         for(int j=1; j<=tar; j++){
//             if(j==arr[0]) dp[1][j] =1;
//         }
        
        
        for(int i=2; i<=n; i++){
            int curr[]=new int[reqSum+1];
            for(int j = 0; j<=reqSum; j++){
                int p=0, np=0;
                if(arr[i-1]<=j){
                    p  = ur[j-arr[i-1]];
                }
                np = ur[j];
                
                curr[j] = p+np;
            }
            ur=curr;
        }
        
        return ur[reqSum];
    }
}
```

# [9.  Coin Change - II](https://www.codingninjas.com/codestudio/problems/ways-to-make-coin-change_630471)

## Memonization
```java
import java.util.*;
public class Solution {

	public static long countWaysToMakeChange(int arr[], int tar){
        //write your code here
        int n = arr.length;
        long dp[][]=new long[n+1][tar+1];
         for(long d[]:dp) Arrays.fill(d,-1);
        
        return fun(arr,n,tar,dp);
	}
    static long fun(int arr[], int n, int t, long dp[][]){
        if(n==1){
            if(t%arr[0]==0) return 1;
            return 0;
        }
        if(n==0){
            if(t==0) return 1;
            return 0;
        }
        if(dp[n][t]!=-1) return dp[n][t];
        long np = fun(arr,n-1, t, dp);
        long p=0;
        if(arr[n-1]<=t){
            p = fun(arr,n,t-arr[n-1], dp);
        }
        return dp[n][t] = p + np;
    }
}
```

## Tabulation
```java
import java.util.*;
public class Solution {

	public static long countWaysToMakeChange(int arr[], int tar){
        //write your code here
        int n = arr.length;
        long dp[][]=new long[n+1][tar+1];
        for(int j=0; j<=tar; j++){
            if(j%arr[0]==0) dp[1][j] = 1;
            else dp[1][j] = 0;
        }
        
        
        for(int i = 2; i<=n; i++){
            for(int j = 0; j<=tar; j++){
                long np = dp[i-1][j];
                long p=0;
                if(arr[i-1]<=j){
                    p = dp[i][j-arr[i-1]];
                }
                
                dp[i][j] = p+np;
            }
        }
        
        return dp[n][tar];
	}
}
```

## Space optimized
```java
import java.util.*;
public class Solution {

	public static long countWaysToMakeChange(int arr[], int tar){
        //write your code here
        int n = arr.length;
        long ur[]=new long[tar+1];
        for(int j=0; j<=tar; j++){
            if(j%arr[0]==0) ur[j] = 1;
            else ur[j] = 0;
        }
        
        
        for(int i = 2; i<=n; i++){
            long curr[]=new long[tar+1];
            for(int j = 0; j<=tar; j++){
                long np = ur[j];
                long p=0;
                if(arr[i-1]<=j){
                    p = curr[j-arr[i-1]];
                }
                
                curr[j] = p+np;
            }
            ur = curr;
        }
        
        return ur[tar];
	}
}
```

# [10. Unbounded Knapsack](https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029)
## Memonization
```java
import java.util.*;
public class Solution {
        public static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
        // Write your code here.
          int dp[][]=new int[n+1][w+1];
            for(int d[]: dp) Arrays.fill(d,-1);
            
         return fun(val,wt,n,w,dp);
    }
    static int fun(int val[], int wt[], int n, int w, int dp[][]){
        if(n==0 || w==0) return 0;
        
        if(dp[n][w]!=-1) return dp[n][w];
        int p=0,np=0;
        if(wt[n-1]<=w){
            p = val[n-1] + fun(val,wt,n,w-wt[n-1],dp);
        }
        np = fun(val,wt,n-1,w,dp);
        
        return dp[n][w] = Math.max(p,np);
    }
}
```
## tabulation
```java
import java.util.*;
public class Solution {
        public static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
        // Write your code here.
          int dp[][]=new int[n+1][w+1];
           for(int i = 1; i<=n; i++){
               for(int j = 1; j<=w; j++){
                   int p=0,np=0;
                    if(wt[i-1]<=j){
                        p = val[i-1] + dp[i][j-wt[i-1]];
                    }
                    np = dp[i-1][j];
                   
                   dp[i][j] = Math.max(p,np);
               }
           }
            
         return dp[n][w];
    }
}
```
## Space optimization
```java
import java.util.*;
public class Solution {
        public static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
        // Write your code here.
          int ur[]=new int[w+1];
           for(int i = 1; i<=n; i++){
               int curr[]=new int[w+1];
               for(int j = 1; j<=w; j++){
                   int p=0,np=0;
                    if(wt[i-1]<=j){
                        p = val[i-1] + curr[j-wt[i-1]];
                    }
                    np = ur[j];
                   
                   curr[j] = Math.max(p,np);
               }
               ur=curr;
           }
            
         return ur[w];
    }
}
```

# [11. Rod Cutting](https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284)
### This Problem is same as Unbounded Knapsack.
Here's are the Matchings :-
- W ---> l ---> N
- val[] ---> price[]
- wt[] ---> length[] is 1 to N arranged here termed as lt variable which decreaseBy1 always when recursion decrease.
- N ---> N
## Memonization
```java
import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
        int dp[][]=new int[n+1][n+1];
        for(int d[] : dp) Arrays.fill(d,-1);
        
        return fun(price,n,n,n,dp);
	}
    static int fun(int val[], int lt, int l, int n, int dp[][]){
        if(l==0 || n==0) return 0;
        if(dp[n][l]!=-1) return dp[n][l];
        int p = 0, np = 0;
        if(lt<=l) p = val[n-1] + fun(val,lt,l-lt,n,dp);
        np = fun(val,lt-1,l,n-1,dp);
        
        return dp[n][l] = Math.max(p,np);
    }


    /**
    static int fun(int val[], int l, int n, int dp[][]){
        if(l==0 || n==0) return 0;
        if(dp[n][l]!=-1) return dp[n][l];
        int p = 0, np = 0;
        if(n<=l) p = val[n-1] + fun(val,l-n,n,dp);
        np = fun(val,l,n-1,dp);
        
        return dp[n][l] = Math.max(p,np);
    }
    **/
}
```

## tabulation
```java
import java.util.*;
public class Solution {
	public static int cutRod(int val[], int n) {
		// Write your code here.
        int dp[][]=new int[n+1][n+1];
        int l = n;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=l; j++){
                int p = 0, np = 0;
                if(i<=j) p = val[i-1] + dp[i][j-i];
                np = dp[i-1][j];
                
                dp[i][j] = Math.max(p,np);
            }
        }
        
        return dp[n][l];
	}
}
```

## Space Optimised
```java
import java.util.*;
public class Solution {
	public static int cutRod(int val[], int n) {
		// Write your code here.
        int ur[]=new int[n+1];
        int l = n;
        for(int i = 1; i<=n; i++){
            int curr[]=new int[n+1];
            for(int j = 1; j<=l; j++){
                int p = 0, np = 0;
                if(i<=j) p = val[i-1] + curr[j-i];
                np = ur[j];
                
                curr[j] = Math.max(p,np);
            }
            ur=curr;
        }
        
        return ur[l];
	}
}
```
