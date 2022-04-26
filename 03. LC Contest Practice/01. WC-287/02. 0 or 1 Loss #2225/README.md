# [**2225. Find Players With Zero or One Losses**](https://leetcode.com/problems/find-players-with-zero-or-one-losses/)

## Approach 1 : Use of SET & HASHMAP
```java
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n=matches.length;
        
        Set<Integer> win=new HashSet<>();
        Set<Integer> loose=new HashSet<>();
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<n; i++){
            win.add(matches[i][0]);
            loose.add(matches[i][1]);
            hm.put(matches[i][1], hm.getOrDefault(matches[i][1],0)+1);
        }
        
        // answer[0] = win-loose;
        win.removeAll(loose); // ans[0] made in winSet
        ArrayList<Integer> ans1=new ArrayList<>(win);
        Collections.sort(ans1);
        
        ArrayList<Integer> ans2=new ArrayList<>();
        for(Map.Entry<Integer,Integer> ent : hm.entrySet()){
            if(ent.getValue()==1) ans2.add(ent.getKey());
        } 
        // ans[1] made
        Collections.sort(ans2);
        
        
        List<List<Integer>> answer=new ArrayList<>();
        answer.add(ans1);
        answer.add(ans2);
        
        return answer;
    }
}
```
