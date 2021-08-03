# **[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)**
**[Video Reference](https://youtu.be/DK5OKKbF6GI)**
```java
class Solution {
    int resultStart;
    int resultLength;
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        
        for(int i=0; i<s.length(); i++){
            expandRange(s,i,i); // for odd length substring
            expandRange(s,i,i+1); // for even length substring
        }
        return s.substring(resultStart,resultLength+resultStart);
    }
    private void expandRange(String s, int start, int end){
        while(start>=0 && end < s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if((end-start-1) > resultLength){
            resultLength=end-start-1;
            resultStart=start+1;
        }
    }
}
```