# [**696. Count Binary Substrings**](https://leetcode.com/problems/count-binary-substrings/)
## [**Video Reference**](https://youtu.be/MGPHPadxhtQ)
```java
class Solution {
    public int countBinarySubstrings(String s) {
        int ans=0, prevcount=0, currcount=1,  i=1, n=s.length();
        while(i<n){
            if(s.charAt(i)==s.charAt(i-1)) currcount++;
            else{
                ans+=Math.min(prevcount,currcount);
                prevcount=currcount;
                currcount=1;
            }
            i++;
        }
        return ans+=Math.min(prevcount,currcount);
    }
}
```