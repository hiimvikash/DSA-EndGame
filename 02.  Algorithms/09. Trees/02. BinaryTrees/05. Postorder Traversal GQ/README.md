# [**PostOrder Traversal in BT**](https://leetcode.com/problems/binary-tree-postorder-traversal/)
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
    public List<Integer> postorderTraversal(TreeNode root) {
     List<Integer> ans=new ArrayList<>();
        postorder(root,ans);
        return ans;
    }
    private void postorder(TreeNode root, List<Integer> ans){
        if(root==null) return;
        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.val);
    }
}
``` 
## **Itterative use 2 stack** DO LR+ from back(store answer from back i.e., preorder from back)
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> st=new Stack<>();
        Stack<Integer> intAns=new Stack<>(); // initial ans
        
        st.push(root);
        while(!st.isEmpty()){
            TreeNode n=st.pop();
            intAns.push(n.val);
            
            if(n.left!=null)st.push(n.left);
            if(n.right!=null)st.push(n.right);
        }
        while(!intAns.isEmpty()) ans.add(intAns.pop());
        return ans;
    }
}
``` 
## [**Itterative use 1 stack IMP**](https://youtu.be/NzIGLLwZBS8)
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        
        TreeNode curr=root; // euler
        Stack<TreeNode> st=new Stack<>();
        
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){ // left left left (5) (in speed)
                st.push(curr); curr=curr.left;   
            }
            else{
                TreeNode rightn=st.peek().right;
                
                if(rightn!=null) curr=rightn;
                
                else{
                    // print krne ki parikriya start
                    TreeNode temp=st.pop();
                    ans.add(temp.val);
                    
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.pop(); ans.add(temp.val);
                    }
                }
            }
        }
        return ans;
    }
}
```
