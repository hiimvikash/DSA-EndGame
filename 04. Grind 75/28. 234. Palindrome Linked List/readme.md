# [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)
## Intution 
- 1st Half & reverse(2ndHalf) are =
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
        ListNode s = head, f = head;
        
        while(f!=null && f.next!=null){
            s = s.next; f = f.next.next;
        }
        if(f!=null) // odd
            s = s.next;
        
        f = head;
        s = reverseList(s);
        
        // we choose s, because in case of ODD f will have extra last element which is no need to compare
        while(s!=null){
            if(s.val != f.val) return false;
            s = s.next; f = f.next;
        }
        
        return true;
    }
    
    ListNode reverseList(ListNode head){
        ListNode curr = head, prev = null, currnext = null;
        
        while(curr!=null){
            currnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currnext;
        }
        return prev;
    }
}
```