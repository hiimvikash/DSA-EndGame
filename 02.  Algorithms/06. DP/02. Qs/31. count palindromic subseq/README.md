# [**Count Palindromic Subsequences**](https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/cps-official/ojquestion)

![](https://media.geeksforgeeks.org/wp-content/uploads/20190804162927/00011.jpg)


## Using memonization
 ```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=str.length();
       // Your code here
       int dp[][]=new int[n][n];
       for(int d[]: dp) Arrays.fill(d,-1);
       System.out.println(c(str,0,str.length()-1,dp));
    }
    static int c(String s, int i, int j, int dp[][]){
       if(i>j) return 0;
       if(dp[i][j]!=-1) return dp[i][j];
       if(i==j) return dp[i][j]=1;
       
       if(s.charAt(i)==s.charAt(j)){
           return dp[i][j]= c(s,i+1,j,dp)+c(s,i,j-1,dp)+1;
       }
       else return dp[i][j]= c(s,i+1,j,dp)+c(s,i,j-1,dp)-c(s,i+1,j-1,dp);
   }

}
```
## Using Tabulation
```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        int dp[][]=new int[n][n];
        
        for(int g=0; g<n; g++){
            for(int i=0, j=g; i<n-g; i++, j++){
                if(g==0){
                    dp[i][j]=1;
                }
                else if(g==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j)?3:2;
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
                    }else dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
 }
```
