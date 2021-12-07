# **[Reverse Q using Recurrsion](https://practice.geeksforgeeks.org/problems/queue-reversal/1#)**
## Itterative Approach
```java
class GfG{
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        Stack<Integer> st=new Stack<>();
        
        while(!q.isEmpty()){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        return q;
    }
}
```
## Recurrsive Approach
```java
class GfG{
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        if(q.size()==0 || q.size()==1) return q;
        int data=q.poll();
        rev(q);
        q.add(data);
        return q;
    }
}
```
