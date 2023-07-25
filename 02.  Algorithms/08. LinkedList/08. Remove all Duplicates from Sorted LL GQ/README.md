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

    // 1-1-1-2-2-2-3-4-5-5-6-7-8-x
    public ListNode deleteDuplicates(ListNode head) {
        // initial configuration
        ListNode d=new ListNode(-1); d.next = head;
        ListNode prev = d; // here prev is pointer which says that node is in our ans
        ListNode curr = head;

        while(curr!=null){
            while(curr.next!=null && curr.val == curr.next.val) curr = curr.next;
            if(prev.next!=curr){// this means there must be some duplicates and curr is standing in last duplicate element
                prev.next = curr.next; // here prev is expecting that diff node may not contain duplicate.
            }
            else prev = curr; // prev.next == curr means no duplicate so prev went & add that node in answer thread.

            curr = curr.next;
        }
        return d.next;
    }
}
```
