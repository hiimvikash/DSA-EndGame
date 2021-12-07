# **[Interleave the first half of the queue with second half](https://www.geeksforgeeks.org/interleave-first-half-queue-second-half/)**

```java
static void interLeaveQueue(Queue<Integer>q)
{
	// To check the even number of elements
	if (q.size() % 2 != 0)
		System.out.println("Input even number of integers." );

	// Initialize an empty stack of int type
	Stack<Integer> s = new Stack<>();
	int halfSize = q.size() / 2;

	// Push first half elements into the stack
	// queue:16 17 18 19 20, stack: 15(T) 14 13 12 11
	for (int i = 0; i < halfSize; i++)
		s.push(q.poll());
	

	// enqueue back the stack elements
	// queue: 16 17 18 19 20 15 14 13 12 11
	while (!s.empty())
		q.add(s.pop());
		
	// dequeue the first half elements of queue
	// and enqueue them back
	// queue: 15 14 13 12 11 16 17 18 19 20
	for (int i = 0; i < halfSize; i++)
		q.add(q.poll());
		

	// Again push the first half elements into the stack
	// queue: 16 17 18 19 20, stack: 11(T) 12 13 14 15
	for (int i = 0; i < halfSize; i++)
		s.push(q.poll());
		

	// interleave the elements of queue and stack
	// queue: 11 16 12 17 13 18 14 19 15 20
	while (!s.empty())
	{
        q.add(s.pop());
        q.add(q.poll());
	}
}
```
[**Video reference**](https://youtu.be/h9Oi5IumE88)