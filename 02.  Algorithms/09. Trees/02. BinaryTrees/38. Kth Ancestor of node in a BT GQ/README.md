# [**Kth ancestor of a node in binary tree.**](https://www.geeksforgeeks.org/kth-ancestor-node-binary-tree-set-2/)

```java
static Node kthAncestorDFS(Node root, int x )
{
	// Base case
	if (root == null)
		return null;
	
	if (root.data == x|| (kthAncestorDFS(root.left,x)) != null || (kthAncestorDFS(root.right,x)) != null)
	{
		if (k == 0)
		{
			// print the kth ancestor
			System.out.print("Kth ancestor is: "+root.data);
			
			// return null to stop further backtracking
			return null;
		}
		
		// return current node to previous call
		k--;
		return root;
	}
	else{
		if(k==0) System.out.println("Kth ancestor is : -1");
		return null;
	}
}
```
