# [39. Combination Sum](https://leetcode.com/problems/combination-sum/)

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        cs(candidates,candidates.length,target, new ArrayList<>(), ans);
        return ans;
    }
    
    private void cs(int arr[], int n, int target, List<Integer> subans, List<List<Integer>> ans){
        if(n==0){
            if(target == 0) ans.add(new ArrayList<>(subans));
            return;
        }
        
        if(arr[n-1]<=target){
            subans.add(arr[n-1]);
            cs(arr,n,target-arr[n-1],subans,ans);
            
            subans.remove(subans.size()-1);
        }
        cs(arr,n-1,target,subans,ans);
    }
}
```