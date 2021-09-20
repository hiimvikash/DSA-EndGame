# [**Merge Sort for LL**](https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1#)


```java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null || head.next==null) return head;
        Node middleNode=getMiddle(head);
        Node afterMiddle=middleNode.next;
        middleNode.next=null;
        Node left=mergeSort(head);
        Node right=mergeSort(afterMiddle);
        
        return mergeTwoLists(left,right);
    }
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(l1!=null && l2!=null){
            int val1=l1.data;
            int val2=l2.data;
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
    static Node getMiddle(Node head){
        if(head==null || head.next==null) return head;
        Node s=head,f=head;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
}
```