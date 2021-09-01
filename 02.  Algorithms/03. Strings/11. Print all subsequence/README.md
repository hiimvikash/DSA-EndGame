# [Print all subsequence in string](https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-subsequence-official/ojquestion)
```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        fun(0,s,"",s.length());
    }

    public static void fun(int ind, String s, String ans, int n) {
        if(ind==n){
            System.out.println(ans);
            return;
        }
        // pick
        ans=ans+s.charAt(ind);
        fun(ind+1, s, ans, n);
        // not pick
        ans=ans.substring(0,ans.length()-1);
        fun(ind+1, s, ans, n);
    }

}
```