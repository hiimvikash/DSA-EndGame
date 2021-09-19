# [**Right Rotate Singly LL by k place**](https://leetcode.com/problems/rotate-list/)
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        
        int size=1;ListNode currLast=head;
        while(currLast.next!=null){
            size++; currLast=currLast.next;
        }
        if(k%size==0) return head;
        if(k>size) k%=size; // [1,2] k=5 this will cancel all the multiples of size and give you the remaining rotations.
        
        ListNode newLast=head; int step=size-k-1;
        while(step>0){
            step--;
            newLast=newLast.next;
        }
        ListNode newH=newLast.next;
        currLast.next=head;
        newLast.next=null;
        return newH;
    }
}
```

