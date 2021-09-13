# [**142. Linked List Cycle II**](https://leetcode.com/problems/linked-list-cycle-ii/)

## Thought process 1 : **distance from meetingPoint to CyclebeginPoint == distance from startingPoint to CyclebeginPoint**
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode s=head;
        ListNode f=head;
        boolean isCycle=false;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){ isCycle=true;break;}
        }
        // distance from meetingPoint to CyclebeginPoint == distance from startingPoint to CyclebeginPoint
        if(isCycle){
            s=head;
            while(s!=f){
                s=s.next;
                f=f.next;
            }
            return s;
        }
        return null;
    }
}
```