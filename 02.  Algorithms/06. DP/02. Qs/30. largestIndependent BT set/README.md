# [**Largest Independent Set Problem**](https://www.geeksforgeeks.org/largest-independent-set-problem-dp-26/)

## **Similar to Maximum sum of Non-Adjacent nodes**

## Using memonization
 ```java
/*class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    static HashMap<Node,Integer> hm=new HashMap<>();
    static int lindS(Node root)
    {
        // add your code here
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        
        if(hm.containsKey(root)) return hm.get(root);
        
        int inc=1;
        if(root.left!=null){
            inc+ lindS(root.left.left) lindS(root.left.right);
        }
        if(root.right!=null){
            inc+ lindS(root.right.left) lindS(root.right.right);
        }
        int exc = lindS(root.left)+lindS(root.right);
        
        int ans=Math.max(inc,exc);
        hm.put(root,ans);
        
        return ans;
    }
}
```
