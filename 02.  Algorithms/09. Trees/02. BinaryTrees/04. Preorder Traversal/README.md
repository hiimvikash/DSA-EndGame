# [**Preorder Traversal in BT**](https://leetcode.com/problems/binary-tree-preorder-traversal/)
## Recursive
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
    private void preorder(TreeNode root, List<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
         preorder(root.left,ans);
         preorder(root.right,ans);
    }
}
``` 
## [Itterative use stack](https://youtu.be/Bfqd8BsPVuw)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> st=new Stack<>();
        
        st.push(root);
        while(!st.isEmpty()){
            TreeNode n=st.pop();
            ans.add(n.val);
            
            if(n.right!=null) st.push(n.right);
            if(n.left!=null) st.push(n.left);
        }
        return ans;
    }
}
``` 