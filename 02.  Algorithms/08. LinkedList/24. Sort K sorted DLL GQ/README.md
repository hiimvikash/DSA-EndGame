# [**Sort a k sorted doubly linked list GQ**](https://www.geeksforgeeks.org/sort-k-sorted-doubly-linked-list/)
- [**Video Reference**](https://youtu.be/hgcKeJiBCc8)
```java
class CompareNodes implements Comparator<ListNode>{
    int compare(ListNode n1, ListNode n2){
        return n1.val-n2.val;
    }
}
sortKsortedDll(ListNode head,int k){
    if(head==null || head.next==null) return head;
    PriorityQueue<ListNode> minPq=new PriorityQueue<>(new CompareNodes()); // minPQ

    ListNode newHead= new ListNode(-1);ListNode last=newHead;

    // Step 1 Insert K+1 element in PQ if they exist
    for(int i=0;i<=k && head!=null;i++){
        minPq.add(head);
        head=head.next;
    }
    // step 2 make new list by adding and removing elements from PQ
    while(!minPq.isEmpty()){
        if(newHead.next==null){
            last.next=minPq.top();
            minPq.top().prev=null;
        }
        else {
            last.next=minPq.top();
            minPq.top().prev=last;
        }
        last=last.next;
        minPq.pop();

        if(head!=null){
            minPq.add(head);
            head=head.next;
        }
    }
    last.next=null;
    return newHead.next;
}
```