# [**Longest Palindromic Substring**](https://nados.io/question/longest-palindromic-substring?zen=true)


## Using tabu
 ```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        System.out.println(longestCommonSubstr(s,reverseWord(s),n,n));
    }
    static int longestCommonSubstr(String s1, String s2, int n1, int n2){
        // code here
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
    private static String reverseWord(String str)
    {
        // Reverse the string str
        //Your code here
      char arr[]=str.toCharArray();
      int s=0;
      int e=arr.length-1;
  
      while(s<e){
          char temp=arr[s];
          arr[s]=arr[e];
          arr[e]=temp;
          s++;
          e--;
      }
      return String.valueOf(arr);
  }

}
```
## PepCo Sol.
```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        
        int ans=-1;
        boolean dp[][]=new boolean[n][n];
        for(int g=0; g<n; g++){
            int f=0;
            for(int i=0,j=g; i<n-g; i++,j++){
                if(g==0) dp[i][j]=true;
                else if(g==1) dp[i][j]=s.charAt(i)==s.charAt(j)?true:false;
                else{ 
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) dp[i][j]=true;
                }
                if(dp[i][j]) f=1;
            }
            if(f==1)ans=Math.max(ans,g);
        }
        System.out.println(ans+1);
    }
}
```