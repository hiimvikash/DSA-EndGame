# [**1. Print Nodes of BST within range**](https://www.pepcoding.com/resources/online-java-foundation/binary-search-tree/pir-bst-official/ojquestion)
[**Video Reference**](https://youtu.be/NEJUsqEFOI4)

```java
public static void pir(Node root, int l, int r) {
      if(root==null) return;
    // write your code here
    if(root.data > r) pir(root.left,l,r);
    else if(root.data < l) pir(root.right,l,r);
    else{
        pir(root.left,l,r);
        System.out.println(root.data);
        pir(root.right,l,r);
    }
  }
```

# [**2. Count Nodes of BST within range**](https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1#)
```java
class Tree
{
    int count=0;
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int r)
    {
        //Your code here
        pir(root,l,r);
        return count;
    }
    public void pir(Node root, int l, int r) {
          if(root==null) return;
        // write your code here
        if(root.data > r) pir(root.left,l,r);
        else if(root.data < l) pir(root.right,l,r);
        else{
            pir(root.left,l,r);
            count++;
            pir(root.right,l,r);
        }
  }
}
```
# [**3. Sum of Nodes of BST within range**](https://leetcode.com/problems/range-sum-of-bst/)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        pir(root,low,high);
        return sum;
    }
    public void pir(TreeNode root, int l, int r) {
          if(root==null) return;
        // write your code here
        if(root.val > r) pir(root.left,l,r);
        else if(root.val < l) pir(root.right,l,r);
        else{
            pir(root.left,l,r);
            sum+=root.val;
            pir(root.right,l,r);
        }
  }
}
```