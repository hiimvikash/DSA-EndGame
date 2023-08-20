## [392. Is Subsequence](https://leetcode.com/problems/is-subsequence/description/)

```java
class Solution {
    public boolean isSubsequence(String ss, String ls) {
        // ls -> largeString ss -> smallString
        // is ss is a subsequence of ls ?

        // My Approach
        // find each character of ss in ls, if all found then return true else false

        int i = 0; // lsPointer
        int j = 0; // ssPointer
        int lsn = ls.length();
        int ssn = ss.length();
        if(ssn == 0) return true;

        while(i < lsn){
            char lsc = ls.charAt(i);
            char ssc = ss.charAt(j);

            if(lsc == ssc){
                j++;
            }
            i++;

            if(j == ssn) return true;
        }
        return false;
    }
}
```