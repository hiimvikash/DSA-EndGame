# [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)
## Intution : Make frq[] for each string
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm=new HashMap<>();
        for(String s : strs){
            char f[]=new char[26];
            for(char c : s.toCharArray()) f[c-'a']++;
            String sk = String.valueOf(f);
            if(!hm.containsKey(sk)) hm.put(sk,new ArrayList<>());
            hm.get(sk).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}
```