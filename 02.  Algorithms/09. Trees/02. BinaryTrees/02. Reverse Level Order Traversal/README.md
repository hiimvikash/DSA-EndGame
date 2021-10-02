# [**Reverse Level Order Traversal GFG**](https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1#)

## Print Given Level Approach :-
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

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node root) 
    {
        // code here
        int h=getHeight(root);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=h;i>=0;i--){
            printGivenLevel(root,i,ans);
        }
        return ans;
    }
    public void printGivenLevel(Node root, int level, ArrayList<Integer> ans){
        if(root==null) return;
        if(level==0){ ans.add(root.data); return;}
        printGivenLevel(root.left,level-1,ans);
        printGivenLevel(root.right,level-1,ans);
    }
    private int getHeight(Node root){
        if(root==null) return -1;
        if(root.left==null && root.right==null) return 0;
        
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
} 
```
## Stack & Queue Approach(IMP) :-
See the above image and dectate 3 times :-
- put 1 in stack
- put 3 in stack
- put 2 in stack
- put 7 in stack
- put 6 in stack
- put 5 in stack
- put 4 in stack
- and now pop and print the stack
- **Do something like normal level order traversal order. Following are the differences with normal level order traversal**
    1. Instead of printing a node, we push the node to stack
    2. Right subtree is visited before left subtree
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

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node root) 
    {
        // code here
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Stack<Integer> st=new Stack();
        while(!q.isEmpty()){
            Node n=q.remove();
            st.push(n.data);
            
            if(n.right!=null) q.add(n.right);
            if(n.left!=null) q.add(n.left);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
} 
```
# [**Reverse Level Order Traversal Leetcode**](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

# Print Given Level Approach :-

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // code here
        int h=getHeight(root);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=h;i>=0;i--){
            List<Integer> subans=new ArrayList<>();
            printGivenLevel(root,i,subans);
            ans.add(subans);
        }
        return ans;
    }
    public void printGivenLevel(TreeNode root, int level, List<Integer> subans){
        if(root==null) return;
        if(level==0){ subans.add(root.val); return;}
        printGivenLevel(root.left,level-1,subans);
        printGivenLevel(root.right,level-1,subans);
    }
    private int getHeight(TreeNode root){
        if(root==null) return -1;
        if(root.left==null && root.right==null) return 0;
        
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
```
# Same as Normal Level order approach
- Just insert your subans at first in ans always.
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new LinkedList<>(); // in LL inserting at first is O(1)
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
            ans.add(0,subans);
        }
        return ans;
    }
}
```