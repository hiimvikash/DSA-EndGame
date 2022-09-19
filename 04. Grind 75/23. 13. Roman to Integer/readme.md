# [13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/)
```java
class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        HashMap<Character, Integer> hm=new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        
        int ans = hm.get(s.charAt(n-1));
        for(int i = n-2; i>=0; i--){
            int currVal = hm.get(s.charAt(i));
            if(currVal >= hm.get(s.charAt(i+1))){
                ans += hm.get(s.charAt(i));
            }
            else{
                ans = (int)Math.abs(ans - currVal);
            }
            
        }
        return ans;
    }
}
```