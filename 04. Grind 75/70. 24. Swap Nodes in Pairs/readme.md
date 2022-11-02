# [24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode d=new ListNode(); d.next = head;
        
        ListNode prev = d;
        ListNode a = head;
        ListNode b = head.next;
        ListNode temp = b.next;
        
        while(true){
            
            a.next = temp;
            b.next = a;
            prev.next = b;
            
            // temp==null means LL was of even size and each pair are swapped and there are no pairs left
            // temp.next==null means LL was of odd size and only one element is left at last with no partner to be swaped wid
            if(temp==null || temp.next==null) break; 
            prev = a;
            a = temp;
            b = temp.next;
            temp = b.next;
        }
        return d.next;
    }
}
```