# [**92. Reverse Linked List II**](https://leetcode.com/problems/reverse-linked-list-ii/)
## Thought process :- Divide LL into 2part **Reversing Part & Non reversing part,** by adding null to the lastNode of reversing Part.
- afb - afterB
- bfa - beforeA
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
    public ListNode reverseBetween(ListNode head, int a, int b) {
        int size=getSize(head);
       
       if(a==1 && b!=size){
           ListNode s=head;
           ListNode e=head;
           for(int i=1;i<b;i++) e=e.next;
            ListNode afb=e.next;
            e.next=null;
            head=reverseList(s);
            s.next=afb;
            
            return head;
        }
        else if(b==size && a!=1){
            ListNode bFa=head;
            for(int i=1;i<a-1;i++) bFa=bFa.next;
            ListNode s=bFa.next;
            bFa.next=reverseList(s);
            
            return head;
        }
        else if(a>1 && b<size){
            ListNode bFa=head;
            for(int i=1;i<a-1;i++) bFa=bFa.next;
            ListNode s=bFa.next;
            
            ListNode e=head;
           for(int i=1;i<b;i++) e=e.next;
            ListNode afb=e.next;
            e.next=null;
            
            bFa.next=reverseList(s);
            s.next=afb;
            
            return head;
            
        }
        else{
            return reverseList(head);
        }
    }
    public int getSize(ListNode t){
        int c=0;
        while(t!=null){
            c++;
            t=t.next;
        }
        return c;
    }
    public ListNode reverseList(ListNode A) {
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



