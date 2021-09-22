# [**Multiply two linked lists**](https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1#)
# Thoght Process :- convert each LL into Number.
- 12 to 123 can be made by 12*10+3
- now you want to add 4 in last of 123 then 123*10+4
```java
/*Node is defined as
class Node
{
    int data; 
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class GfG{
  /*You are required to complete this method */
   public long multiplyTwoLists(Node l1,Node l2){
            long big=1000000000+7;
          //add code here.
          long num1=0,num2=0;
          while(l1!=null || l2!=null){
              if(l1!=null){
                  num1=(num1*10)%big + l1.data;
                  l1=l1.next;
              }
              if(l2!=null){
                  num2=(num2*10)%big + l2.data;
                  l2=l2.next;
              }
          }
          return ((num1%big)*(num2%big))%big;
   }
}
```

