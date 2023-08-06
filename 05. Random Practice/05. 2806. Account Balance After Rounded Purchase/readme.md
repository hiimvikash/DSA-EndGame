# [2806. Account Balance After Rounded Purchase](https://leetcode.com/problems/account-balance-after-rounded-purchase/)

```java
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        // the approach is : 
        /**
        ATQ if
        purchaseAmt = 13 then roundedValue is 10(13-3) pa = 24 then roundedValue 20(24-4)
        purchaseAmt is 25 then roundedValue is 30
         */

         int ld = purchaseAmount % 10;
         if(ld >=5){
             int howMuchLessthen10 = 10-ld;
             purchaseAmount+=howMuchLessthen10;
         }
         if(ld < 5) purchaseAmount -=ld;
        
        return 100 - purchaseAmount;
    }
}
```