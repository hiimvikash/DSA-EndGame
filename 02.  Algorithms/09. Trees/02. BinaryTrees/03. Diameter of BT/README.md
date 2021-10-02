# [**Diameter of BT**](https://leetcode.com/problems/diameter-of-binary-tree/)
## Recurssion
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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return 0;
        int ld=diameterOfBinaryTree(root.left);
        int rd=diameterOfBinaryTree(root.right);
        int opt=getHeight(root.left)+getHeight(root.right)+2;
        
        return Math.max(opt,Math.max(ld,rd));
    }
    public int getHeight(TreeNode root){
        if(root==null) return -1;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
```
## Using DiaPair Approach
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
    public int diameterOfBinaryTree(TreeNode root) {
        DiaPair ans=diameter(root);
        return ans.d;
    }
    
    public DiaPair diameter(TreeNode root){
        if(root==null){
            return new DiaPair(-1,0);
        }
        
        DiaPair lp=diameter(root.left);
        DiaPair rp=diameter(root.right);
        
        DiaPair mp=new DiaPair(0,0);
        mp.h=Math.max(lp.h,rp.h)+1;
        
        int opt=lp.h+rp.h+2;
        mp.d=Math.max(opt,Math.max(lp.d,rp.d));
        
        return mp;
    }
}
class DiaPair{
    int h;
    int d;
    public DiaPair(int hi, int di){
        h=hi; d=di;
    }
}
``` 