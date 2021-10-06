# [**Mirror of BT**](https://leetcode.com/problems/balanced-binary-tree/)
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