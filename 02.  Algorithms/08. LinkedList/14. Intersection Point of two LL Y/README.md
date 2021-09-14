# [**160. Intersection of Two Linked Lists**](https://leetcode.com/problems/intersection-of-two-linked-lists/)
[**Video Reference**](https://youtu.be/u4FWXfgS8jw)
# 1.  Use HashSet
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        HashSet<ListNode> hs= new HashSet<>();
        while(l1!=null){
            hs.add(l1);
            l1=l1.next;
        }
        while(l2!=null){
            if(hs.contains(l2)) return l2;
            l2=l2.next;
        }
        return null;
    }
}
```
# 2.  Use Dummy O(2M) SC- O(1) 
## Thought Process :-
- find the longer LL
- put a dummy pointer in longerLL to same level of shorterLL
- and then traverse together untill both pointer points to same node.
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int l1=0,l2=0;
        ListNode d1=head1,d2=head2;
        // find length1 & length2
        while(d1!=null || d2!=null){
            if(d1!=null){
                l1++;
                d1=d1.next;
            }
            if(d2!=null){
                l2++;
                d2=d2.next;
            } 
        }
        d1=head1;
        d2=head2;
        if(l1>l2){
            int diff=l1-l2;
            for(int i=0;i<diff;i++){
                d1=d1.next;
            }
        }
        else if(l2>l1){
            int diff=l2-l1;
            for(int i=0;i<diff;i++){
                d2=d2.next;
            }
        }
        
        while(d1!=d2){
            d1=d1.next;
            d2=d2.next;
        }
        return d1;
    }
}
```
# 3. best optimal
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
``` 