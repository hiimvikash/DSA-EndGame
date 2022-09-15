# [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm=new HashMap<>();
        
        // store the frequency of the character of String S
        for(char c : s.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        
        // Now decrease the frequency respectively in HM
        for(char c : t.toCharArray()){
            if(!hm.containsKey(c)) return false;
            else hm.put(c, hm.get(c)-1);
        }
        
        // itterate in HashMap
        for(char c : hm.keySet()){
            if(hm.get(c)!=0) return false;
        }
        return true;
    }
}
```