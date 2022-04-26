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

## Approach 2 : use treeMap when u want key in sorted order

```java
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // use one HM to keep count of losses
        
        Map<Integer,Integer> hm=new TreeMap<>();
        
        for(int m[]: matches){
            hm.put(m[0], hm.getOrDefault(m[0],0));
            hm.put(m[1], hm.getOrDefault(m[1],0) + 1);
        }
        
        // so basically player with 0 or 1 losses are the only one's who will be in ur ANS.
        List<List<Integer>> answer=new ArrayList<>(); answer.add(new ArrayList<>()); answer.add(new ArrayList<>());
                
        for(Integer player : hm.keySet()){
            if(hm.get(player) <= 1)
                answer.get(hm.get(player)).add(player);
        }
        
        return answer;
    }
}
```