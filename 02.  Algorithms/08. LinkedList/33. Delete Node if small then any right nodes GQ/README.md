# [**Delete node, if having greater value on any right nodes**](https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1#)

# Delete that node which has any greater on it right.
[**Video Reference**](https://youtu.be/cI3P6L6xgpY)
```java
/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        // your code here
        if(head==null||head.next==null) return head;
        head=reverseList(head);
        Node newHead=new Node(-1);
        newHead.next=head;
        Node last=head; // this is because last node(before reversing) will be our ANS always
        int max=head.data;
        head=head.next;
        while(head!=null){
            if(head.data>=max){
                max=head.data;
                last.next=head;
                last=last.next;
            }
            head=head.next;
        }
        last.next=null;
        return reverseList(newHead.next);
    }
    public Node reverseList(Node start) {
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

