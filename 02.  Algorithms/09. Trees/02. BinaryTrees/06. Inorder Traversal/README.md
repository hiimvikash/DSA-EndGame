# [**Inorder Traversal in BT**](https://leetcode.com/problems/binary-tree-inorder-traversal/)
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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> ans=new ArrayList<>();
       inorder(root,ans);
       return ans;
    }
    private void inorder(TreeNode root, List<Integer> ans){
        if(root==null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}
``` 

## [**Itterative**](https://youtu.be/lxTGsVXjwvM)
**Hint : Do euler traversal and then try to convert it into code.**
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new LinkedList<>();
        if(root==null) return ans;
        TreeNode curr=root;
        
        Stack<TreeNode> st=new Stack<>();
        while(!st.isEmpty() || curr!=null){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp=st.pop();
                ans.add(temp.val);
                curr=temp.right;
            }
        }
        return ans;
    }
}
```