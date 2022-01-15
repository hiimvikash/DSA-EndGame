# [**Count Of Valleys And Mountains**](https://pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-valleys-mountains-official/ojquestion)

```java
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(nvm(n));
    
 }
 static int nvm(int n){
    int dp[]=new int[n+1];
    dp[0]=dp[1]=1;
    
    for(int i=2;i<=n;i++){
        for(int j=0; j<i; j++){
            dp[i]+=dp[j]*dp[i-j-1];
        }
    }
    return dp[n];
 }
}
```
# [**Count Brackets**](https://pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-brackets-official/ojquestion)
# [**Count chords**](https://pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/circle-and-chords-official/ojquestion)