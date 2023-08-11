# Find the subarray with maximum sum such that the first and last elements are the same.
Example : - 
1. int arr[] = {1, 3, 4, 8, -10, -20, 8, 20, 10, 50, 8}; // --> 96
2. int arr[] = {1, 8, 10, 8, -5, 8}; // --> 29

## Thought Process is : 
## sum[l,r] = sum[r] - prefix[l]
- So to increase the sum[l,r] we need to decrease prefix[l] so we store that ele whose prefixSum is least.
  ![image](https://github.com/hiimvikash/DSA-EndGame/assets/71629248/0229b239-360b-4501-9874-fe72dd4ee03c)




```java
private static int maximumSum(int arr[], int n){
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int prefixSum = 0;
        int bs = 0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            int ele = arr[i];
            
            sum+=ele;
            if(!hm.containsKey(ele)){
                hm.put(ele, prefixSum);
            }else{
                bs = Math.max(bs, sum - hm.get(ele));
                hm.put(ele, Math.min(hm.get(ele), prefixSum));
            }
            prefixSum = sum;
        }
        
        return bs;
}
```
