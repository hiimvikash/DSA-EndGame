# 1. [Longest Increasing Subsequence](https://www.codingninjas.com/codestudio/problems/longest-increasing-subsequence_630459)

## Reccursion
```java
import java.util.*;
public class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int n = arr.length;
        return fun(0,-1,arr,n); 
    }
    static int fun(int ind, int previ, int arr[], int n){
        if(ind==n) return 0;
        
        int np = fun(ind+1, previ, arr, n); int p =0;
        if(previ==-1 || arr[previ]<arr[ind])
            p = 1 + fun(ind+1, ind, arr, n);
        return Math.max(p,np);
    }

}
```
## Memonization

```java
import java.util.*;
public class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int n = arr.length;
        int dp[][]=new int[n][n+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        
        return fun(0,-1,arr,n,dp); 
    }
    static int fun(int ind, int previ, int arr[], int n, int dp[][]){
        if(ind==n) return 0;
        if(dp[ind][previ+1]!=-1) return dp[ind][previ+1];
        
        int np = fun(ind+1, previ, arr, n,dp); int p =0;
        if(previ==-1 || arr[previ]<arr[ind])
            p = 1 + fun(ind+1, ind, arr, n, dp);
        return dp[ind][previ+1] = Math.max(p,np);
    }

}
```

## Tabulation
## find lis till ith, from 0 to i
```java
public class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int n = arr.length;
        int dp[]=new int[n];
        
        int ans=dp[0]=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i]) max=Math.max(dp[j],max);
            }
            dp[i]=max+1;
            ans=Math.max(dp[i],ans);
        }
        return ans;   
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
[Reference](https://takeuforward.org/data-structure/longest-increasing-subsequence-dp-41/)















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
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans = s1.charAt(i-1) + ans; 
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

# [7. Shortest Common Supersequence](https://www.codingninjas.com/codestudio/problems/shortest-supersequence_4244493)

### Length of SCS :-
- Find LCS
- Minus it with totalStringLength. If you do so you are making sure that common elements occur one's. ```return (n1+n2)-dp[n1][n2];```

```java
public class Solution {
    public static String shortestSupersequence(String s1, String s2) {
        // Write your code here..
        int n1 = s1.length(), n2 = s2.length();
        int dp[][]=new int[n1+1][n2+1];
        
        for(int i = 1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        String ans = "";
        int i = n1, j = n2;
        
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans = s1.charAt(i-1) + ans; i--; j--;
            }
            else{
                if(dp[i-1][j] >= dp[i][j-1]){
                    ans = s1.charAt(i-1) + ans; i--;
                }
                else{
                    ans = s2.charAt(j-1) + ans; j--;
                }
            }
        }
        
        while(j>0){
            ans = s2.charAt(j-1) + ans; j--;
        }
        while(i>0){
            ans = s1.charAt(i-1) + ans; i--;
        }
        
        return ans;
    
    }

}
```
[**Video reference**](https://youtu.be/xElxAuBcvsU)


# [8. Subsequence Counting GQ](https://www.codingninjas.com/codestudio/problems/subsequence-counting_3755256)

## Recurrsion
```java
public class Solution {
    public static int subsequenceCounting(String txt, String s, int lt, int ls) {
        // Write your code here..
        return fun(txt,s,lt,ls);
    }
    static int fun(String txt, String s, int lt, int ls){
        if(ls==0) return 1;
        if(lt==0) return 0;
        
        int c2 = fun(txt,s,lt-1,ls);
        if(s.charAt(ls-1)==txt.charAt(lt-1)) return fun(txt,s,lt-1,ls-1) + c2;
        else return c2;
    }

}
```

## Memonization
```java
import java.util.*;
public class Solution {
    static int mod = (int)(Math.pow(10,9)+7);
    public static int subsequenceCounting(String txt, String s, int lt, int ls) {
        // Write your code here..
        int dp[][]=new int[ls+1][lt+1];
        for(int d[] : dp) Arrays.fill(d,-1);
        
        return fun(txt,s,lt,ls,dp);
    }
    static int fun(String txt, String s, int lt, int ls, int dp[][]){
        if(ls==0) return 1;
        if(lt==0) return 0;
        
        if(dp[ls][lt] !=-1) return dp[ls][lt];
        
        int c2 = fun(txt,s,lt-1,ls,dp);
        if(s.charAt(ls-1)==txt.charAt(lt-1)) return dp[ls][lt] = (fun(txt,s,lt-1,ls-1,dp) + c2)%mod;
        else return dp[ls][lt] = c2%mod;
    }

}
```

## Tabulation
```java
import java.util.*;
public class Solution {
    static int mod = (int)(Math.pow(10,9)+7);
    public static int subsequenceCounting(String txt, String s, int lt, int ls) {
        // Write your code here..
        int dp[][]=new int[ls+1][lt+1];
        for(int j=0; j<=lt; j++) dp[0][j] = 1;
        
        for(int i=1; i<=ls; i++){
            for(int j=1; j<=lt; j++){
                if(s.charAt(i-1)==txt.charAt(j-1)) dp[i][j] = (dp[i-1][j-1] + dp[i][j-1])%mod;
                else dp[i][j] = dp[i][j-1]%mod;
            }
        }
        
        return dp[ls][lt];
    }
}
```

## Space optimized
```java
import java.util.*;
public class Solution {
    static int mod = (int)(Math.pow(10,9)+7);
    public static int subsequenceCounting(String txt, String s, int lt, int ls) {
        // Write your code here..
        int ur[]=new int[lt+1];
        for(int j=0; j<=lt; j++) ur[j] = 1;
        
        for(int i=1; i<=ls; i++){
            int curr[]=new int[lt+1];
            for(int j=1; j<=lt; j++){
                if(s.charAt(i-1)==txt.charAt(j-1)) curr[j] = (ur[j-1] + curr[j-1])%mod;
                else curr[j] = curr[j-1]%mod;
            }
            ur = curr;
        }
        
        return ur[lt];
    }
}
```

# [9. Edit Distance GQ](https://leetcode.com/problems/edit-distance/)
## Memonization
```java
class Solution {
    public int minDistance(String s1, String s2) {
         //Your code goes here
        int n1 = s1.length(), n2 = s2.length();
        int dp[][]=new int[n1+1][n2+1];
        for(int d[]:dp) Arrays.fill(d,-1);
        
        return ed(s1,s2,n1,n2, dp);
    }
     int ed(String s1, String s2, int n1, int n2, int dp[][]){
        if(n1==0) return n2;
        if(n2==0) return n1;
        
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        
        if(s1.charAt(n1-1) == s2.charAt(n2-1)) return dp[n1][n2] = ed(s1,s2,n1-1,n2-1,dp);
        int i = 1 + ed(s1,s2,n1,n2-1,dp);
        int d = 1 + ed(s1,s2,n1-1,n2,dp);
        int r = 1 + ed(s1,s2,n1-1,n2-1,dp);
        
        return dp[n1][n2] = Math.min(i, Math.min(d,r));
    }
}
```
## tabulation
```java
class Solution {
    public int minDistance(String s1, String s2) {
         //Your code goes here
        int n1 = s1.length(), n2 = s2.length();
        int dp[][]=new int[n1+1][n2+1];
        
        for(int j=0; j<=n2; j++) dp[0][j]=j; // if(n1==0) return n2;
        for(int i=0; i<=n1; i++) dp[i][0]=i; // if(n2==0) return n1;
        
        
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    int in = 1 + dp[i][j-1];
                    int d = 1 + dp[i-1][j];
                    int r = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(in, Math.min(d,r));
                }
            }
        }
        
        return dp[n1][n2];
    }
     
}
```
## Space optimization
```java
class Solution {
    public int minDistance(String s1, String s2) {
         //Your code goes here
        int n1 = s1.length(), n2 = s2.length();
        int ur[]=new int[n2+1];
        
        for(int j=0; j<=n2; j++) ur[j]=j; // if(n1==0) return n2;
        
        
        
        for(int i=1; i<=n1; i++){
            int curr[]=new int[n2+1];
            curr[0] = i;
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) curr[j] = ur[j-1];
                else{
                    int in = 1 + curr[j-1];
                    int d = 1 + ur[j];
                    int r = 1 + ur[j-1];

                    curr[j] = Math.min(in, Math.min(d,r));
                }
            }
            ur = curr;
        }
        
        return ur[n2];
    }
     
}
```

# [10. Wildcard pattern matching GQ](https://www.codingninjas.com/codestudio/problems/wildcard-pattern-matching_701650)

## reccursion
```java
public class Solution {
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
        int pl = pattern.length(), tl = text.length();
        return fun(pattern,text,pl,tl);
	}
    
    static boolean fun(String ptrn, String txt, int pl, int tl){
        if(pl==0 && tl==0) return true;
        if(pl==0 && tl>0) return false;
        if(pl>0 && tl==0) return isAllStars(ptrn,pl);
        
        if(ptrn.charAt(pl-1)==txt.charAt(tl-1) || ptrn.charAt(pl-1)=='?') return fun(ptrn,txt,pl-1,tl-1);
        if(ptrn.charAt(pl-1)=='*') return fun(ptrn,txt,pl-1,tl) || fun(ptrn,txt,pl,tl-1);
        
        return false;
    }
    
    static boolean isAllStars(String s, int l){
        boolean f = true;
        for(int i=0; i<l; i++) if(s.charAt(i)!='*') f=false;
        
        return f;
    }
}
```

## memonization
```java
import java.util.*;
public class Solution {
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
        int pl = pattern.length(), tl = text.length();
        int dp[][]=new int[pl+1][tl+1];
        for(int d[]: dp) Arrays.fill(d,-1);
        
        
        return fun(pattern,text,pl,tl,dp)==1? true : false;
	}
    
    static int fun(String ptrn, String txt, int pl, int tl, int dp[][]){
        if(pl==0 && tl==0) return 1;
        if(pl==0 && tl>0) return 0;
        if(pl>0 && tl==0) return isAllStars(ptrn,pl);
        
        if(dp[pl][tl]!=-1) return dp[pl][tl];
        
        if(ptrn.charAt(pl-1)==txt.charAt(tl-1) || ptrn.charAt(pl-1)=='?') return dp[pl][tl] = fun(ptrn,txt,pl-1,tl-1,dp);
        if(ptrn.charAt(pl-1)=='*') return dp[pl][tl] = (fun(ptrn,txt,pl-1,tl,dp)==1 || fun(ptrn,txt,pl,tl-1,dp)==1) ? 1 : 0;
        
        return dp[pl][tl] = 0;
    }
    
    static int isAllStars(String s, int l){
        int f = 1;
        for(int i=0; i<l; i++) if(s.charAt(i)!='*') f=0;
        
        return f;
    }
}
```

## Tabulation
```java
import java.util.*;
public class Solution {
	public static boolean wildcardMatching(String ptrn, String txt) {
		// Write your code here.
        int pl = ptrn.length(), tl = txt.length();
        boolean dp[][]=new boolean[pl+1][tl+1];
        
        dp[0][0] = true; // if(pl==0 && tl==0) return 1;
        for(int j=1; j<=tl; j++) dp[0][j] = false; // if(pl==0 && tl>0) return 0;
        for(int i=1; i<=pl; i++) dp[i][0] = isAllStars(ptrn,i); // if(pl>0 && tl==0) return isAllStars(ptrn,pl);
        
        
        
        for(int i = 1; i<=pl; i++){
            for(int j = 1; j<=tl; j++){
                if(ptrn.charAt(i-1)==txt.charAt(j-1) || ptrn.charAt(i-1)=='?') dp[i][j] = dp[i-1][j-1];
                else if(ptrn.charAt(i-1)=='*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
        
                else dp[i][j] = false;
            }
        }
        
        
        
        return dp[pl][tl];
	}
    
        
    static boolean isAllStars(String s, int l){
        boolean f = true;
        for(int i=0; i<l; i++) if(s.charAt(i)!='*') f=false;
        
        return f;
    }
}
```
## Space optimized
```java
import java.util.*;
public class Solution {
	public static boolean wildcardMatching(String ptrn, String txt) {
		// Write your code here.
        int pl = ptrn.length(), tl = txt.length();
        boolean ur[]=new boolean[tl+1];
        
        ur[0] = true; // if(pl==0 && tl==0) return 1;
        for(int j=1; j<=tl; j++) ur[j] = false; // if(pl==0 && tl>0) return 0;

        for(int i = 1; i<=pl; i++){
            boolean curr[]=new boolean[tl+1];
            curr[0] = isAllStars(ptrn,i); // if(pl>0 && tl==0) return isAllStars(ptrn,pl);
            for(int j = 1; j<=tl; j++){
                if(ptrn.charAt(i-1)==txt.charAt(j-1) || ptrn.charAt(i-1)=='?') curr[j] = ur[j-1];
                else if(ptrn.charAt(i-1)=='*') curr[j] = ur[j] || curr[j-1];
        
                else curr[j] = false;
            }
            ur = curr;
        }
        return ur[tl];
	}
    
    static boolean isAllStars(String s, int l){
        boolean f = true;
        for(int i=0; i<l; i++) if(s.charAt(i)!='*') f=false;
        
        return f;
    }
}
```
