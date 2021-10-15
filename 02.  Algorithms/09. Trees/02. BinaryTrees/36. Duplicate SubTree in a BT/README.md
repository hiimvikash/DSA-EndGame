# [**Duplicate subtree in Binary Tree**](https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1#)
- [**Video reference**](https://youtu.be/_j7yb_nWFO8)
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
}
 */

class Solution {
    HashMap<String, Integer> hm=new HashMap<>();
    int dupSub(Node root) {
        // code here
        solve(root);
        for(Integer val : hm.values()){
            if(val>1) return 1;
        }
        return 0;
    }
    String solve(Node root){
        if(root==null) return "$";
        if(root.left==null && root.right==null) return String.valueOf(root.data);
        
        String s=String.valueOf(root.data);
        s = s + solve(root.left);
        s = s + solve(root.right);
        
        hm.put(s,hm.getOrDefault(s,0)+1);
        return s;
    }
}
```