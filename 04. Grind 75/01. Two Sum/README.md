# [Two Sum](https://leetcode.com/problems/two-sum/)
## Intution
- Sorting array will not work 
- so we use hashmap
- Here for every arr[i]
	- we will store (RemainingNeed, i) only if this arr[i] is not the RemainingNeed for any other element.
```java
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        HashMap<Integer, Integer> hm=new HashMap<>(); // remaining index
        hm.put(target-arr[0],0);
        
        for(int i = 1; i<n; i++){
            if(hm.containsKey(arr[i])){
                return new int[]{hm.get(arr[i]), i};
            }
            hm.put(target-arr[i], i);
        }
        return new int[]{-1,-1};
    }
}
```