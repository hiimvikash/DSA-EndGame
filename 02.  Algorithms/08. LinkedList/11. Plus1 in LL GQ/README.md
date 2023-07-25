# [**Add 1 to a number represented as linked list**](https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1#)
## There can be 3 types of numbers:-
1. 19998 ---> whose last digit is non9 then just add +1 in last node and return head.
2. 99999 ---> there is no non9 node then just add new node infront with value 1 and change all node after it to 0.
3. 1896999 --> after non9 node every digit is 9 then increment that lastnon9 node by 1 and change all 9s to 0s.

```java
class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        // step 1 run a loop till last and keep track for last non9
        Node last = head;
        Node lnn = null;
        while(last.next!=null){
            if(last.data != 9) lnn = last;
            last = last.next;
        }
        
        // if num is 18987
        if(last.data!=9){
            last.data++;
            return head;
        }
        
        // if num is 9999
        if(lnn == null){
            Node n = new Node(1);
            n.next = head;
            
            lnn = head; // just using made pointer
            while(lnn!=null){
                lnn.data = 0;
                lnn = lnn.next;
            }
            head = n;
            
            return head;
        }
        
        
        
        // if num is 124999
        lnn.data++;
        Node t = lnn.next;
        while(t!=null){
            t.data = 0;
            t = t.next;
        }
        return head;
    }
}

```
