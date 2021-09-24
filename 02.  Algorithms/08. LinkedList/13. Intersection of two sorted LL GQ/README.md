# [**Intersection of two sorted Linked lists**](https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1#)
# 1.  Use HashSet
```java
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        HashSet<Integer> hs=new HashSet<>();
        Node curr=head1;
        while(curr!=null){
            hs.add(curr.data);
            curr=curr.next;
        }
        curr=head2;
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(curr!=null){
            if(hs.contains(curr.data)){
                Node nn=new Node(curr.data);
                temp.next=nn;
                temp=temp.next;
                hs.remove(curr.data);
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}
```
# 2.  Use MergeSort technique
```java
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node l1, Node l2)
    {
        // code here.
        Node dummy=new Node(-1);
        Node temp=dummy;
        
        while(l1!=null && l2!=null){
            int data1=l1.data;
            int data2=l2.data;
            
            if(data1<data2){
                l1=l1.next;
            }
            else if(data2<data1){
                l2=l2.next;
            }
            else{
                Node nn=new Node(data1);
                temp.next=nn;
                temp=temp.next;
                l1=l1.next;
                l2=l2.next;
            }
        }
        return dummy.next;
    }
}
```