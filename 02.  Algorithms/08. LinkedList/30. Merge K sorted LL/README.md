# [**Merge K sorted LL**](https://leetcode.com/problems/merge-k-sorted-lists/)
# Recursion :- Same as Flattening of LL TC- O(NK<sup>2</sup>)
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
# [2 : Divide and concure](https://youtu.be/wugaUVZ8PVw) TC- O(nk logK)
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
        return mergeKlist(lists,0,n-1);
    }
    ListNode mergeKlist(ListNode[]arr,int s, int e){
        if(s>e) return null;
        if(s==e) return arr[s];
        int mid=(s+e)/2;
        
        ListNode l1=mergeKlist(arr,s,mid);
        ListNode l2=mergeKlist(arr,mid+1,e);
        
        return mergeTwoLists(l1,l2);
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
# [3 : Using PQ](https://youtu.be/jhWT8qal1SI) TC- O(nk logK) SC-O(k)
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
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->{return a.val-b.val;});
        // Insert first element of each LL
        for(ListNode l:lists){
            if(l!=null) pq.add(l);
        }
        // make a dummy node 
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        
        while(!pq.isEmpty()){
            ListNode node=pq.remove();
            // modify in resultant
            temp.next=node;
            temp=temp.next;
            // modify in original
            node=node.next;
            if(node!=null) pq.add(node);
        }
        return dummy.next;
    }
}
```