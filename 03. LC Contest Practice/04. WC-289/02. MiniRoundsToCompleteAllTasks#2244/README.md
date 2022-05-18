# [**2244. Minimum Rounds to Complete All Tasks**](https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/)

### **Hint : Whenever you divide anything by 3 we get remainder as 0,1 or 2 only.**

## My Approach : 
```java
class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int e : tasks) hm.put(e,hm.getOrDefault(e,0)+1);
        
        int ans=0;
        for (Map.Entry<Integer, Integer> ent :hm.entrySet()) {
            if(ent.getValue()==1) return -1;
            
            int cnt = 0;
            if(ent.getValue()>=3) cnt = (ent.getValue())/3;
            if((ent.getValue())%3!=0) cnt++; // possible remainder is (1,2) and in both case count will increase by 1 only
            
            ans+=cnt;
        }
        return ans;
        
    }
}
```
## [**Video Reference**](https://youtu.be/Bo9pK8Ob5Uc)