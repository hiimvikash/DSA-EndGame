# [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

```java
class Solution {
    public List<Integer> findAnagrams(String str, String p) {
        int n = str.length(); int k = p.length(); // ws
        List<Integer> ans=new ArrayList<>();
        if(k>n) return ans;
        
        // create freq HM for p
        HashMap<Character, Integer> hm=new HashMap<>();
        for(char c : p.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        int existence = hm.size();
        
        // create initial ans
        
        int s = 0, e = k-1;
        
        // exploring full window initially
        for(int i = s; i<=e; i++){
            char c = str.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)-1);
                if(hm.get(c)==0) existence--;
            }
        }
        if(existence==0) ans.add(s);
        
        // removing calc of s
        char sch = str.charAt(s); // starting character
        if(hm.containsKey(sch)){
            hm.put(sch, hm.get(sch)+1);
            if(hm.get(sch)==1) existence++;
        }
        
        s++; e++;
        
        while(e<n){
            char c = str.charAt(e);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)-1);
                if(hm.get(c)==0) existence--;
            }
            if(existence==0) ans.add(s);
            
            char sc = str.charAt(s); // starting character
            if(hm.containsKey(sc)){
                hm.put(sc, hm.get(sc)+1);
                if(hm.get(sc)==1) existence++;
            }

            s++; e++;
        }
        return ans;
    }
}
```
[Video reference](https://youtu.be/MW4lJ8Y0xXk)