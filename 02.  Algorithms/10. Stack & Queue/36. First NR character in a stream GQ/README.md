# **[First non-repeating character in a stream](https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#)**

```java
class Solution
{
    public String FirstNonRepeating(String s)
    {
        // code here
        int n = s.length();
        int freq[] = new int[26];
        char ans[]=new char[n];
        int idx = 0;
        Queue<Character> q=new LinkedList<>();
        
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
            q.add(ch); // or if(freq[ch-'a'] == 1) q.add(ch);
            
            // I am expecting from my front of queue to be NR
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) q.remove();
            if(!q.isEmpty()) ans[idx++] = q.peek();
            else ans[idx++] = '#';
        }
        return new String(ans);
    }
}
//String.valueOf(ans);
```

