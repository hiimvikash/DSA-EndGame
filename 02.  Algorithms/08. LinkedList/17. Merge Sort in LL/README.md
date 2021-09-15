# [**Merge Sort**](https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1#)


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
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l2.data<l1.data){
            Node temp=l1;
            l1=l2;
            l2=temp;
        }
        Node res=l1;
        Node prev=null;
        while(l1!=null && l2!=null){
            while(l1!=null && l1.data<=l2.data){
                prev=l1;
                l1=l1.next;
            }
            prev.next=l2;
            //swap
            Node temp=l1;
            l1=l2;
            l2=temp;
        }
        return res;
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