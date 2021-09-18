# [**Quick Sort for LL**](https://practice.geeksforgeeks.org/problems/quick-sort-on-linked-list/1#)
- [Video Reference](https://youtu.be/DZXb4UGl-v4)
```java
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class GfG
{
    public static Node quickSort(Node head){
        return quickSorty(head)[0];
    }
    public static Node[] quickSorty(Node head)
    {   if(head==null || head.next==null) return new Node[]{head,head};
        //Your code here
        Node[] segregatedHeads=threeWayPartition(head);
        
        Node leftSortedList[]=quickSorty(segregatedHeads[0]);
        Node rightSortedList[]=quickSorty(segregatedHeads[3]);
        Node pivot[]=new Node[]{segregatedHeads[1],segregatedHeads[2]};
        
        return mergeSortedLists(leftSortedList,pivot,rightSortedList);
    }
    public static Node[] threeWayPartition(Node head) {
        int pivot=head.data;
        Node smallerHead = new Node(-1), greaterHead = new Node(-1), equalHead=new Node(-1) ;  //dummy heads of the 1st and 2nd queues
        Node smallerLast = smallerHead, greaterLast = greaterHead, equalLast=equalHead;      //current tails of the two queues;
        while(head!=null){
            int currVal=head.data;
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
        
        smallerLast.next=null;
        equalLast.next=null;
        greaterLast.next=null;
            
            
        return new Node[]{smallerHead.next,equalHead.next,equalLast,greaterHead.next};
    }
    
    public static Node[] mergeSortedLists(Node leftSorted[], Node pivot[], Node rightSorted[]){
        Node head=null; Node tail=null;
        if(leftSorted[0]!=null && rightSorted[0]!=null){
            leftSorted[1].next=pivot[0];
            pivot[1].next=rightSorted[0];
            
            head=leftSorted[0];
            tail=rightSorted[1];
        }
        else if(leftSorted[0]!=null){
            leftSorted[1].next=pivot[0];
            
            head=leftSorted[0];
            tail=pivot[1];
        }
        else if(rightSorted[0]!=null){
            pivot[1].next=rightSorted[0];
            
            head=pivot[0];
            tail=rightSorted[1];
        }
        else{
            head=pivot[0];
            tail=pivot[1];
        }
        return new Node[]{head,tail};
    }
}
```

# [**1. Tail Recursion**](https://youtu.be/lxHrJbU4jEQ)
# [**2. Why QuickSortForArray ?**](https://youtu.be/xPw35bOAtME)
# [**3. Why MergeSort for LL gfg article**](https://www.geeksforgeeks.org/why-quick-sort-preferred-for-arrays-and-merge-sort-for-linked-lists/)

