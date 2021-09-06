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
## BS Approach :- TC - O(NLogN)
- Here we make prefixSum[]
- Find floor for each power
- DO +1 in floor to get count
- prefixSum[count-1] is Sum.
```java
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int prefixSum[]=new int[n];
        int temp=0;
        for(int i=0;i<n;i++){
           prefixSum[i]=arr[i]+temp;
           temp=prefixSum[i]; 
        }
        int round=sc.nextInt();
        int pow;
        for(int i=0;i<round;i++){
            pow=sc.nextInt();
            int count = binarySearch(arr,0,n,pow)+1;
            System.out.println(count+" "+prefixSum[count-1]);
        }
        

    }
    private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = a[mid];

            if (midVal<key){
                start = mid + 1;
            }
                
            else if (midVal>key)
                end = mid - 1;
            else return mid;    
            
        }
        return end;
    }  
}

```