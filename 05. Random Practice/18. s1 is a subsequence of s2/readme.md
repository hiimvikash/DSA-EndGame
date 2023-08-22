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

## [2825. Make String a Subsequence Using Cyclic Increments](https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description/)

```java
class Solution {
    public boolean canMakeSubsequence(String ls, String ss) {
        // ls -> largeString ss -> smallString
        // ls = "aglmxztw" ss = "gax"
        // is ss is a subsequence of ls, if we r allowed to increment each character of ls atleast by 1 only once.

        int lsn = ls.length();
        int ssn = ss.length();

        int i = 0; // lsPointer
        int j = 0; // ssPointer

        while(i < lsn){
            char lsc = ls.charAt(i);
            char ssc = ss.charAt(j);

            if(lsc == ssc || (lsc == 'z' && ssc == 'a') || lsc + 1 == ssc){
                j++;
            }
            i++;
            if(j == ssn) return true;
        }
        return false;
    }
}
```