# [**19. Remove Nth Node From End of List in 1pass**](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
# Naive Approach : O(2N)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        
        int size=getsize(head);
        int pos=size-n+1;
        if(pos==1) return head.next;
        ListNode curr=head,prev=null,nex=null;
        while(pos-- > 1){
           prev=curr;
           curr=curr.next; 
        }
        nex=curr.next;
        
        prev.next=nex;
        return head;
    }
    int getsize(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
}
```
# One Pass Approach
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1 Make a dummy node and point its next to head. and also point slow and fast to dummy node
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        
        ListNode s=dummy;
        ListNode f=dummy;
        // Step 2 move fast n times
        while(n-- > 0){
            f=f.next;
        }
        // Step 3 move slow and fast by 1 till fast reaches last node
        while(f.next!=null){
            s=s.next;
            f=f.next;
        }
        // now your slow is standing oneNode before deleting node
        s.next=s.next.next;
        return dummy.next;
    }
}
```

# [**Nth Node From End of List in 1pass**](https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1#)
```java
/* Structure of node

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class GfG
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	Node dummy=new Node(-1);
    	dummy.next=head;
    	
    	Node s=dummy;
    	Node f=dummy;
    	
    	while(n-- > 0 && f!=null){
    	    f=f.next;
    	}
    	if(f==null) return -1; // this means n is greater than sizeOfLL
    	
    	while(f.next!=null){
    	    s=s.next;
    	    f=f.next;
    	}
    	 return s.next.data;
    }
}
```