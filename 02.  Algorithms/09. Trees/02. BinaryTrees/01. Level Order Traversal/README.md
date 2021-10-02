# [**Level Order Traversal GFG**](https://practice.geeksforgeeks.org/problems/level-order-traversal/1#)
```java
/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node root) 
    {
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node n=q.remove();
            ans.add(n.data);
            if(n.left!=null) q.add(n.left);
            if(n.right!=null) q.add(n.right);
        }
        return ans;
    }
}
```
# [**Level Order Traversal Leetcode**](https://leetcode.com/problems/binary-tree-level-order-traversal/)
## Thought Process :- Try to make no.OfNodes in Queue = No.OfNodes in that level.

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelNodesCount=q.size();// no. of nodes in each level
            
            List<Integer> subans=new ArrayList<>();
            for(int i=0;i<levelNodesCount;i++){
                TreeNode n=q.remove();
                subans.add(n.val);
                
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            ans.add(subans);
        }
        return ans;
    }
}
```