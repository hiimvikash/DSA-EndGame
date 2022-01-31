# [**139. Word Break**](https://leetcode.com/problems/word-break/)

## Using memonization
 ```java
class Solution {
    HashMap<String,Boolean> dp=new HashMap<>();
    public boolean wordBreak(String A, List<String> B) {
        int n=A.length();
        //code here
        if(n==0) return true;
        if(B.contains(A)) return true;
        if(dp.containsKey(A)) return dp.get(A);
        for(int i=1;i<=n;i++){
            if(B.contains(A.substring(0,i)) && wordBreak(A.substring(i,n),B)){ dp.put(A,true); return true; }
        }
        dp.put(A,false); return false;
    }
} 
```
