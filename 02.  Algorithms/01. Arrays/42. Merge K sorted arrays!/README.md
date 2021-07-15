# **[Merge K sorted arrays!](https://www.interviewbit.com/problems/merge-k-sorted-arrays/)**
# My Intution : - Heap DS SC- O(k)
```java
public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<Integer> ans=new ArrayList<>();
        int k=arr.size();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.add(new Pair(i,0,arr.get(i).get(0)));
        }
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            ans.add(p.data);
            p.di++;
            if(p.di < arr.get(p.ai).size()){
                p.data=arr.get(p.ai).get(p.di);
                pq.add(p);
            }
        }
        return ans;
    }
}
class Pair implements Comparable<Pair>{
    int ai;
    int di;
    int data;
    public Pair(int ai, int di, int data){
        this.ai=ai;
        this.di=di;
        this.data=data;
    }
    @Override
    public int compareTo(Pair o){
        return this.data-o.data;
    }
}

```

## **[Video Reference](https://youtu.be/E5WSILx1q0Q)**