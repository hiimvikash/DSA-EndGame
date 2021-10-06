# [**Mirror of BT**](https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/)
## Recursive
```java
Node mirror(Node root)
{
    if (root == null || (root.left==null && root.right==null))
		return root;
      
      // swap
      Node temp=root.left;
      root.left=root.right;
      root.right=temp;
      
      root.left=mirror(root.left);
      root.right=mirror(root.right);

	  return root;
}
```
## Itterative
```java
static void mirror(Node root)
{
    if (root == null)
        return;
 
    Queue<Node> q = new LinkedList<>();
    q.add(root);
 
    // Do BFS. While doing BFS, keep swapping
    // left and right children
    while (q.size() > 0)
    {
        // pop top node from queue
        Node n = q.remove();
        
        // swap left child with right child
        Node temp = n.left;
        n.left = n.right;
        n.right = temp;;
 
        // push left and right children
        if (n.left != null)
            q.add(n.left);
        if (n.right != null)
            q.add(n.right);
    }
}
```