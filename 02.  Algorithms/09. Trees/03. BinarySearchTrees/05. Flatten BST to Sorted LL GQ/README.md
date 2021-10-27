# [**Flatten BST to Sorted List**](https://www.geeksforgeeks.org/flatten-bst-to-sorted-list-increasing-order/)

```java
static Node prevN=null;
public Node flatten(Node root){
    Node Dummy=new Node(-1);
    prevN=Dummy;

    inorder(root);

    return dummy.right;
}

private void inorder(Node root){
    if(root==null) return;

    inorder(root.left);

    prevN.right=root;
    prevN.left=null;
    prevN=root;

    inorder(root.right);
}
```