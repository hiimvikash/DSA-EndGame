# [**Remove duplicates from an unsorted linked list**](https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1#)
## Thought Process :- Use HashSet
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode d=new ListNode(-1); d.next = head;
        ListNode prev = d;
        ListNode curr = head;
        
        while(curr!=null){
            while(curr.next!=null && curr.val == curr.next.val) curr = curr.next;

            prev.next = curr;
            prev = curr;

            curr=curr.next;
        }
        return d.next;
    }
}
```
