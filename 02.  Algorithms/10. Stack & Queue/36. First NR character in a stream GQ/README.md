# **[First non-repeating character in a stream](https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#)**

```java
public String FirstNonRepeating(String A)
    {
        // code here
        HashMap<Character, Integer> hm=new HashMap<>();
        Queue<Character> q=new LinkedList<>();
        
        StringBuilder ans=new StringBuilder();
        for(char c : A.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
            q.add(c);
            
            while(!q.isEmpty() && hm.get(q.peek()) > 1) q.poll();
            
            if(!q.isEmpty()){
                ans.append(q.peek());
            }else{
                ans.append('#');
            }
        }
        
        return ans.toString();
    }
```

