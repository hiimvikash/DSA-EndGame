# [**Boundry of BT**](https://www.lintcode.com/problem/878/)
## [thought Process :](https://youtu.be/0ca1nvR0be4) 
1. Add root
2. Add left boundry excluding leaf node
3. Add leaf nodes(use preorder)
4. Add right Boundry in stack and then in ANS
```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // write your code here
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        if(!isleaf(root)) ans.add(root.val);
        // 1.
        if(root.left!=null) leftboundry(root.left,ans);
        // 2. 
        leafs(root,ans);
        // 3.
        Stack<Integer> tempAns=new Stack<>();
        if(root.right!=null) rightboundry(root.right,tempAns);
        while(!tempAns.isEmpty()){
            ans.add(tempAns.pop());
        }


        return ans;
    }
   void leftboundry(TreeNode root, List<Integer> ans){
        if(root==null) return;
        if(!isleaf(root)) ans.add(root.val);
        leftboundry(root.left,ans);
        if(root.left==null) leftboundry(root.right,ans);
    }
   void leafs(TreeNode root, List<Integer> ans){ // do preorder +LR
        if(root==null) return;
        if(isleaf(root)){ ans.add(root.val); return; }
        leafs(root.left,ans);
        leafs(root.right,ans);
    }
   void rightboundry(TreeNode root, Stack<Integer> tempAns){
        if(root==null) return;
        if(!isleaf(root))tempAns.push(root.val);
        rightboundry(root.right,tempAns);
        if(root.right==null) rightboundry(root.left,tempAns);
    }


    boolean isleaf(TreeNode root){
        return (root.left==null && root.right==null);
    }
}
```