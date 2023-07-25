# [**Remove duplicates from an unsorted linked list**](https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1#)
## Thought Process :- Use HashSet
```java
class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
         Node d=new Node(-1);
         Node prev = d;
         prev.next = head;
         Set<Integer> s=new HashSet<>();
         
         Node curr = head;
         while(curr!=null){
             if(!s.contains(curr.data)){
                 prev.next = curr;
                 prev = curr;
                 s.add(curr.data);
             }
             curr = curr.next;
         }
         prev.next = null;
         return d.next;
         
    }
}
```
