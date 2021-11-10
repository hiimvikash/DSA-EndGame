# [**Implement K stacks in an array**](https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/)
- [**Video Reference**](https://youtu.be/UmyOXVIjUoI)
```java
public class KStack {

        int data[];   // array to store actual contents 
        int top[];   // store indexes of top elements of stacks 
        int next[];  // stores the next entry  
                     
        int n, k; 
        int free; // store the current free index 
  
        //constructor to 
        KStack(int k, int n)  
        { 
            this.k = k; 
            this.n = n; 
            data = new int[n]; 
            top = new int[k]; 
            next = new int[n]; 
  
            // Initialize all stacks as empty 
            for (int i = 0; i < k; i++) 
                top[i] = -1; 
  
            // Initialize all spaces as free 
            free = 0; 
            for (int i = 0; i < n - 1; i++) 
                next[i] = i + 1; 
            next[n - 1] = -1; // -1 is used to indicate end of free list 
        } 
  
        boolean isFull()  
        { 
            return (free == -1); 
        } 
  
        // push an item in given sn(stack number)
        void push(int item, int sn)  
        { 
            // Overflow check 
            if (isFull())  
            { 
                System.out.println("Stack Overflow"); 
                return; 
            } 
  
            int i = free; // Store index of first free slot 
  
            // next free index 
            free = next[i]; 
  
            // Update next of top and then top for stack number 'sn' 
            next[i] = top[sn]; 
            top[sn] = i; 
  
            // store the item
            data[i] = item; 
        } 
  
        // To pop an from stack number 'sn' where sn is from 0 to k-1 
        int pop(int sn)  
        { 
            // Underflow check 
            if (isEmpty(sn))  
            { 
                System.out.println("Stack Underflow"); 
                return Integer.MAX_VALUE; 
            } 
  
            // index of top item in stack number 'sn' 
            int i = top[sn]; 
  
            top[sn] = next[i]; // Change top to store next of previous top 
  
            // Attach the previous top to the beginning of free list 
            next[i] = free; 
            free = i; 
  
            // Return the previous top item 
            return data[i]; 
        } 
  
        // To check whether stack number 'sn' is empty or not 
        boolean isEmpty(int sn)  
        { 
            return (top[sn] == -1); 
        } 
  
  
    public static void main(String[] args)  
    { 
          
        KStack stack = new KStack(3, 10);  
        
        stack.push(10, 1);
        stack.push(20, 1);
        stack.push(30, 1);
        
        stack.push(100, 0);
        stack.push(200, 0);
        
        stack.push(40, 1);
        
        stack.push(1000, 2);
        stack.push(2000, 2);
        
        System.out.println(stack.pop(1));
        
        stack.push(300, 0);
        
        System.out.println(stack.pop(0));
        
        stack.push(3000, 2);
        stack.push(4000, 1);
    } 
} 
```