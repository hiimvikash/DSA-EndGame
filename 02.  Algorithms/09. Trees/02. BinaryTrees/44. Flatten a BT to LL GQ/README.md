# [**114. Flatten Binary Tree to Linked List**](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
- [**Video Reference**](https://youtu.be/sWf7k1x9XR4)
## Approach 1 :
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
    TreeNode prevN=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right=prevN;
        root.left=null;
        
        prevN=root;
    }
}
```
## Approach 2 : Using Stack
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
    public void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> st=new Stack<>();
        
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            
            if(curr.right!=null) st.push(curr.right);
            if(curr.left!=null) st.push(curr.left);
            
            if(!st.isEmpty()) curr.right=st.peek();
            curr.left=null;
        }
    }
}
```