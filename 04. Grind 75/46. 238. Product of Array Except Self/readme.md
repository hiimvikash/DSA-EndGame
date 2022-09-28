# [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

```java
class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        
        // find prefix product for each index except that index
        int prevP = 1;
        for(int i = 0; i<n; i++){
            ans[i] = prevP;
            prevP*=arr[i];
        }
        
        // find suffix product for each index except that index
        int afP = 1;
        for(int i = n-1; i>=0; i--){
            ans[i]*= afP;
            afP*= arr[i];
        }
        
        return ans;
    }
}
```