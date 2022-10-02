# [46. Permutations](https://leetcode.com/problems/permutations/)

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        fun(nums, nums.length,0, ans);
        
        return ans;
    }
    
    public void fun(int arr[], int n, int ind, List<List<Integer>> ans){
        if(ind == n){
            List<Integer> subans=new ArrayList<>();
            for(int ele : arr) subans.add(ele);
            
            ans.add(subans);
            return;
        }
        
        for(int i = ind; i<n; i++){
            swap(arr,ind,i);
            fun(arr,n,ind+1,ans);
            swap(arr,ind,i);
        }
    }
    
    private void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```