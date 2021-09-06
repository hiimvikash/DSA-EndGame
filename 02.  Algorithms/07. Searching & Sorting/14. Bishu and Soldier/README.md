# [**Bishu and Soldier**](https://www.hackerearth.com/problem/algorithm/bishu-and-soldiers-227/)

## Naive Approach :- TC - O(N<sup>2</sup>)
- Sort the soldier array
- for each power search for no. of of element less than equal to.- This is our count and simultaneously do sum.
```java
import java.util.*;
class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int round=sc.nextInt();
        int pow;
        for(int i=0;i<round;i++){
            pow=sc.nextInt();
            int j=0,sum=0,count=0;
            while(j<n && arr[j]<=pow){
                count++;
                sum+=arr[j];
                j++;
            }
            System.out.println(count+" "+sum);
        }
    }
}
```
