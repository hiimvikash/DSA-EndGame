# [**2094. Finding 3-Digit Even Numbers**](https://leetcode.com/problems/finding-3-digit-even-numbers/)
```java
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> freqHm=new HashMap<>();
        for(int d: digits){
            freqHm.put(d,freqHm.getOrDefault(d,0)+1);
        }
        
        for(int i=100; i<=998; i+=2){
            if(i%2==0 && canContain(i,freqHm)) ans.add(i);
        }
        
        int op[]=new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            op[i]=ans.get(i);
        }
        return op;
    }
    
    boolean canContain(int num, HashMap<Integer,Integer> freqHm){
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(num!=0){
            int d=num%10;
            hm.put(d,hm.getOrDefault(d,0)+1);
            num/=10;
        }
        
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            
            if(freqHm.containsKey(key) && val<=freqHm.get(key)) continue;
            return false;
            
        }
        return true;
    }
}
```