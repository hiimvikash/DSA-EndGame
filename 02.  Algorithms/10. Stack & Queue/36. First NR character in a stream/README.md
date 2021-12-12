# **[First non-repeating character in a stream](https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#)**

```java
class Solution
{
    public String FirstNonRepeating(String s)
    {
        // code here
        int n=s.length();
        int freq[]=new int[26];
        char ans[]=new char[n];
        int i=0;
        Queue<Character> q=new LinkedList<>();
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
            if(freq[ch-'a']==1) q.add(ch);
            
            while(!q.isEmpty() && freq[q.peek()-'a']>1) q.poll();
            
            if(!q.isEmpty()) ans[i++]=q.peek();
            else ans[i++]='#';
        }
        return String.valueOf(ans);
    }
}
```

