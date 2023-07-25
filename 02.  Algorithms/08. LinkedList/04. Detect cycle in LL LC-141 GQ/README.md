# [**141. Linked List Cycle**](https://leetcode.com/problems/linked-list-cycle/)
[**Video Reference**](https://youtu.be/354J83hX7RI)
## Thought process 1 : Use Set DS
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s=new HashSet<>();
        ListNode curr = head;
        while(curr!=null){
            if(!s.contains(curr)){
                s.add(curr);
                curr = curr.next;
            }
            else return true;
        }
        return false;
    }
}
```
## Thought process 2 : Slow and fast pointer
- increase slow by 1
- increase fast by 2 
- If there will be cycle then s==f at some point of time
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false; // empty LL or 1element in LL
        ListNode s=head;
        ListNode f=head;
        while(f.next!=null && f.next.next!=null){ // fast in lastNode && fast in 2ndLast node
            s=s.next;
            f=f.next.next;
            if(s==f) return true;
        }
        return false;
    }
}
```
