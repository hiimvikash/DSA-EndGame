# [**Maximum difference of zeros and ones in binary string**](https://practice.geeksforgeeks.org/problems/maximum-difference-of-zeros-and-ones-in-binary-string4111/1#)

## Intution 
- convert 0 to 1 & 1 to -1
- apply kadanes algo
 ```java
class Solution {
    int maxSubstring(String s) {
        // code here
        int sum=0,bs=-1;
        for(char ch: s.toCharArray()){
            int val=ch-'0';
            val=val==0?1:-1;
            
            if(sum>=0){
                sum+=val;
            }else sum=val;
            bs=Math.max(sum,bs);
        }
        return bs;
    }
}
```
## [**video reference**](https://youtu.be/_k_Codwq1ls)