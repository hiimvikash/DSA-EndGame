# [528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/)

```java
class Solution {
    int ps[]; // prefix sum

    public Solution(int[] w) {
        ps = new int[w.length];
        ps[0] = w[0];
        for(int i = 1; i<w.length; i++) ps[i] = ps[i-1]+w[i];
    }
    
    public int pickIndex() {
        int max = ps[ps.length - 1];
        int l = 0, h = ps.length-1;
        int target = (int)Math.floor(Math.random()*(max)+1);
        while(l<=h){
            int mid = (l+h)/2;
            if(ps[mid] == target) return mid;
            else if(target > ps[mid]) l = mid+1;
            else h = mid-1;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```
[video reference](https://youtu.be/3Ky9ZlI95cY)