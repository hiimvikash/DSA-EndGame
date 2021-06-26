# **[560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)**


# **My Intution :- TC - O(N) SC - O(N)**

## base of my intution :-

```java
class Solution {
    public int subarraySum(int[] arr, int k) {
        int count=0,sum=0,n=arr.length;
        HashMap<Integer,Integer> sf=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int seenS=sum-k; // seen sum
            if(sf.containsKey(seenS)){
                count+=sf.get(seenS);
            }
            sf.put(sum,sf.getOrDefault(sum,0)+1);
            if(sum==k) count++;
        }
        return count;
    }
}
```
