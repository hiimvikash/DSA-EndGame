# **[560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)**


# **My Intution :- TC - O(N) SC - O(N)**

## base of my intution :-
![subArrayK](https://user-images.githubusercontent.com/71629248/123503152-c2548e00-d66e-11eb-8e9c-c688e8df983b.png)

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
## **[Video Reference](https://youtu.be/20v8zSo2v18)**
