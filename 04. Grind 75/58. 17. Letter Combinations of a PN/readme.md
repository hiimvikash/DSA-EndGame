# [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
```java
class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans=new ArrayList<>();
        
        if(n==0) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        fun(digits,0,n,new StringBuilder(), ans, mapping);
        return ans;
    }
    
    public void fun(String digit, int ind, int n, StringBuilder output, List<String> ans, String mapping[]){
        if(ind>=n){
            ans.add(output.toString());
            return;
        }
        
        int num = digit.charAt(ind)-'0';
        String val = mapping[num];
        
        for(char c : val.toCharArray()){
            output.append(c);
            fun(digit, ind+1, n, output, ans, mapping);
            output = output.delete(output.length()-1, output.length());
        }
    }
     
}
```
[Video Reference](https://youtu.be/tWnHbSHwNmA)