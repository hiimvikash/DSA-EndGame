# [2452. Words Within Two Edits of Dictionary](https://leetcode.com/problems/words-within-two-edits-of-dictionary/description/)
```java
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        query:
        for(String q: queries){
            for(String dicWrd : dictionary){
                if(editsRequired(q, dicWrd) <= 2){ 
                    ans.add(q); 
                    continue query;
                }
            }
        }
        return ans;
    }

    private int editsRequired(String a, String b){
        int cnt = 0;
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        return cnt;
    }
}
```