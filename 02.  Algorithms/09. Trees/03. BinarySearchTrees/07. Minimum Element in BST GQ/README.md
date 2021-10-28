# [**Minimum element in BST**](https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1#)

```java
class Tree {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        if(root.left==null) return root.data;
        return minValue(root.left);
    }
}
```