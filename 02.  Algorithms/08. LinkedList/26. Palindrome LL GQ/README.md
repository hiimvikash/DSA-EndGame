# [**234. Palindrome Linked List**](https://leetcode.com/problems/palindrome-linked-list/)
# Thought Process :
In a Palindrome Number **1stHalf is similllar to reverse(2ndHalf).**
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
    public boolean isPalindrome(ListNode head) {
        // Step 1 find 2ndmiddle(if even) and divide LL into two part.
        ListNode s=head,f=head;
        while(f!=null && f.next!=null){ // when odd elements then loop terminate by 2nd condition
            s=s.next; f=f.next.next;
        }
        if(f!=null) s=s.next; // if odd nodes then leftHalf is larger
        // Now here two halfs are head to s-1 & s to null Step 2 reverse rightHalf
        f=head;
        s=reverseList(s);
        // Step 3 : compare s.val with f.val till s!=null
        while(s!=null){
            if(s.val!=f.val) return false;
            s=s.next; f=f.next;
        }
        return true;
    }
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