# [**Implement two stacks in an array**](https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1#)
- [**Video Reference**](https://youtu.be/cJgVdvWz4iU)
```java
class twoStacks
{
    int arr[];
    int size;
    int top1, top2;
    twoStacks()
    {
        size = 100; 
        arr = new int[100]; 
        top1 = -1; 
        top2 = size;
    }
    //Function to push an integer into the stack1.
    void push1(int x)
    {
         if(!isStack1Full()){        
             top1++;
             arr[top1] = x;
         }
    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
       if(!isStack2Full()){        
             top2--;
             arr[top2] = x;
        }
    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
      if(top1==-1) return -1;
      else return arr[top1--];
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        if(top2 == size) return -1;
        else return arr[top2++];   
    }
    boolean isStack1Full(){
        return top1 + 1 == top2;
    }
    boolean isStack2Full(){
        return top2 - 1 == top1;
    }
}
```
