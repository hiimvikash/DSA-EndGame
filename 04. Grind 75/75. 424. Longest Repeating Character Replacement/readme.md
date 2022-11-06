# [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
```java
class Solution {
    public int characterReplacement(String str, int k) {
        // for every window we r going to maintain 'length of substr' & 'freq of maximum occuring character'
        int n = str.length();
        int s = 0,e = 0;
        int l = 0, fmoc = 0; // freq of maximum occuring character
        HashMap<Character, Integer> hm=new HashMap<>();
        int ans = 0;
        while(e<n){
            char c = str.charAt(e);
            hm.put(c, hm.getOrDefault(c,0)+1);
            fmoc = Math.max(fmoc, hm.get(c));
            l++;
            
            if(l-fmoc <= k) ans = Math.max(l,ans);
            else{
                char sc = str.charAt(s);
                hm.put(sc, hm.get(sc)-1);
                if(hm.get(sc)==0) hm.remove(sc);
                s++; l--;
                for(char ch : hm.keySet()) fmoc = Math.max(fmoc, hm.get(ch));
            }
             e++;
        }
        return ans;
    }
}

/**
The problem says that we can make at most k changes to the string (any character can be replaced with any other character). So, let's say there were no constraints like the k. Given a string convert it to a string with all same characters with minimal changes. The answer to this is

length of the entire string - number of times of the maximum occurring character in the string

Given this, we can apply the at most k changes constraint and maintain a sliding window such that

(length of substring - number of times of the maximum occurring character in the substring) <= k
**/
```