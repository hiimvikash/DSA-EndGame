
# [**Sort a stack**](https://practice.geeksforgeeks.org/problems/sort-a-stack/1#)

```java
/*Complete the function below*/
class GfG{
    
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(s.size() < 2) return s;
		else{
		    int top = s.pop();
		    sort(s);
		    insertAtPos(s,top);
		    return s;
		}
	}
	private void insertAtPos(Stack<Integer> s,int top){
	    if(s.isEmpty() || s.peek()<=top){
	      s.push(top); return;  
	    }
	    int topE = s.pop();
	    insertAtPos(s,top);
	    s.push(topE);
	}
}
```