**<h1 align="center">Striver SDE Sheet Recursion Qs :-</h1>**

# **[1. Subset Sums](https://practice.geeksforgeeks.org/problems/subset-sums2234/1)**
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
