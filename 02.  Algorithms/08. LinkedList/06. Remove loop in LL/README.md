# [**Remove loop in Linked List**](https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#)

## Thought process 1 : **distance from meetingPoint to CyclebeginPoint == distance from startingPoint to CyclebeginPoint : We will stop 1step before**
```java
/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        
        Node s=head;
        Node f=head;
        boolean isCycle=false;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){ isCycle=true;break;}
        } 
        if(isCycle && s==head && f==head){ // when meeting point is first node then we have to make last node null.
            while(s.next!=f){
                s=s.next;
            }
            s.next=null;
        }
        else if(isCycle){ // we have to make node before meetingPoint to point to nulls
            f=head;
            while(s.next!=f.next){
                s=s.next;
                f=f.next;
            }
            s.next=null;
        }
    }
}
```