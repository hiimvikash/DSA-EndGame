# [155. Min Stack](https://leetcode.com/problems/min-stack/)
```java
class MinStack {

    class Node{
        int data;
        Node next;
        int min;
        public Node(int d, int m){
            data = d; next = null; min = m;
        }
    }
    Node top; 

    public MinStack() {
        top = null; 
    }
    
    public void push(int val) {
        if(top == null) top = new Node(val, val);
        else {
            Node n = new Node(val, Math.min(val,top.min));
            n.next = top;
            top = n;
        }
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```