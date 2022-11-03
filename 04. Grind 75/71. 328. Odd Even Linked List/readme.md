# [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        
        ListNode dno=new ListNode(); ListNode co = dno; // dummy node odd & currOdd
        ListNode dne=new ListNode(); ListNode ce = dne; // dummy node Eve & currEve
        
        co = dno.next = head; ce = dne.next = head.next;
        while(co.next!=null && ce.next!=null){ // co.next = null means odd size of LL, ce.next = null means eve size of LL
            co.next = co.next.next;
            co = co.next;
            if(co.next==null) break;
            ce.next = ce.next.next;
            ce = ce.next;
        }
        
        ce.next = null;
        co.next = dne.next;
        
        
        return dno.next;
    }
}
```