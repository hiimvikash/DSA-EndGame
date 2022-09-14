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
## dp[i] = signifies the LIS till ith that ends with arr[i]
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


# [2. Print LIS](https://takeuforward.org/data-structure/printing-longest-increasing-subsequence-dp-42/)
```java
import java.util.*;
public class Solution {

    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        int n = arr.length;
        int dp[]=new int[n];
        int hm[]=new int[n];
        int bsi = 0; // backtrack start index
        int ans=dp[0]=1;
        for(int i=1;i<n;i++){
            int max=0;
            hm[i] = i;
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i]){ 
                    if(dp[j]>max){
                        max = dp[j];
                        hm[i] = j;
                    }
                }
            }
            dp[i]=max+1;
            if(dp[i]>ans){
                ans = dp[i];
                bsi = i;
            }
            
        }
        ArrayList<Integer> ansl=new ArrayList<>();
        while(hm[bsi]!=bsi){
            ansl.add(arr[bsi]);
            bsi = hm[bsi];
        }
        ansl.add(arr[bsi]);
        
        Collections.reverse(ansl);
        return ansl; 
    }
}
```


# [3. LIS using BS working GQQQ](https://www.codingninjas.com/codestudio/problems/longest-increasing-subsequence_630459)
```java
import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[0]);
        int len = 1;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > temp.get(temp.size()-1)){ 
                temp.add(arr[i]); 
                len++;
            }
            else {
                int ind = lowerB(temp,arr[i]); // index which is just greater than arr[i]; 
                temp.set(ind,arr[i]);
            }
        }
        return len;
	}
    static int lowerB(ArrayList<Integer> al, int x){
        int s = 0; int e = al.size()-1;
        
        while(s<=e){
            int mid  = s +(e-s)/2;
            
            if(x>al.get(mid)) s = mid+1;
            else if(x<al.get(mid)) e = mid-1;
            else return mid;
        }
        return s;
    }

}
```
[Reference](https://takeuforward.org/data-structure/longest-increasing-subsequence-binary-search-dp-43/)

# [4. Print Longest Divisible Subset GQ](https://www.codingninjas.com/codestudio/problems/divisible-set_3754960)
## Tabulation
```java
import java.util.*;
public class Solution {
    public static ArrayList<Integer> divisibleSet(int arr[]) {
        // Write your code here..
        Arrays.sort(arr);
        int n = arr.length;
        int dp[]=new int[n];
        int hm[]=new int[n];
        int bsi = 0; // backtrack start index
        int ans=dp[0]=1;
        for(int i=1;i<n;i++){
            int max=0;
            hm[i] = i;
            for(int j=i-1; j>=0; j--){
                if(arr[i]%arr[j]==0){ // 
                    if(dp[j]>max){ // longest
                        max = dp[j];
                        hm[i] = j;
                    }
                }
            }
            dp[i]=max+1;
            if(dp[i]>ans){
                ans = dp[i];
                bsi = i;
            }
            
        }
        ArrayList<Integer> ansl=new ArrayList<>();
        while(hm[bsi]!=bsi){
            ansl.add(arr[bsi]);
            bsi = hm[bsi];
        }
        ansl.add(arr[bsi]);
        
        Collections.reverse(ansl);
        return ansl;
        
    }

}
```
[Reference](https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/)


# [5. LStringChain](https://www.codingninjas.com/codestudio/problems/longest-string-chain_3752111)

```java
import java.util.*;
public class Solution {
	public static int longestStrChain(int n, String[] arr) {
		// Write your code here.
        Arrays.sort(arr,(a,b)-> a.length()-b.length());
        int dp[]=new int[n];
        dp[0]=1;
        
        int ans = 1;
        for(int i =1; i<n; i++){
            int max = 0;
            for(int j = i-1; j>=0; j--){
                if(isOneLess(arr[i],arr[j])){
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max+1;
            ans = Math.max(dp[i],ans);
        }
        return ans;
	}
    
    static boolean isOneLess(String b, String s){
        int bl = b.length(), sl = s.length();
        if(sl+1!=bl) return false;
        int i = 0, j=0;
        
        while(i<bl){
            if(j<sl && b.charAt(i)==s.charAt(j)){i++; j++;}
            else i++;
        }
        return i==bl && j==sl;
    }
}
```
[Reference](https://www.codingninjas.com/codestudio/problems/longest-string-chain_3752111)







# [6. Longest Bitonic Subsequence](https://www.codingninjas.com/codestudio/problems/longest-bitonic-sequence_1062688)
## Tabulation
```java
public class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        // Step 1 : Make LIS[] from LtoR where each LIS[i] denotes length of LIS which should ends with arr[i]
       
       int lis[]=new int[n];
       lis[0]=1;
       
       for(int i=1; i<n; i++){
           int max=0;
           for(int j=i-1; j>=0; j--){
               if(arr[i]>arr[j]) max=Math.max(lis[j],max);
           }
           lis[i]=max+1;
       }
       
       // Step 2 : Make LDS[] from RtoL where each LDS[i] denotes length of LDS which should starts with arr[i]
       
       int lds[]=new int[n];
       lds[n-1]=1;
       
       for(int i=n-2; i>=0; i--){
           int max=0;
           for(int j=i+1; j<n; j++){
               if(arr[i]>arr[j]) max=Math.max(lds[j],max);
           }
           lds[i]=max+1;
       }
       
       int ans=1;
       
       for(int i=0; i<n; i++){
           ans=Math.max(ans,lds[i]+lis[i]-1);
       }
       return ans;
    }
}
```
[Video Reference](https://youtu.be/jdfpGSSyN2I)







# [7. Count Number of LIS](https://www.codingninjas.com/codestudio/problems/number-of-longest-increasing-subsequence_3751627)

## SOL
```java
public class Solution {
	public static int findNumberOfLIS(int n, int[] arr) {
		// Write your code here.
        int dp[]=new int[n];
        int cnt[]=new int[n];
        cnt[0] = 1;
        int ans=dp[0]=1;
        
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i] && dp[j] > max){
                    max = dp[j];
                    cnt[i] = cnt[j];
                }
                else if(arr[j]<arr[i] && dp[j] == max){
                    cnt[i]+=cnt[j];
                }
                
            }
            dp[i]=max+1;
            ans=Math.max(dp[i],ans);
            if(cnt[i]==0) cnt[i]=1;
      }
        int cntans = 0;
        for(int i = 0; i<n; i++){
            if(dp[i]==ans) cntans+=cnt[i];
        }
        return cntans;
	}
}
```
