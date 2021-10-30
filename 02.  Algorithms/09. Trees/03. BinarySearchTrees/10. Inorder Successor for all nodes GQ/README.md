# [**Inorder Successor for all nodes**](https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1#)
[**Video Reference**](https://youtu.be/W25l6evkk_U)
```java
/*
class Node {
    int data;
    Node left, right,next;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    Node prevN=null;
    public void populateNext(Node root){
        //code here
        if(root==null) return;
        
        populateNext(root.left);
        
        if(prevN!=null) prevN.next = root;
        prevN = root;
        
        populateNext(root.right);
    }
}
```