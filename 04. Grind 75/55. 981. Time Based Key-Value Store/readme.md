# [981. Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/)

```java
class TimeMap {
    HashMap<String, ArrayList<Pair>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair> val;
        if(hm.containsKey(key)) val = hm.get(key);
        else val = new ArrayList<>();
        
        val.add(new Pair(value, timestamp));
        hm.put(key, val);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        ArrayList<Pair> val = hm.get(key);
        int n = val.size();
        
        int ind = bsfloor(val,0,n,timestamp);
        if(n==0 || ind == -1) return "";
        return val.get(ind).v;
    }
    
    private static int bsfloor(ArrayList<Pair> a, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = a.get(mid).ts;

            if (midVal<key){
                start = mid + 1;
            }
                
            else if (midVal>key)
                end = mid - 1;
            else
                return mid; // key found
        }
        return end;  
    }
}

class Pair{
    String v; int ts;
    public Pair(String val, int t){
        v = val;
        ts = t;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
```

[video reference](https://youtu.be/fu2cD_6E8Hw)