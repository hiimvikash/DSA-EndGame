# [658. Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/)

```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0, j = arr.length-1;
        
        while((j-i+1)!=k){
            if(Math.abs(x-arr[i]) <= Math.abs(x-arr[j])) j--;
            else i++;
        }

        return Arrays.stream(arr, i, i + k).boxed().collect(Collectors.toList());
    }
}
//         List<Integer> res=new ArrayList<>();
//         for(int a = i; a<=j; a++) res.add(arr[a]);
        
//         return res;
```