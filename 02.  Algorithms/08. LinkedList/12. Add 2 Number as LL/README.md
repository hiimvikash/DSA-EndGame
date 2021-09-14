# [**Add two numbers represented as linked list**](https://leetcode.com/problems/add-two-numbers/)
- [**Video Reference**](https://youtu.be/LBVsXSMOIk4)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0,carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(l1!=null || l2!=null || carry!=0){
            sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry=sum/10;
            ListNode nn=new ListNode(sum%10);
            temp.next=nn;
            temp=temp.next;
        }
        return dummy.next;
    }
}
```

# [**In GFG just reverse list**](https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1#)
```java
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node l1, Node l2){
        l1=reverseList(l1);
        l2=reverseList(l2);
        // code here
        // return head of sum list
        int sum=0,carry=0;
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(l1!=null || l2!=null || carry!=0){
            sum=0;
            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }
            sum+=carry;
            carry=sum/10;
            Node nn=new Node(sum%10);
            temp.next=nn;
            temp=temp.next;
        }
        return reverseList(dummy.next);
    }
    public static Node reverseList(Node start) {
        Node prev=null;
        Node nex=null;
        Node curr=start;
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