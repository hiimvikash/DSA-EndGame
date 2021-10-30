# [**Median of BST**](https://www.codingninjas.com/codestudio/problems/median-of-a-bst_893184)

[**Video Reference**](https://youtu.be/XIjko1AgEmM)

```java
/*************************************************************************

    Following is the class structure of the Node class:

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}


*************************************************************************/

public class Solution {
    static TreeNode<Integer> prevN = null;
    static TreeNode<Integer> curr = null;
    static int c=0;
	public static int medianBST(TreeNode<Integer> root) {
		// Write your code here.
        int counts[] = new int[1];
        countNodes(root,counts);
        int count = counts[0];
        c=0; prevN=null; curr = null;
        
        traverse(root,(count/2)+1);
        if(count%2 != 0) return curr.data;
        else return (prevN.data + curr.data)/2;
	}
    
    private static void traverse(TreeNode<Integer> root, int k){
        if(root==null) return;
        
        traverse(root.left,k);
        if(c==k) return;
        
        c++;
        if(c==k){ curr = root; return; }
        prevN = root;
        
        traverse(root.right,k);
        if(c==k) return;
    }
    
    private static void countNodes(TreeNode<Integer> root, int count[]){
        if(root==null) return;
        count[0]++;
        countNodes(root.left,count); 
        countNodes(root.right,count);
    }
}
```