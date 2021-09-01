# [**525. Contiguous Array**](https://leetcode.com/problems/contiguous-array/)
```java
class Solution {
    public int findMaxLength(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0)arr[i]=-1;
        }
        HashMap<Integer,Integer> hm=new HashMap<>(); // sum,index
        int sum=0;
        hm.put(sum,-1);
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(!hm.containsKey(sum)) hm.put(sum,i);
            else{
               ans=Math.max(ans,i-hm.get(sum)); 
            }
        }
        return ans;
    }
}
```