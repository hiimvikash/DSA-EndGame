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
# **[5. Combination Sum II LC-40](https://leetcode.com/problems/combination-sum-ii/)**
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
# **[6. Palindrome Partitioning LC-131](https://leetcode.com/problems/palindrome-partitioning/)**
- **[Video reference](https://youtu.be/WBgsABoClE0)**
```java
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        fun(0,s,new ArrayList<>(),ans);
        return ans;
    }
    public void fun(int ind, String s, List<String> subans, List<List<String>>ans){
        if(ind==s.length()){
            ans.add(new ArrayList<>(subans));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(ind,i,s)){
                subans.add(s.substring(ind,i+1));
                fun(i+1,s,subans,ans);
                subans.remove(subans.size()-1);
            }
        }
    }
    
    
    private boolean isPalindrome(int s, int e, String str){
        while(s<e){
            if(str.charAt(s++)!=str.charAt(e--))
                return false;
        }
        return true;
    }
}
```
# **[7. Kth Permutation Sequence LC-60](https://leetcode.com/problems/permutation-sequence/)**
- **[Video Reference](https://youtu.be/wT7gcXLYoao)**
```java
class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        ArrayList<Integer> nums=new ArrayList<>();
        // Step 1 : find factorial of n-1 element and store n elements in nums.
        for(int i=1;i<n;i++){
            fact*=i;
            nums.add(i);
        }
        nums.add(n);
        
        String ans="";
        k=k-1;
        while(true){
            ans+=nums.get(k/fact);
            nums.remove(k/fact);
            if(ans.length()==n) break;
            k=k%fact;
            fact=fact/nums.size();
        }
        return ans;
    }
}
```
# **[8. Print all Permutations of String/Array LC-46](https://leetcode.com/problems/permutations/)**

## Approach 0 : Recursion + Prefix StackOveflow
```java
public static void permutation(String str) { 
    permutation("", str); 
}

private static void permutation(String prefix, String str) {
    int n = str.length();
    if (n == 0) System.out.println(prefix);
    else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
    }
}
```

## Approach 1 : Recursion using extra space
- **[Video Reference](https://youtu.be/YK78FU5Ffjw)**
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean vis[]=new boolean[nums.length];
        fun(nums,ans,new ArrayList<>(),vis,nums.length);
        return ans;
    }
    void fun(int nums[],List<List<Integer>> ans, List<Integer>ds, boolean vis[], int n ){
        if(ds.size()==n){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                ds.add(nums[i]);
                fun(nums,ans,ds,vis,n);
                vis[i]=false;
                ds.remove(ds.size()-1);
            }
        }
    }
}
```
## Approach 2 : Recursion using swap Technique, W/O using extra space
- **[Video Reference](https://youtu.be/f2ic2Rsc9pU)**
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        fun(0,nums,ans);
        return ans;
    }
    public void fun(int ind, int nums[], List<List<Integer>> ans){
        if(ind==nums.length){
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(ind,i,nums);
            fun(ind+1,nums,ans);
            swap(ind,i,nums);
        }
    }
    private void swap(int i, int j, int arr[]){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
```
# **[9. Sudoku Solver LC-37](https://leetcode.com/problems/sudoku-solver/)**
- **[Video Reference](https://youtu.be/FWAIf_EVUKE)**
```java
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='.'){
                    for(char num='1'; num<='9'; num++){
                        if(isValid(board,i,j,num)){
                            board[i][j]=num;
                            if(solve(board)==true) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char board[][], int row, int col, char num){
        for(int i=0; i<9; i++){
           if(board[row][i]==num) return false; // checking across the rows
           if(board[i][col]==num) return false; // checking across the column
           if(board[(row/3)*3 + i/3][(col/3)*3 + i%3]==num) return false; // checking across subboard. 
        }
        return true;
    }
}
```
# **[10. M-Coloring Problem](https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#)**
- **[Video Reference](https://youtu.be/wuVwUK25Rfc)**
```java
class solve 
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] graph, int[] color, int vert, int m) 
    {
        // Your code here
        int n=graph.length;
        if(vert==n) return true;
        for(int col=1; col<=m; col++){
            if(isSafe(graph,vert,color,col)){
                color[vert]=col;
                if(graphColoring(graph,color,vert+1,m)) return true;
                color[vert]=0;
            }
        }
        return false;
    }
    
    private static boolean isSafe(List<Integer>[] graph, int vert, int color[], int col){
        for(Integer adj: graph[vert]){
            if(color[adj]==col) return false;
        }
        return true;
    }
}
```