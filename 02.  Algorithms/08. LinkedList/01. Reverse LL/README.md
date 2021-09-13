# [**Reverse LinkedList**](https://leetcode.com/problems/reverse-linked-list/)
## Itterative
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
    public ListNode reverseList(ListNode start) {
        ListNode prev=null;
        ListNode nex=null;
        ListNode curr=start;
        while(curr!=null){
            nex=curr.next; // secure your next moment
            curr.next=prev; // do the main operation
            prev=curr; // secure your prev
            curr=nex;
        }
        return prev;
    }
}
```
## Recursive
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
    ListNode prev=null;
    ListNode nex=null;
    public ListNode reverseList(ListNode start) {
        if(start==null) return prev;
        
        nex=start.next; // secure your next
        start.next=prev; // do the operation
        prev=start; // secure your prev
        start=nex; // for next itteration
        
        return reverseList(start);
    }
}
```