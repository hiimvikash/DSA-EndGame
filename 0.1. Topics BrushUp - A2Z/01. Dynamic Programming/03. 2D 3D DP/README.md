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

