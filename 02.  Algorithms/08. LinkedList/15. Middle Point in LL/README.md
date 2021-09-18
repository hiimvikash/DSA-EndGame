# [**Middle Point in LL**](https://leetcode.com/problems/middle-of-the-linked-list/)
# When you want 2nd node as middle in 2 middle's(in even case).
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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next==null)
            return head;
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
}
```
# When you want 1st node as middle in 2 middle's(in even case) then f.next.next==null.
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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next==null)
            return head;
        ListNode s=head;
        ListNode f=head;
        while(f.next.next!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
}
```
