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


# [2. Print LCS](https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/)


```java
static int fun(String s1, String s2, int n1, int n2){
	    int dp[][]=new int[n1+1][n2+1];
	    
	    for(int i = 1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        int i = n1, int j = n2;
        String ans = "";
        while(i>=0 && j>=0){
            if(s1.charAt(i)==s2.charAt(j)){
                ans = s1.charAt(i) + ans; 
                i--; j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]) i--;
                else j--;
            }
        }
        return ans;
	}
```

# [3. LCSubstring](https://www.codingninjas.com/codestudio/problems/longest-common-substring_1235207?)
## Tabulation
```java
public class Solution {
	public static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
		// Write your code here.
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
## Space Optimized
```java
public class Solution {
	public static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
		// Write your code here.
        int ur[]=new int[n2+1];
        int ans=0;
        for(int i=1;i<=n1;i++){
            int curr[]=new int[n2+1];
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=ur[j-1]+1;
                    ans=Math.max(ans,curr[j]);
                }
                else curr[j]=0;
            }
            ur = curr;
        }
        return ans;
	}
}
```
[Reference](https://takeuforward.org/data-structure/longest-common-substring-dp-27/)

# [4. LPS](https://www.codingninjas.com/codestudio/problems/longest-palindromic-subsequence_842787?)
### - return LCS(s1,reverse(s1))

## space optimization
```java
public class Solution {
	public static int longestPalindromeSubsequence(String s) {
		// Write your code here.
        return lcs(s,reverse(s));
	}
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
    static String reverse(String s){
        StringBuilder str=new StringBuilder(s);
        return str.reverse().toString();
    }
}
```


# [5. Minimum insertions to make a string palindrome](https://www.codingninjas.com/codestudio/problems/minimum-insertions-to-make-palindrome_985293?)
# Intution
- NOTE : Minimum # of deletion=Minimum # of Insertion. this is bcz in deletion we remove single occuring element and in Insertion we try to make that single element into couple by introducing new element.

- Find LPS
- return n-LPS
- because no. of deletion is inversely propotional to lengthOfPS.
 
## Space Optimized
```java
public class Solution {
    public static int minInsertion(String str) {
    	// Write your code here.
        return str.length()-lps(str);
    }
    public static int lps(String s) {
        // Write your code here.
        return lcs(s,reverse(s));
    }
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
    static String reverse(String s){
        StringBuilder str=new StringBuilder(s);
        return str.reverse().toString();
    }
}
```



# [6. Minimum Number of Deletions and Insertions to convert String A to String B](https://www.codingninjas.com/codestudio/problems/can-you-make_4244510)
- Find LCS
- Insertion : str2.length()-lcs
- Deletion : str1.length()-lcs

## Space Optimization
```java
public class Solution {
    public static int canYouMake(String s1, String s2) {
        // Write your code here.
        int lcs = lcs(s1,s2);
        return (s1.length()-lcs)+(s2.length()-lcs);
    }
    
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
