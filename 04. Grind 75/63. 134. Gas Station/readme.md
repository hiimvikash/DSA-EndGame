# [134. Gas Station]()
## Intution
- ```sum of gas[] >= sum of cost[]```
- ATQ sum of ```(gas[i] - cost[i])``` >=0 for atleat 1 possible answer
- start can't be that ```ith``` pos where ```(gas[i]-cost[i])<0``` 

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=p.length;
        int start=0;
        int ef=0; int rf=0; // extraFuel, requiredFuel
        for(int i=0; i<n; i++){
            ef+=gas[i]-cost[i];
            if(ef<0){
                start=i+1;
                rf+=ef;
                ef=0;
            }
        }
        if(ef+rf>=0) return start;
        return -1;
    }
}
```