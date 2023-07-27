#### **Problem Link:** [Build an Array With Stack Operations #1441](https://leetcode.com/problems/build-an-array-with-stack-operations/)

#### **Solution Link:** [Build an Array With Stack Operations #1441 solution](./Solution.java)
TCs : [5,8,10] n = 15
- run a loop from 1 to n
- if not matched with target[idx] then push pop both
- else only push and idx++;
```java
class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> ans = new ArrayList<String>();
        int idx=0;
        for(int i = 1; i<=n; i++){
            if(idx==target.length) break;
            if(i!=target[idx]){
                ans.add("Push");
                ans.add("Pop");
            }else{
                ans.add("Push");
                idx++;
            }
        }
        return ans;
    }
}
```
