# **[Circular tour](https://practice.geeksforgeeks.org/problems/circular-tour/1#)**

## Queue Based Approach
- Here TLE bcz we r traversing each node twice
```java
int tour(int petrol[], int distance[])
    {
	// Your code here
	    int n = petrol.length;
	    int front = 0;
	    int rear = 0;
	    int start = 0;
	    int balance = 0;
	    int i = 0;
	    boolean flag = true;
	    while(flag){
	        
	        balance+=petrol[rear]-distance[rear];
	        if(balance >= 0){
	            rear = (rear+1) % n;
	        }else{
	            front = rear+1;
	            if(front == n) flag = false;
	            rear = front;
	            start = front;
	            balance = 0;
	            continue;
	        }
	        if(front == rear) return start;
	    }
	    
	    return -1;
    }
```
- Here instead of travelling AGAIN over the path which leads to balance<0 we r storing that part named AS "kami"
```java
class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here
	    int n = petrol.length;
	    int balance = 0;
	    int start = 0;
	    int kami = 0;
	    for(int rear = 0; rear<n; rear++){
	        balance += petrol[rear] - distance[rear];
	        if(balance >= 0) continue;
	        else{
	            kami+=balance;
	            balance = 0;
	            start = rear + 1;
	        }
	    }
	    if(kami + balance >= 0) return start;
	    else return -1;
    }
}
```
[**Video reference**](https://youtu.be/_gJ3to4RyeQ?t=2475)https://youtu.be/_gJ3to4RyeQ?t=2475)
