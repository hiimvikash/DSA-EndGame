# [2807. Insert Greatest Common Divisors in Linked List](https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/)

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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;

        ListNode curr = head;
        while(curr.next != null){
            int a = curr.val;
            int b = curr.next.val;

            ListNode n = new ListNode(gcd(a,b));

            n.next = curr.next;
            curr.next = n;

            curr = curr.next.next;
        }

        return head;
    }
    int gcd(int a, int b){
        while(a % b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }
}
```