# **[560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)**


# **My Intution :- TC - O(N) SC - O(N)**

## base of my intution :-
![subArrayK](https://user-images.githubusercontent.com/71629248/123503152-c2548e00-d66e-11eb-8e9c-c688e8df983b.png)

```java
class Solution {
    public int subarraySum(int[] arr, int k) {
        int count=0,sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>(); // sum,frequency
        hm.put(sum,1);
        for(int ele : arr){
            sum+=ele;
            if(hm.containsKey(sum-k)) count+=hm.get(sum-k);
            hm.put(sum,hm.getOrDefault(sum,0)+1); // this is below count, because let say k=0 then after adding 1st element in hm hm.contains will return true for that element and count will increment. 
        }
        return count;
    }
}
```
## **[Video Reference](https://youtu.be/20v8zSo2v18)**
