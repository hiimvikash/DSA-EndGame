# [394. Decode String](https://leetcode.com/problems/decode-string/)

```java
class Solution {
    public String decodeString(String s) {
        int idx = 0, n = s.length();
        
        Stack<String> resStack=new Stack<>();
        Stack<Integer> numStack=new Stack<>();
        String res = "";
        
        while(idx < n){
                        
            if(Character.isDigit(s.charAt(idx))){
                int num = 0;
                while(Character.isDigit(s.charAt(idx))){
                    num = num*10 + s.charAt(idx)-'0';
                    idx++;
                }
                numStack.push(num);
            }
            else if(s.charAt(idx) == '['){
                resStack.push(res);
                res="";
                idx++;
            }
            else if(s.charAt(idx) == ']'){
                StringBuilder temp=new StringBuilder(resStack.pop());
                int repeatTimes = numStack.pop();
                for(int i = 0; i<repeatTimes; i++) temp.append(res);
                
                res = temp.toString();
                idx++;
            }
            else res+=s.charAt(idx++);
        }
        return res;
    }
}
```