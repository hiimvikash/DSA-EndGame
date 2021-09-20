# Reverse Doubly LL in K group

**Note :** Do this after Reverse singly LL in K group.
# Thought Process :-
- Reverse each group
- Then think of joining previous reversed group with current reversed group.
    - Maintain FirstCurr* to point firstCurr of each group and after reversing it become lastCurr*
    - firstCurr* will point to new group 1st element(before reversing)
    - lastCurr will point to prev of next reversed group.
```java
/**
 * Definition for Doubly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
       ListNode prev;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next, ListNode prev) { this.val = val; this.next = next; this.prev=prev; }
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
            ListNode pre=null;
            int k=B;
            while(curr!=null && k-- > 0){
                ListNode nex=curr.next; // secure next
                curr.next=pre;
                curr.prev=nex;
                pre=curr; // secure prev
                curr=nex;
            }
            if(lCurr==null){ head=pre; pre.prev=null;}
            else{ lCurr.next=pre; pre.prev=lCurr;}
            lCurr=fCurr;
            fCurr=curr;
        }
        lCurr.next=curr;
        if(curr!=null)curr.prev=lCurr;
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
