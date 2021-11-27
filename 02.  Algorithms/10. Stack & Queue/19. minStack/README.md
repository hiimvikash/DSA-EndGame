
# [**Design a Stack that supports getMin() in O(1) time and O(1) extra space.**](https://practice.geeksforgeeks.org/problems/special-stack/1#)

```java
/*Complete the function(s) below*/
class Solution{
    int min = Integer.MAX_VALUE;
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(a < min) min = a;
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            return s.pop();
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           return s.size()==n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.isEmpty();
	}
}
```