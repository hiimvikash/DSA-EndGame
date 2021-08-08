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