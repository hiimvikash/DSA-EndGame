# [**2240. Number of Ways to Buy Pens and Pencils**](https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/)



## My Approach : 
```java
class Solution {
    public long waysToBuyPensPencils(int t, int c1, int c2) {
        if(t<c1 && t<c2) return 1;
        
        int i=0; // pensIBuyedInitially
        long at=t; // available total
        long ans=0; 
        
        while(at>=c1 || at>=c2){
            ans+=(at/c2)+1;
            i++;
            at=t-(i*c1);
        }
        return at<0 ? ans : ans+1; // in last u invested ur total money in buying all c1 so that transaction will be succesfull(ans+1) only if u r left AT>=0.
    }
}
```