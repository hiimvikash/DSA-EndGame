# [**Sum of nodes on the longest path from root to leaf node**](https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1#)

- [**Video reference**](https://youtu.be/NazCRmhUsPc)
```java
/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    public int sumOfLongRootToLeafPath(Node root)
    {
        return traverse(root)[1];
    }
    private int[] traverse(Node root){
        if(root==null){
            return new int[]{-1,0};
        }
        
        int left[]=traverse(root.left);
        int right[]=traverse(root.right);
        
        int h=0; int s=0;
        if(left[0]==right[0]){
            h=left[0]+1;
            s=Math.max(left[1],right[1])+root.data;
        }
        else{
            h=Math.max(left[0],right[0])+1;
            
            if(h == left[0]+1) s=left[1]+root.data;
            else s=right[1]+root.data;
        }
        
        return new int[]{h,s};
    }
}
```

<hr>
<hr>
<hr>

# DOING THIS IS WRONG :- ☠️
```JAVA
/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        int ans[]=new int[2];
        traverse(root,ans);
        return ans[1];
    }
    private int[] traverse(Node root, int ans[]){
        if(root==null){
            ans[0]=-1; ans[1]=0; return ans;
        }
        int left[]=traverse(root.left,ans);
        int right[]=traverse(root.right,ans);
        
        
        if(left[0]==right[0]){
            ans[0]=left[0]+1;
            ans[1]=Math.max(left[1],right[1])+root.data;
        }
        else{
            ans[0]=Math.max(left[0],right[0])+1;
            
            if(ans[0] == left[0]+1) ans[1]=left[1]+root.data;
            else if(ans[0] == right[0]+1) ans[1]=right[1]+root.data;
        }
        
        return ans;
    }
}
```