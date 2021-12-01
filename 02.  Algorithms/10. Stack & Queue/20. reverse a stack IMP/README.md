
# [**Reverse a stack using recursion**](https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/)

```java
	static Stack<Character> st = new Stack<>();
	static void insert_at_bottom(char x)
	{
      	if(st.isEmpty())
			st.push(x);
		else
		{
          	char a = st.pop();
			insert_at_bottom(x);
			st.push(a);
		}
	}
	
	static void reverse()
	{
		if(st.size() > 1)
		{
          	char x = st.pop();
			reverse();
			insert_at_bottom(x);
		}
	}
```