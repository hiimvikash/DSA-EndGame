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