# [longest peak duration](https://www.desiqna.in/12727/adobe-coding-oa-sde-mts-set-8-march-2023)
![image](https://github.com/hiimvikash/DSA-EndGame/assets/71629248/3881c62a-34c3-4922-8975-950fd848a994)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[86401];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            a[l] += 1;
            a[r + 1] -= 1;
        }
        for (int i = 1; i <= 86400; i++) {
            a[i] += a[i - 1];
        }
        int me = Arrays.stream(a).max().getAsInt();
        int st = -1, en = -1;
        for (int i = 1; i <= 86400; i++) {
            if (a[i] == me) {
                int l = i;
                while (a[l] == me) {
                    l++;
                }
                if (l - i > en - st + 1) {
                    st = i;
                    en = l - 1;
                }
                i = l;
            }
        }
        System.out.println(st + " " + en);
        sc.close();
    }
}

```
