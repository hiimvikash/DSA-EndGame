# [**Maximum sum of Non-adjacent nodes**](https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1/#)
## Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children or parents in consideration and vice versa.

- [**Video Reference**](https://youtu.be/ZdIrKO7gqok)

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
    static int getMaxSum(Node root)
    {
        // add your code here
        if(root==null) return 0;
        
        if(hm.containsKey(root)) return hm.get(root);
        
        int inc=root.data;
        if(root.left!=null){
            inc+=getMaxSum(root.left.left);
            inc+=getMaxSum(root.left.right);
        }
        if(root.right!=null){
            inc+=getMaxSum(root.right.left);
            inc+=getMaxSum(root.right.right);
        }
        int exc=getMaxSum(root.left)+getMaxSum(root.right);
        
        int ans=Math.max(inc,exc);
        hm.put(root,ans);
        
        return ans;
    }
}
```