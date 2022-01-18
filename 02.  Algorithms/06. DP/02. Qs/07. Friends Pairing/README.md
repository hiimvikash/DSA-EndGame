# [**Friends Pairing**](https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/friends-pairing-official/ojquestion)

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        System.out.println(fpp(sc.nextInt()));
    }
    static int fpp(int n){
        int dp[]=new int[n+1];
        
        for(int i=0;i<=n;i++){
            if(i<=2) dp[i]=i;
            else dp[i]=dp[i-1] + (i-1)*dp[i-2];
        }
        return dp[n];
    }
}
```
