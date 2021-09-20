# [**Remove duplicates from an unsorted linked list**](https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1#)
## Thought Process :- Use HashSet
```java
/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
         HashSet<Integer> hs=new HashSet<>();
         Node curr=head;
         Node prev=null;
         while(curr!=null){
             if(!hs.contains(curr.data)){ hs.add(curr.data); prev=curr;}
             else prev.next=curr.next;
             curr=curr.next;
         }
         return head;
    }
}
```