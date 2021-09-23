# [**First non-repeating character in a stream**](https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#)

# Queue Based Approach
```java
public class Solution {
    public String solve(String s) {
        // code here
        int n=s.length();
        String ans="";
        int freq[]=new int[26];
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[(ch-'a')]++;
            if(freq[(ch-'a')]==1) q.add(ch); // giving this if condition will reduce extra checks below
            while(!q.isEmpty()){
                if(freq[q.peek()-'a']==1){
                    ans+=q.peek(); break;
                }
                else q.remove();
            }
            if(q.isEmpty()) ans+='#';
        }
        return ans;
    }
}

```
