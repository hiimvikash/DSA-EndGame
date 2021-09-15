# [**Merge 2 sorted LL**](https://leetcode.com/problems/merge-two-sorted-lists/)
## [**Video Reference**](https://youtu.be/Xb4slcp1U38)
# Merge Sort Technique TC - O(n+m) SC-O(n+M)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(l1!=null && l2!=null){
            int val1=l1.val;
            int val2=l2.val;
            if(val1<=val2){
                temp.next=l1;
                l1=l1.next;
            }
            else if(val2<val1){
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null){
            temp.next=l1;
        }
        if(l2!=null){
            temp.next=l2;
        }
        return dummy.next;
    }
}
```
# Inplace link technique
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l2.val<l1.val){
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
        ListNode res=l1;
        ListNode prev=null;
        while(l1!=null && l2!=null){
            while(l1!=null && l1.val<=l2.val){
                prev=l1;
                l1=l1.next;
            }
            prev.next=l2;
            //swap
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
        return res;
    }
}
```