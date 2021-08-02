# **[38. Count and Say](https://leetcode.com/problems/count-and-say/)**
**[video reference](https://youtu.be/1YUqtoT9YoE)**
```java
class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        int count=1;
        String s="11&";
        String ans="";
        int i=2;
        while(i++ < n){
            ans="";
            for(int j=1; j<s.length(); j++){
                if(s.charAt(j)==s.charAt(j-1)) count++;
                else{
                    ans+=String.valueOf(count)+s.charAt(j-1);
                    count=1;
                }
            }
            s=ans+'&';
        }
        return ans;
    }
}
```