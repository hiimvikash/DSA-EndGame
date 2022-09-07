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







# [6. 931. Minimum Falling Path Sum](https://leetcode.com/problems/minimum-falling-path-sum/)
## Recursive
```java
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; int m = matrix[0].length;
        
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<m; j++)
        ans = Math.min(ans,fun(matrix,0,j,n,m));
        
        return ans;
    }
    int fun(int arr[][], int i, int j, int n, int m){
        if(i==n-1) return arr[i][j];
        if(i>=n || j>=m) return (int)Math.pow(10,9);
        
        int d = arr[i][j] + fun(arr,i+1,j,n,m);
        int dr = Integer.MAX_VALUE, dl = Integer.MAX_VALUE;
        if(j<m-1)  dr = arr[i][j] + fun(arr,i+1,j+1,n,m);
        if(j>0)  dl = arr[i][j] + fun(arr,i+1,j-1,n,m);
        
        return Math.min(d,Math.min(dr,dl));
    }
}
```
## Memonization
```java
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; int m = matrix[0].length;
        int dp[][]=new int[n][n];
        int ans = Integer.MAX_VALUE;
        
        for(int j=0; j<m; j++){
            for(int d[] : dp) Arrays.fill(d,-1);
            ans = Math.min(ans,fun(matrix,0,j,n,m,dp));
        }
        return ans;
    }
    int fun(int arr[][], int i, int j, int n, int m, int dp[][]){
        if(i==n-1) return arr[i][j];
        if(i>=n || j>=m) return (int)Math.pow(10,9);
        if(dp[i][j]!=-1) return dp[i][j];
        
        int d = arr[i][j] + fun(arr,i+1,j,n,m,dp);
        int dr = Integer.MAX_VALUE, dl = Integer.MAX_VALUE;
        if(j<m-1)  dr = arr[i][j] + fun(arr,i+1,j+1,n,m,dp);
        if(j>0)  dl = arr[i][j] + fun(arr,i+1,j-1,n,m,dp);
        
        return dp[i][j] = Math.min(d,Math.min(dr,dl));
    }
}
```
## Tabulation
```java
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length; int m = arr[0].length;
        int dp[][]=new int[n][m];
        for(int j=0; j<m; j++) dp[n-1][j] = arr[n-1][j];
        
        for(int i = n-2; i>=0; i--){
            for(int j = m-1; j>=0; j--){
                int d = arr[i][j] + dp[i+1][j];
                int dr = Integer.MAX_VALUE, dl = Integer.MAX_VALUE;
                if(j<m-1)  dr = arr[i][j] + dp[i+1][j+1];
                if(j>0)  dl = arr[i][j] + dp[i+1][j-1];
                
                dp[i][j] = Math.min(d,Math.min(dr,dl));
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<m; j++) ans = Math.min(ans,dp[0][j]);
            
        return ans;
    }
    
}
```
## Space Optimized
```java
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length; int m = arr[0].length;
        int dwn[]=new int[m];
        for(int j=0; j<m; j++) dwn[j] = arr[n-1][j];

        
        for(int i = n-2; i>=0; i--){
            int curr[]=new int[m];
            for(int j = m-1; j>=0; j--){
                int d = arr[i][j] + dwn[j];
                int dr = Integer.MAX_VALUE, dl = Integer.MAX_VALUE;
                if(j<m-1)  dr = arr[i][j] + dwn[j+1];
                if(j>0)  dl = arr[i][j] + dwn[j-1];
                
                curr[j] = Math.min(d,Math.min(dr,dl));
            }
            dwn = curr;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<m; j++) ans = Math.min(ans,dwn[j]);
            
        return ans;
    }
    
}
```
# [7. Chocolate Pickup GQ](https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?)
![image](https://user-images.githubusercontent.com/71629248/188597011-2797761a-151f-4e15-afc5-cb3325a43551.png)
### Hence we have a total of 9 different options at every f(i,j1,j2) to move Alice and Bob. Now we can manually write these 9 options or we can observe a pattern in them, first Alice moves to one side and Bob tries all three choices, then again Alice moves, then Bob, and so on. This pattern can be easily captured by using two nested loops that change the column numbers(j1 and j2).

## Recursion
```java
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
        return fun(grid, 0, 0, c-1, r, c);
	}
    static int fun(int arr[][], int i, int j1, int j2, int n, int m){
        if(j1>=m || j1<0 || j2>=m || j2<0) return (int)Math.pow(-10,9);
        
        if(i==n-1){
            if(j1==j2) return arr[i][j1];
            return arr[i][j1] + arr[i][j2];
        }
        int maxi = 0;
        for(int dj1 = -1; dj1<2; dj1++){
            for(int dj2 = -1; dj2<2; dj2++){
                if(j1==j2) maxi = Math.max(maxi, arr[i][j1] + fun(arr, i+1, j1+dj1, j2+dj2, n, m));
                else maxi = Math.max(maxi, arr[i][j1] + arr[i][j2] + fun(arr, i+1, j1+dj1, j2+dj2, n, m));
            }
        }
        return maxi;
    }
}
```

## Memonization
```java
import java.util.*;
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
        int dp[][][] = new int[r+1][c+1][c+1];
        
        for(int d2[][] : dp){
            for(int d[] : d2){
                Arrays.fill(d,-1);
            }
        } 
        return fun(grid, 0, 0, c-1, r, c, dp);
	}
    static int fun(int arr[][], int i, int j1, int j2, int n, int m, int dp[][][]){
        if(j1>=m || j1<0 || j2>=m || j2<0) return (int)Math.pow(-10,9);
        
        if(i==n-1){
            if(j1==j2) return arr[i][j1];
            return arr[i][j1] + arr[i][j2];
        }
        
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi = 0;
        for(int dj1 = -1; dj1<2; dj1++){
            for(int dj2 = -1; dj2<2; dj2++){
                if(j1==j2) maxi = Math.max(maxi, arr[i][j1] + fun(arr, i+1, j1+dj1, j2+dj2, n, m, dp));
                else maxi = Math.max(maxi, arr[i][j1] + arr[i][j2] + fun(arr, i+1, j1+dj1, j2+dj2, n, m, dp));
            }
        }
        return dp[i][j1][j2] =  maxi;
    }
}
```
## Tabulation
### For the tabulation approach, it is better to understand what a cell in the 3D DP array means. As we had done in memoization, we will initialize a dp[] array of size [N][M][M]. So now, when we say dp[2][0][3], what does it mean? It means that we are getting the value of maximum chocolates collected by Alice and Bob, when Alice is at (2,0) and Bob is at (2,3).

### The below figure gives us a bit more clarity.
![image](https://user-images.githubusercontent.com/71629248/188681184-6b424b56-6ee8-4e90-8366-624f269509b6.png)

```java
import java.util.*;
public class Solution {
	public static int maximumChocolates(int n, int m, int[][] arr) {
		// Write your code here.
        
        int dp[][][] = new int[n+1][m+1][m+1];
        
        for(int j1 = 0; j1<m; j1++){
            for(int j2 = 0; j2<m; j2++){
                if(j1==j2) dp[n-1][j1][j2] = arr[n-1][j1];
                else dp[n-1][j1][j2] = arr[n-1][j1] + arr[n-1][j2];
            }
        }
        
         int ans = 0;
        for(int i = n-2; i>=0; i--){
            for(int j1 = 0; j1<m; j1++){
                for(int j2 = 0; j2<m; j2++){
                    
                      int maxi = Integer.MIN_VALUE;
                    for(int dj1 = -1; dj1<2; dj1++){
                        for(int dj2 = -1; dj2<2; dj2++){
                                    if(j1==j2) ans = arr[i][j1];
                                    else ans = arr[i][j1] + arr[i][j2];
                                if((j1+dj1<m && j1+dj1>=0) && (j2+dj2<m && j2+dj2>=0)) ans += dp[i+1][j1+dj1][j2+dj2];
                                else ans += (int)Math.pow(-10,9);
                            
                                maxi = Math.max(maxi,ans);
                         }
                    }
                dp[i][j1][j2] = maxi;
           } // j2
        } // j1
      } // i
        return dp[0][0][m-1];
    }
}
```

## Space Optimization
```java
import java.util.*;
public class Solution {
	public static int maximumChocolates(int n, int m, int[][] arr) {
		// Write your code here.
        
        int dr[][] = new int[m][m];
        
        for(int j1 = 0; j1<m; j1++){
            for(int j2 = 0; j2<m; j2++){
                if(j1==j2) dr[j1][j2] = arr[n-1][j1];
                else dr[j1][j2] = arr[n-1][j1] + arr[n-1][j2];
            }
        }
        
         int ans = 0;
        for(int i = n-2; i>=0; i--){
            int curr[][] = new int[m][m];
            for(int j1 = 0; j1<m; j1++){
                for(int j2 = 0; j2<m; j2++){
                    
                      int maxi = Integer.MIN_VALUE;
                        
                    for(int dj1 = -1; dj1<2; dj1++){
                        for(int dj2 = -1; dj2<2; dj2++){
                                    if(j1==j2) ans = arr[i][j1];
                                    else ans = arr[i][j1] + arr[i][j2];
                                if((j1+dj1<m && j1+dj1>=0) && (j2+dj2<m && j2+dj2>=0)) ans += dr[j1+dj1][j2+dj2];
                                else ans += (int)Math.pow(-10,9);
                            
                                maxi = Math.max(maxi,ans);
                         }
                    }
                curr[j1][j2] = maxi;
           } // j2
        } // j1
            dr = curr;
      } // i
        return dr[0][m-1];
    }
}
```
[Reference](https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13/)
