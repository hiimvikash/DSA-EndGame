# [**Left View of BT**](https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1#)
## thought Process : **ANS will be 1st Value  of each level**
```java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      return levelOrder(root);
    }
    private ArrayList<Integer> levelOrder(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelNode=q.size();
            for(int i=0;i<levelNode;i++){
                Node n=q.remove();
                if(i==0) ans.add(n.data);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
        }
        return ans;
    }
}
```