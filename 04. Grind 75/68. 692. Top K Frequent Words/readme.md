# [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)

```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // freq of words
        HashMap<String, Integer> hm=new HashMap<>();
        for(String word : words) hm.put(word, hm.getOrDefault(word,0)+1);
        // adding entries in list for sorting
        List<Map.Entry<String, Integer>> l=new ArrayList<>();
        for(Map.Entry<String, Integer> e : hm.entrySet()) l.add(e);
        Collections.sort(l, (e1,e2)-> (e2.getValue()!=e1.getValue())?e2.getValue()-e1.getValue(): e1.getKey().compareTo(e2.getKey()));
        // making answer
        List<String> ans=new ArrayList<>();
        for(int i = 0; i<k; i++) ans.add(l.get(i).getKey());
        
        return ans;
    }
}
```