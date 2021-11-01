# [**Largest BST**](https://practice.geeksforgeeks.org/problems/largest-bst/1#)

[**Video Reference**](https://youtu.be/CP3LhPA03Vc)

```java
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        Vals ans = lbs(root);
        return ans.size;
    }
    static Vals lbs(Node root){
        if(root==null) return new Vals(Integer.MAX_VALUE,Integer.MIN_VALUE,true,null,0);
        
        Vals left = lbs(root.left);
        Vals right = lbs(root.right);
        
        Vals ans=new Vals(0,0,false,null,0);
        
        if(left.isbst && right.isbst && root.data > left.max && root.data < right.min) ans.isbst=true;
        
        ans.min = Math.min(root.data, Math.min(left.min, right.min));
        ans.max = Math.max(root.data, Math.max(left.max, right.max));
        
        if(ans.isbst){
            ans.size = left.size + right.size + 1;
            ans.mnode = root;
        }
        else if(left.size > right.size){
            ans.size = left.size;
            ans.mnode = left.mnode;
        }
        else{
            ans.size = right.size;
            ans.mnode = right.mnode;
        }
        
        return ans;
    }
    
}
class Vals{
    int min; int max; boolean isbst; Node mnode; int size;
    public Vals(int mini, int maxi, boolean is, Node n, int sz){
        min=mini;
        max=maxi;
        isbst=is;
        mnode=n;
        size=sz;
    }
}
```