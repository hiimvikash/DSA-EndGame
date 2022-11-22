# [143. Reorder List](https://leetcode.com/problems/reorder-list/)

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
    public void reorderList(ListNode head) {
        if(head == null || head.next==null || head.next.next==null) return;
        
        // find middle
        ListNode s=head;
        ListNode f=head;
        ListNode prev = null;
        while(f!=null && f.next!=null){
            prev = s;
            s=s.next;
            f=f.next.next;
        }
        
        // reverse right half and then join
        prev.next = reverseList(s);
        ListNode b = prev.next;
        ListNode m = b;
        ListNode bn = b.next;
        ListNode a = head;
        ListNode an = a.next;
        
        while(an!=m){
            a.next = b;
            b.next = an;
            
            a=an;
            b=bn;
            
            an = an.next;
            bn = bn.next;
        }
        a.next = b;
        
    }
    private ListNode reverseList(ListNode A) {
        ListNode curr=A;
        ListNode previous=null;
        ListNode nex=null;
        while(curr!=null) {
            nex=curr.next;
            curr.next=previous;
            previous=curr;
            curr=nex;
        }
        return previous;
    }
}
```