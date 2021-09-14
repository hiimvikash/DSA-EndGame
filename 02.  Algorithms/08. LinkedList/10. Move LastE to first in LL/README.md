# [**Move last element to front of a given Linked List**](https://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/)
```java
ListNode modify(ListNode head){
    ListNode seclast=head;
    while(seclast.next.next!=null){
        seclast=seclast.next;
    }
    ListNode last=seclast.next;
    
    last.next=head;
    head=last;
    seclast.next=null;
}
```