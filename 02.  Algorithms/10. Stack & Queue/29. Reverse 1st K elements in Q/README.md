# **[Reverse First K elements of Queue](https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1#)**

```java
class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Stack<Integer> st=new Stack<>();
        
        // push 1st k elements in stack
        for(int i=0; i<k; i++){
            st.push(q.poll());
        }
        // now pop them out and simultaneously add in Q
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        int rem = q.size()-k; // size of remaining unreversed element in Q
        for(int i=0;i<rem;i++){
            q.add(q.poll());
        }
        return q;
    }
}
```
