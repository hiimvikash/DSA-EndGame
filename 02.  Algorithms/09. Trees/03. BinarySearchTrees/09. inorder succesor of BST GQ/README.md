# [**448 · Inorder Successor in BST**](https://www.lintcode.com/problem/448/)
[**Video Reference**](https://youtu.be/JdmAYw5h3G8)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root==null) return null;

        // Case 1 : if P has "rightSubTREE" then least node in rightSubTREE will be ANS.
        if(p.right!=null){
            TreeNode temp = p.right;
            while(temp.left!=null){
                temp=temp.left;
            }
            return temp;
        }

        // Case 2 : if P has no "rightSubTREE" then ANS will be in the path from ROOT to that NODE P, ANS will be that Node from where we took last left.
        if(p.right==null){
            TreeNode temp = root;
            int x = p.val;
            TreeNode ans = null;
            while(temp.val != x){
                if(x < temp.val){
                    ans=temp;
                    temp = temp.left;
                }
                else temp = temp.right;
            }
            return ans;
        }
        return null;
    }
}
```

# Predecessor Start
```java
// Case 1 : if ki has left, then ANS will be the maximum element in leftSUBTREE
        if(p.left!=null){
            TreeNode temp = p.left;
            while(temp.right!=null){
                temp=temp.right;
            }
            return temp;
        }
       // Case 2 : if ki has no left, then ur ANS will lie on the path from root to "ki", ANS will be the node from where u took last right.
        if(p.right==null){
            TreeNode temp = root;
            int x = p.val;
            TreeNode ans = null;
            while(temp.val != x){
                if(x < temp.val) temp = temp.left;
                else { ans=temp; temp = temp.right; }
            }
            return ans;
        }
        return null;
```