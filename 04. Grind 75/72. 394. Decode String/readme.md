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

# reccursion
```java
class Solution {
    public String decodeString(String s) {
        Queue<Character> q=new LinkedList<>();
        for(char c : s.toCharArray()) q.add(c);
        
        return helper(q);
    }
    
    String helper(Queue<Character> q){
        
        int num = 0;
        StringBuilder sb=new StringBuilder();
        
        while(!q.isEmpty()){
            char c = q.remove();
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }
            else if(c == '['){
                String sub = helper(q);
                for(int i = 0; i<num; i++) sb.append(sub);
                num = 0;
            }
            else if(c == ']') break;
            else sb.append(c);
        }
        return sb.toString();
    }
}
```