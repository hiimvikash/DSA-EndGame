# [**2231. Largest Number After Digit Swaps by Parity**](https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/)

## Approach 1 : 
- Look for a digit on the right that is bigger than the current digit and has the same parity, and swap them.
```(a[j] - a[i]) % 2 == 0``` parity check (true if both a[j] and a[i] are even or both are odd)

```java
class Solution {
    public int largestInteger(int num) {
        char a[]=String.valueOf(num).toCharArray();
        for(int i=0; i<a.length; i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]>a[i] && (a[j]-a[i])%2==0){
                    char t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
        }
        return Integer.parseInt(new String(a));
    }
}
```
