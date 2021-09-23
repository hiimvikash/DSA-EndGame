# [**First non-repeating character in a stream**](https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/)

# Queue Based Approach
```java
public class Solution {
    public String solve(String s) {
        // code here
        int n=s.length();
        char ans[]=new char[n];
        int freq[]=new int[26];
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[(ch-'a')]++;
            if(freq[(ch-'a')]==1) q.add(ch); // giving this if condition will reduce extra checks below
            while(!q.isEmpty() && freq[(q.peek()-'a')]>1) q.poll();
            if(!q.isEmpty()) ans[i]=q.peek();
            else ans[i]='#';
        }
        return String.valueOf(ans);
    }
}
```
