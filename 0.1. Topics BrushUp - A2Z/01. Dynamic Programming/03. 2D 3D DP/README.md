# 1. [Ninja’s Training](https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003)

## Reccursive
```java
public class Solution {
    public static int ninjaTraining(int n, int arr[][]) {

        // Write your code here..
        return fun(arr,n,3);
    }
    public static int fun(int arr[][], int day, int last){
        if(day==0) return 0;
        
        int p = Integer.MIN_VALUE;
        for(int j=0; j<3; j++){
            if(j!=last){
                p = Math.max(p, arr[day-1][j] + fun(arr,day-1,j));
            }
        }
        return p;
    }

}
```

## Memonization

```java
import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int arr[][]) {

        // Write your code here..
        int dp[][]=new int[n+1][4];
        for(int d[] : dp) Arrays.fill(d,-1);
        
        return fun(arr,n,3, dp);
    }
    public static int fun(int arr[][], int day, int last, int dp[][]){
        if(day==0) return 0;
        if (day == 1) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last)
                    maxi = Math.max(maxi, arr[0][i]);
            }
            return dp[day][last] = maxi;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        
        int maxi = 0;
        for(int j=0; j<3; j++){
            if(j != last){
                int p = arr[day-1][j] + fun(arr,day-1,j,dp);
                maxi = Math.max(maxi,p);
            }
        }
        return dp[day][last] = maxi;
    }

}
```

## Tabulation
```java
import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int arr[][]) {

        // Write your code here..
        int dp[][]=new int[n+1][4];
        
        // base case initialization
        for(int j=0; j<4; j++) dp[0][j]=0;
        
       // reccursive start
        for(int d=1; d<=n; d++){ // day
            for(int l=0; l<=3; l++){ // last
                int maxi = 0;
                for(int j=0; j<3; j++){ // arr activity
                    if(j!=l){
                        int p = arr[d-1][j] + dp[d-1][j];
                        maxi = Math.max(maxi,p);
                    }
                }
                dp[d][l] = maxi;
            }
        }
        
        return dp[n][3];
    }

}
```



## Space Optimized

```java
import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int arr[][]) {

        // Write your code here..
        int prev[]=new int[4];
        
        // base case initialization
        for(int j=0; j<4; j++) prev[j]=0;
        
       // reccursive start
        for(int d=1; d<=n; d++){ // day
            int temp[]=new int[4];
            for(int l=0; l<=3; l++){ // last
                int p=0;
                for(int j=0; j<3; j++){ // arr activity
                    if(j!=l){
                        p = Math.max(p, arr[d-1][j] + prev[j]);
                        
                    }
                }
                temp[l] = p;
            }
            prev=temp;
        }
        
        return prev[3];
    }

}
```
[Reference](https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/)

# [2. 62. Unique Paths](https://leetcode.com/problems/unique-paths/)

## Recursive
```java
class Solution {
    public int uniquePaths(int n, int m) { // n-rows, m-column
        return fun(0,0,n,m);
    }
    int fun(int i,int j, int n, int m){
        if(i == n-1 && j == m-1) return 1;
        if(i >= n || j >= m) return 0;
        
        return fun(i+1,j,n,m) + fun(i,j+1,n,m);
    }
}
```

## memonization
```java
class Solution {
    public int uniquePaths(int n, int m) { // n-rows, m-column
        int dp[][]=new int[n+1][m+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        
        return fun(0,0,n,m,dp);
    }
    int fun(int i,int j, int n, int m, int dp[][]){
        if(i == n-1 && j == m-1) return 1;
        if(i >= n || j >= m) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        return dp[i][j] = fun(i+1,j,n,m,dp) + fun(i,j+1,n,m,dp);
    }
}
```
## Tabulation
```java
class Solution {
    public int uniquePaths(int n, int m) { // n-rows, m-column
        int dp[][]=new int[n][m];
        
        for(int j=0; j<m; j++) dp[n-1][j] = 1;
        
        for(int i=n-2; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int r=0;
                if(j<m-1) r = dp[i][j+1];
                dp[i][j] = dp[i+1][j] + r;
            }
        }
        return dp[0][0];
    }
}
```

## Space optimization
### As we see in tabulation the relation ```dp[i][j] = dp[i+1][j] + dp[i][j+1] ``` for filling a particular box we only need SIDE BOX and DOWN BOX : that means we only require DownRow and SideColumn and our answer will lie in SC[0]
```java
class Solution {
    public int uniquePaths(int n, int m) { // n-rows, m-column
        if(n==1 || m==1) return 1;
        
        int dr[]=new int[m]; // down row - temp
        
        for(int j=0; j<m; j++) dr[j] = 1;
        
        int sc[]=new int[m]; // side colum - operation
        for(int i=n-2; i>=0; i--){
            
            for(int j=m-1; j>=0; j--){
                int r=0;
                if(j<m-1) r = sc[j+1];
                sc[j] = dr[j] + r;
            }
            dr=sc;
        }
        return sc[0];
    }
}
```
[Reference](https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/)

# [3. 63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)

## memonization
```java
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length; int m = arr[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        
        return fun(arr,0,0,n,m,dp);
    }
    int fun(int arr[][], int i,int j, int n, int m, int dp[][]){
        
        if(i >= n || j >= m) return 0;
        if(arr[i][j]==1) return 0;
        if(i == n-1 && j == m-1) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        return dp[i][j] = fun(arr,i+1,j,n,m,dp) + fun(arr,i,j+1,n,m,dp);
    }
}
```

## Tabulation 
```java
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length; int m = arr[0].length;
        if(arr[n-1][m-1]==1 || arr[0][0]==1) return 0;
        
        if(n==1 || m==1) return 1;
        int dp[][]=new int[n][m];
        
        for(int j=m-1; j>=0; j--) if(arr[n-1][j]!=1) dp[n-1][j] = 1; else break;
        
        for(int i=n-2; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(arr[i][j]!=1){
                    int r=0,d=0;
                    if(j<m-1 && arr[i][j+1]!=1) r = dp[i][j+1];
                    if(arr[i+1][j]!=1) d = dp[i+1][j];

                    dp[i][j] = d + r;
                }
            }
        }
        return dp[0][0];
    }
}
```
## Space Optimized
```java
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length; int m = arr[0].length;
        if(arr[n-1][m-1]==1 || arr[0][0]==1) return 0;
        
        if(n==1 || m==1) return 1;
        
        
        int dr[]=new int[m]; // down row - temp
        
        for(int j=m-1; j>=0; j--){ if(arr[n-1][j]!=1) dr[j] = 1; else break; }
        
        int sc[]=new int[m]; // side colum - operation
        for(int i=n-2; i>=0; i--){
            
            for(int j=m-1; j>=0; j--){
                int r=0; int d=0;
                if(j<m-1 && arr[i][j+1]!=1) r = sc[j+1];
                if(arr[i+1][j]!=1) d=dr[j];
                
                if(arr[i][j]!=1) sc[j] = d + r;
            }
            dr=sc;
        }
        return sc[0];
    }
    
}
```
[Reference](https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/)

# [4. 64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)
## memonization
```java
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        
        return fun(grid,0,0,n,m,dp);
    }
    int fun(int arr[][], int i,int j, int n, int m, int dp[][]){
        if(i == n-1 && j == m-1) return arr[i][j];
        if(i >= n || j >= m) return Integer.MAX_VALUE-200;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int d = arr[i][j] + fun(arr,i+1,j,n,m,dp);
        int r = arr[i][j] + fun(arr,i,j+1,n,m,dp);
        
        return dp[i][j] = Math.min(d,r);
    }
    
}
```
## Tabulation
```java
class Solution {
    public int minPathSum(int[][] arr) {
        int n = arr.length; int m = arr[0].length;
        int dp[][]=new int[n][m];
        
        dp[n-1][m-1] = arr[n-1][m-1];
        for(int j=m-2; j>=0; j--) dp[n-1][j] = arr[n-1][j] + dp[n-1][j+1];
        
        for(int i=n-2; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int r = Integer.MAX_VALUE - 200;
                if(j<m-1) r = dp[i][j+1];
                dp[i][j] = Math.min(dp[i+1][j] + arr[i][j], r + arr[i][j]);
            }
        }
        return dp[0][0];
    }
    
}
```
## space optimization
```java
class Solution {
    public int minPathSum(int[][] arr) {
        int n = arr.length; int m = arr[0].length;
        if(n==1 && m==1) return arr[0][0];
       
        
        int dr[]=new int[m]; // down row - temp
        
        dr[m-1] = arr[n-1][m-1];
        for(int j=m-2; j>=0; j--) dr[j] = arr[n-1][j] + dr[j+1];
        
        if(n==1) return dr[0];
        
        int sc[]=new int[m]; // side colum - operation
        for(int i=n-2; i>=0; i--){
            
            for(int j=m-1; j>=0; j--){
                int r = Integer.MAX_VALUE-200;
                if(j<m-1) r = sc[j+1];
                sc[j] = Math.min(dr[j] + arr[i][j], r + arr[i][j]);
            }
            dr=sc;
        }
        return sc[0];
    }
    
}
```