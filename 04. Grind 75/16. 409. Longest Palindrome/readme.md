# [409. Longest Palindrome](https://leetcode.com/problems/longest-palindrome/)
## Intution
- int ans = 0;
- Add all the even frequencies in ANS.
- Now for odd frequencies
    - ADD a ```maximum of all odd'sFREQs``` in ANS
    - and ADD ```(remainingOdd's freqs - 1)``` for each character in ANS
```java
class Solution {
    public int longestPalindrome(String s) {
        
        HashMap<Character, Integer> hm=new HashMap<>();
        for(char c : s.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        
        
        int ans = 0, f = 0;
        for(char c : hm.keySet()){
            if(hm.get(c)%2==0) ans=ans + hm.get(c);
            else{
                f=1;
                ans += hm.get(c)-1;
            }
        }
        if(f==1) ans++;
        return ans;
    }
}
```