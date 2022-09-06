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
         
        
        int dr[]=new int[m]; // down row - temp
        
        for(int j=m-1; j>=0; j--){ if(arr[n-1][j]!=1) dr[j] = 1; else break; }
        
        
        for(int i=n-2; i>=0; i--){
            int sc[]=new int[m]; // side colum - operation
            for(int j=m-1; j>=0; j--){
                int r=0; int d=0;
                if(j<m-1 && arr[i][j+1]!=1) r = sc[j+1];
                if(arr[i+1][j]!=1) d=dr[j];
                
                if(arr[i][j]!=1) sc[j] = d + r;
            }
            dr=sc;
        }
        return dr[0];
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
             
        
        int dr[]=new int[m]; // down row - temp
        
        dr[m-1] = arr[n-1][m-1];
        for(int j=m-2; j>=0; j--) dr[j] = arr[n-1][j] + dr[j+1];
        
          
        
        for(int i=n-2; i>=0; i--){
            int sc[]=new int[m]; // side colum - operation
            for(int j=m-1; j>=0; j--){
                int r = Integer.MAX_VALUE-200;
                if(j<m-1) r = sc[j+1];
                sc[j] = Math.min(dr[j] + arr[i][j], r + arr[i][j]);
            }
            dr=sc;
        }
        return dr[0];
    }
    
}
```

# [5. Minimum path sum in Triangular Grid](https://www.codingninjas.com/codestudio/problems/triangle_1229398?)
## recurrsive 
```java
public class Solution {
    public static int minimumPathSum(int[][] arr, int n) {
        // Write your code here.
        return fun(arr,0,0,n,1);
        
    }
    static int fun(int arr[][], int i, int j, int n, int m){
        if(i==n-1) return arr[i][j];
        if(i>=n || j>=m) return (int)Math.pow(10,9);
        
        int b = arr[i][j] + fun(arr,i+1,j,n,i+2);
        int br = arr[i][j] + fun(arr,i+1,j+1,n,i+2);
        
        return Math.min(b,br);
    }
}
```
 ## memonization
 ```java
 import java.util.*;
public class Solution {
    public static int minimumPathSum(int[][] arr, int n) {
        // Write your code here.
        int dp[][]=new int[n][n];
        for(int d[] : dp) Arrays.fill(d,-1);
        
        return fun(arr,0,0,n,1,dp);
        
    }
    static int fun(int arr[][], int i, int j, int n, int m, int dp[][]){
        if(i==n-1) return arr[i][j];
        if(i>=n || j>=m) return (int)Math.pow(10,9);
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int b = arr[i][j] + fun(arr, i+1, j, n, i+2, dp);
        int br = arr[i][j] + fun(arr, i+1, j+1, n, i+2, dp);
        
        return dp[i][j] = Math.min(b,br);
    }
}
 ```
## Tabulation
```java
import java.util.*;
public class Solution {
    public static int minimumPathSum(int[][] arr, int n) {
        // Write your code here.
        int dp[][]=new int[n][n];
        for(int j=0; j<n; j++) dp[n-1][j] = arr[n-1][j];
        
        for(int i = n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                dp[i][j] = Math.min(arr[i][j] + dp[i+1][j], arr[i][j] + dp[i+1][j+1]);
            }
        }
        
        return dp[0][0];
    }
    
}
```
## space optimization
```java
import java.util.*;
public class Solution {
    public static int minimumPathSum(int[][] arr, int n) {
        // Write your code here.
        int dr[]=new int[n];
        for(int j=0; j<n; j++) dr[j] = arr[n-1][j];
        
        int cur[]=new int[n];
        for(int i = n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                cur[j] = Math.min(arr[i][j] + dr[j], arr[i][j] + dr[j+1]);
            }
            dr=cur;
        }
        return dr[0];
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