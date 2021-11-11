# [**Design a stack with operations on middle element**](https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/)

```java
public class Stack_DLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack ms = new MyStack();
		ms.push(ms, 11);
		ms.push(ms, 22);
		ms.push(ms, 33);
		ms.push(ms, 44);
		ms.push(ms, 55);
		ms.push(ms, 66);
		ms.push(ms, 77);

		System.out.println("Item popped is " + ms.pop(ms));
		System.out.println("Item popped is " + ms.pop(ms));
		System.out.println("Middle Element is "+ ms.getMiddle(ms));
	}

}



class MyStack{
	
	class Dll{
		int data;
		Dll next;
		Dll prev;
		public Dll(int data) {
			this.data = data;
			next=null;
			prev=null; 
		}
	}
	
	Dll top;
	int count;
	Dll mid;
	
	public MyStack() {
		top = null;
		count = 0;
		mid = null;
	}
	
	public void push(MyStack st, int data) {
		Dll nn=new Dll(data);
		
		nn.prev = null;
		nn.next = st.top;
		if(st.top!=null) st.top.prev = nn;
		st.top = nn;
		
		st.count+= 1;
		// tackling mid
		if(st.count ==1) st.mid = nn;
		else if(st.count%2 != 0) st.mid = st.mid.prev;
	}
	
	public int pop(MyStack st) {
		if(st.count == 0) { System.out.println("Stack is empty"); return -1; }
		
		Dll delN = st.top;
		st.top = st.top.next;
		if(st.top!=null) st.top.prev = null;
		
		st.count-=1;
		
		if(st.count%2==0) st.mid = st.mid.next;
		
		return delN.data;
	}
	public int getMiddle(MyStack st) {
		if(st.count == 0) { System.out.println("Stack is empty"); return -1; }
		return st.mid.data;
	}
}
```