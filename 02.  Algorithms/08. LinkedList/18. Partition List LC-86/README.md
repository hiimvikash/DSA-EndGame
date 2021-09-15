# [**86. Partition List**](https://leetcode.com/problems/partition-list/)
# Leetcode Solution :- Thread Technique
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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0), greaterHead = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode smallerLast = smallerHead, greaterLast = greaterHead;      //current tails of the two queues;
        while (head != null){
            if (head.val < x) {
                smallerLast.next = head;
                smallerLast = smallerLast.next;
            }else {
                greaterLast.next = head;
                greaterLast = greaterLast.next;
            }
            head = head.next;
        }
        greaterLast.next = null;          
        smallerLast.next = greaterHead.next; //Skipping dummy head of greater and linking
        return smallerHead.next; //Skipping dummy head of smaller and returning next
    }
}
```
<hr>
<hr>

# Variation Of Above :-
## Given a list and Pivot, Partition List such that list look like this :-
### SmallerThanPivot.....--->EqualToPivot.....--->GreaterThanPivot.....--->null
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
    public ListNode partition(ListNode head, int pivot) {
        ListNode smallerHead = new ListNode(-1), greaterHead = new ListNode(-1), equalHead=new ListNode(-1) ;  //dummy heads of the 1st and 2nd queues
        ListNode smallerLast = smallerHead, greaterLast = greaterHead, equalLast=equalHead;      //current tails of the two queues;
        while(head!=null){
            int currVal=head.val;
            if(currVal < pivot){
                smallerLast.next=head;
                smallerLast=head;
            }
            else if(currVal == pivot){
                equalLast.next=head;
                equalLast=head;
            }
            else{
                greaterLast.next=head;
                greaterLast=head;
            }
            head=head.next;
        }
        greaterLast.next=null;
        // small to equal linking
        smallerLast.next=equalHead.next;
        // equal to greater linking
        equalLast.next=greaterHead.next;
        
        return smallerHead.next;
    }
}
```





