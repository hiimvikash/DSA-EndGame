**<h1 align="center">Striver SDE Sheet Recursion Qs :-</h1>**
# **[1. Subset LC-78](https://leetcode.com/problems/subsets/)**
```java
class Solution {
    public List<List<Integer>> subsets(int[] arr) {
      List<List<Integer>> ans=new ArrayList<>();
        List<Integer> subans=new ArrayList<>();
        int n=arr.length;
        fun(0,arr,n,subans,ans);
        return ans;
    }
    
    void fun(int ind,int arr[], int n, List<Integer> subans, List<List<Integer>> ans){
        if(ind==n){
            ans.add(new ArrayList<>(subans));
            return;
        }
        
        // pick
        subans.add(arr[ind]);
        fun(ind+1, arr, n,subans,ans);
        // not pick
        subans.remove(subans.size()-1);
        fun(ind+1, arr, n,subans,ans);
        
    }
}
```

# **[2. Subset Sums](https://practice.geeksforgeeks.org/problems/subset-sums2234/1)**
```java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n){
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        fun(0,arr,n,0,ans);
        Collections.sort(ans);
        return ans;
    }
    void fun(int ind,ArrayList<Integer> arr, int n, int sum, ArrayList<Integer> ans){
        if(ind==n){
            ans.add(sum);
            return;
        }
        
        // pick
        sum+=arr.get(ind);
        fun(ind+1,arr,n,sum,ans);
        // not pick
        sum-=arr.get(ind);
        fun(ind+1,arr,n,sum,ans);
    }
}
```
# **[3. Subset- II LC-78](https://leetcode.com/problems/subsets-ii/)**
## Approach 1 : pass your ans through SET_DS to get ans.
```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        fun(0,arr,n,new ArrayList<>(),ans);
        // ans-->SET-->ans we will get unique elements
        Set<List<Integer>> st=new HashSet<>();
        for(List<Integer> un: ans){
            st.add(un);
        }
        ans.clear();
        for(List<Integer> un: st){
            ans.add(un);
        }
        return ans;
    }
    
    void fun(int ind,int arr[], int n, List<Integer> subans, List<List<Integer>> ans){
        if(ind==n){
            ans.add(new ArrayList<>(subans));
            return;
        }
               
        // pick
        subans.add(arr[ind]);
        fun(ind+1, arr, n,subans,ans);
        // not pick
        subans.remove(subans.size()-1);
        fun(ind+1, arr, n,subans,ans);
        
    }
}
```
## Approach 2 : when we will ignore the we will not consider futre coming element with same value. 

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        fun(0,arr,n,new ArrayList<>(),ans,true);
        return ans;
    }
    
    void fun(int ind,int arr[], int n, List<Integer> subans, List<List<Integer>> ans, boolean isIgnore){
        if(ind==n){
            ans.add(new ArrayList<>(subans));
            return;
        }
        
        fun(ind+1, arr, n,subans,ans,true);
        if(ind>0 && arr[ind]==arr[ind-1] && isIgnore) return;   
        
        // pick
        subans.add(arr[ind]);
        fun(ind+1, arr, n,subans,ans,false);
        
        // while returning we have to unpick.
        subans.remove(subans.size()-1);
    }
}
```

## Approach 3 :
if Array is {1,2,2,3,3,4}
- In every recursion call we will add our list in ans.
- so in 0th recursion empty List will be added in ans.
- 1st recursion [1] will be added in ans.
- 2nd recursion [1,2] will be added in ans.
- 3rd recursion [1,2,2] will be added in ans.
- 4th recursion [1,2,2,3] will be added in ans.
- and so on 6th recursion [1,2,2,3,3,4] will be added in ans.
- Now in every backtracking one element from last will be removed and then from that index to nums.length-1 we will check if we can take next element and make a valid subset.
```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        subset(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void subset(int ind, int nums[], List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        
        for(int i=ind; i<nums.length; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            
            ds.add(nums[i]);
            subset(i+1,nums,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}
```
# **[4. Combination Sum I LC-39](https://leetcode.com/problems/combination-sum/)**
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        fun(0,nums,new ArrayList<>(),ans,target);
        return ans;
    }
    public void fun(int ind, int nums[], List<Integer> ds, List<List<Integer>> ans, int target){
        if(ind==nums.length){
            if(target==0)
                ans.add(new ArrayList<>(ds));
            return;    
        }
        //pick
        if(nums[ind]<=target){
            target-=nums[ind];
            ds.add(nums[ind]);
            fun(ind,nums,ds,ans,target);
        
            // not pick
            target+=nums[ind];
            ds.remove(ds.size()-1);
        }
        fun(ind+1,nums,ds,ans,target);
    }
}
```
# **[4. Combination Sum II LC-40](https://leetcode.com/problems/combination-sum-ii/)**
```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        subset(0,nums,new ArrayList<>(),ans,target);
        return ans;
    }
    public void subset(int ind, int nums[], List<Integer> ds, List<List<Integer>> ans,int target){
        if(target==0)
            ans.add(new ArrayList<>(ds));
        
        for(int i=ind; i<nums.length; i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            
            if(nums[i]<=target)
            {   
                target-=nums[i];
                ds.add(nums[i]);
                subset(i+1,nums,ds,ans,target);
                target+=nums[i];
                ds.remove(ds.size()-1);
            }
        }
    }
}
```
