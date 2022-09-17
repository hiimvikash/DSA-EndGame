## [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode curr = head, currnext = null, prev = null;
        
        while(curr!=null){
            currnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currnext;
        }
        return prev;
    }
}
```