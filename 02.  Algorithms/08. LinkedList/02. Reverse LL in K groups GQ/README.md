# [**Step 1 : Reverse LinkedList in K group IB**](https://www.interviewbit.com/problems/k-reverse-linked-list/)
# Thought Process :-
- Reverse each group
- Then think of joining previous reversed group with current reversed group.
    - Maintain FirstCurr* to point firstCurr of each group and after reversing it become lastCurr*
    - firstCurr* will point to new group 1st element(before reversing)
    - lastCurr will point to prev of next reversed group.
## Itterative
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head, int B) {
        ListNode curr=head;
        ListNode fCurr=curr; // first curr
        ListNode lCurr=null;
        while(curr!=null){
            ListNode prev=null;
            int k=B;
            while(curr!=null && k-- > 0){
                ListNode nex=curr.next; // secure next
                curr.next=prev;
                prev=curr; // secure prev
                curr=nex;
            }
            if(lCurr==null) head=prev;
            else lCurr.next=prev;
            lCurr=fCurr;
            fCurr=curr;
        }
        return head;
    }
}
```
# [**Step 2 : Reverse LinkedList in K group LC**](https://leetcode.com/problems/reverse-nodes-in-k-group/)
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
    public ListNode reverseKGroup(ListNode head, int B) {
        int size=size(head);
        int group=size/B;
        ListNode curr=head;
        ListNode fCurr=curr; // first curr
        ListNode lCurr=null; // last curr
        
        while(curr!=null && group-- > 0){
            ListNode prev=null;
            int k=B;
            while(curr!=null && k-- > 0){
                ListNode nex=curr.next; // secure next
                curr.next=prev;
                prev=curr; // secure prev
                curr=nex;
            }
            if(lCurr==null) head=prev;
            else lCurr.next=prev;
            lCurr=fCurr;
            fCurr=curr;
        }
        lCurr.next=curr;
        return head;
    }
    int size(ListNode curr){
        int size=0;
        while(curr!=null){
            size++;
            curr=curr.next;    
        }
        return size;
    }
}
```