# [**Merge K sorted LL**](https://leetcode.com/problems/merge-k-sorted-lists/)
# Recursion :- Same as Flattening of LL
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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0) return null;
        return mergeKlist(lists,n,null);
    }
    ListNode mergeKlist(ListNode[]arr,int k,ListNode head){
        if(k==1) return mergeTwoLists(arr[0],head);
        head=mergeTwoLists(arr[k-1],head);
        return mergeKlist(arr,k-1,head);
    }
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

