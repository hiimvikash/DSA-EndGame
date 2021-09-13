# [**82. Remove all Duplicates from Sorted List GQ**](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
## Thought Process :-
- make a dummy head
- as soon as you enter the loop skip the duplicates value
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
        ListNode fakeHead=new ListNode(0);
        fakeHead.next=head;
        ListNode prev=fakeHead;
        ListNode curr=head;
        while(curr!=null){
            while(curr.next!=null && curr.val==curr.next.val) curr=curr.next;
            if(prev.next!=curr) prev.next=curr.next;
            else prev=curr;
            curr=curr.next;
        }
        return fakeHead.next;
    }
}
```