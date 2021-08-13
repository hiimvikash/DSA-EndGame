# **[Permutations of a given string](https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1#)**
## Approach 1 : Using Recursion with extra space.
```java
class Solution {
    public List<String> find_permutation(String s) {
        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        s=String.valueOf(arr);
        // Code here
        List<String> ans=new ArrayList<>();
        fun(s,"",new boolean[s.length()],ans);
        return ans;
    }
    private void fun(String s, String subans, boolean vis[], List<String> ans){
        if(subans.length()==s.length()){
            ans.add(subans);
            return;
        }
        for(int i=0; i<s.length(); i++){
            if(!vis[i]){
                vis[i]=true;
                subans+=s.charAt(i);
                fun(s,subans,vis,ans);
                vis[i]=false;
                subans=subans.substring(0,subans.length()-1);
            }
        }
    }
}
```
## Approach 2 : Using Recursion without extra space.
```java
class Solution {
    public List<String> find_permutation(String s) {
        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        s=String.valueOf(arr);
        // Code here
        List<String> ans=new ArrayList<>();
        fun(0,s,ans);
        return ans;
    }
    private void fun(int ind, String s, List<String> ans){
        if(ind==s.length()){
            ans.add(s);
            return;
        }
        for(int i=ind; i<s.length(); i++){
            s=swap(ind,i,s);
            fun(ind+1,s,ans);
            s=swap(ind,i,s);
        }
    }
    private String swap(int i, int j, String s){
        char arr[]=s.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return String.valueOf(arr);
    }
}
```