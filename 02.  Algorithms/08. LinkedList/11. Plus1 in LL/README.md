# [**Add 1 to a number represented as linked list**](https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1#)
## There can be 3 types of numbers:-
1. 19998 ---> whose last digit is non9 then just add +1 in last node and return head.
2. 99999 ---> there is no non9 node then just add new node infront with value 1 and change all node after it to 0.
3. 1896999 --> after non9 node every digit is 9 then increment that lastnon9 node by 1 and change all 9s to 0s.

```java
/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/
/*there can be 3 types of numbers:-
1. 19998 ---> whose last digit is non9 then just add +1 in last node and return head.
2. 99999 ---> there is no non9 node then just add new node infront with value 1 and change all node after it to 0.
3. 1896999 --> after non9 node every digit is 9 then increment that lastnon9 node by 1 and change all 9s to 0s.
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node last=null; // this will point to last non9 node
        Node curr=head; // curr will point to last node
        while(curr.next!=null){
            if(curr.data!=9) last=curr;
            curr=curr.next;
        }
        if(curr.data!=9){ // like 19998
            curr.data++;
            return head;
        }
        
        // now left 9999 & 1259999
        if(last==null){ // like 9999 here we will add 1 infront and change rest node to 0
            last=new Node(0);
            last.next=head;
            head=last;
        }
        // this below 2 line work for both 9999 & 1259999(here last is at 5)
        last.data++;
        last=last.next;
        
        // now modify rest of the node to 0
        while(last!=null){
            last.data=0;
            last=last.next;
        }
        return head;
    }
}
```