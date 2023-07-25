# [**83. Remove Duplicates from Sorted List**](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

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
