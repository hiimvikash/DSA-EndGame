# [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode i = list1; ListNode j = list2; 
        
        ListNode d=new ListNode(-1);
        ListNode ln = d;
        while(i!=null && j!=null){
            if(i.val<=j.val){
                ln.next = i;
                ln = i;
                i = i.next;
            }
            else if(j.val<i.val){
                ln.next = j;
                ln = j;
                j = j.next;
            }
        }
        
        if(i!=null){
            ln.next=i;
        }
        if(j!=null){
            ln.next=j;
        }
        
        return d.next;
    }
}
```