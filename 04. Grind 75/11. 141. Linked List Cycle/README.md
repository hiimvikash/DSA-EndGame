# [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

## Using HM
- we will keep on itterating and inserting the NODE in HM
- and if that node is already present in HM then cycle is there.
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
        if(head==null) return false;
        HashMap<ListNode, Integer> hm=new HashMap<>();
        ListNode temp = head;
        
        while(temp.next!=null){
            if(hm.containsKey(temp)) return true;
            hm.put(temp,0);
            temp = temp.next;
        }
        return false;
    }
}
```