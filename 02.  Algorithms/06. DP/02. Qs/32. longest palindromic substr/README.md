# [**Longest Palindromic Substring**](https://nados.io/question/longest-palindromic-substring?zen=true)


## Using memonization
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
