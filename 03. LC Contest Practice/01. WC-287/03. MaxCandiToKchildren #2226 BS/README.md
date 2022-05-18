# [**2226. Maximum Candies Allocated to K Children**](https://leetcode.com/problems/maximum-candies-allocated-to-k-children/)

## Approach 1 : use BS
- each children can get minimum 0 candies and maximum 10<sup>7</sup> candies.
- let say ```m``` candiesPerChild.
- so ```no.Of.subPiles extracted from each candies[i] = candies[i]/m``` if ```m``` candiesPerChild. 
- now the sum of all ```subPilesExtracted``` say it ```countP```
    ```
     now if we consider to distribute m candiesPerChild then it is capable to be distributed among countP children.
    ```
- so we will compare countP with K as we have to divide candies among K children
    - if countP < k means per person should get less candy so decrease m
    - else increase m     
```java
class Solution {
    public int maximumCandies(int[] candies, long k) {
     int l=0; int r=10_000_000;
        
        while(l<r){
            int m = (l+r+1)/2; // candiesPerPerson
            long countP=0;
            for(int a: candies) countP+=a/m; // no. of sub-piles possible if m candiesPerPerson
            
            if(countP<k) r=m-1; // decrease m
            else l=m; // increase m
        }
        return l;
    }
}
```