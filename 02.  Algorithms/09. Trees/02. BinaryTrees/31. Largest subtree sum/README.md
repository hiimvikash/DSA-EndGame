# [**Maximum Sum SubTree**](#)
## Given a binary tree, task is to find subtree with maximum sum in tree.

```java
class Solution{
int maxi=Integer.MIN_VALUE;
    public int getMaxSumSubTree(TreeNode root){
        if(root==null) return 0;

        int currSum = getMaxSumSubTree(root.left) + root.val + getMaxSumSubTree(root.right);

        maxi = Math.max(currSum,maxi);

        return currSum;
    }
}
```