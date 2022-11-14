# [**Path Sum - III**](https://leetcode.com/problems/path-sum-iii/)
 - Thought Process is : Insert and check
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
    public int pathSum(TreeNode root, int targetSum) {
        int count[]=new int[1];
        getPath(root,targetSum,count, new ArrayList<>());
        return count[0];
    }
    private void getPath(TreeNode root, int ts, int count[], ArrayList<Integer> subans){
        if(root==null) return;
        
        subans.add(root.val);
        long sum=0;
        for(int i=subans.size()-1; i>=0; i--){
            sum+=subans.get(i);
            if(sum==ts) count[0]++;
        }
        getPath(root.left, ts, count, subans);
        getPath(root.right, ts, count, subans);
        
        
        subans.remove(subans.size()-1);

    }
}
```

## OR - Concept of ```Number of SubArray of Sum k```

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
    int cnt=0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> hm=new HashMap<>();
        hm.put(0l,1);
        ps(root,0,hm,targetSum);
        
        return cnt;
    }
    private void ps(TreeNode root, long cs, HashMap<Long, Integer> hm, int ts){
        if(root == null) return;
        
        cs+=root.val;
        cnt+= hm.getOrDefault(cs-ts,0);
        hm.put(cs, hm.getOrDefault(cs,0)+1);
        
        ps(root.left,cs,hm,ts);
        ps(root.right,cs,hm,ts);
        
        hm.put(cs, hm.getOrDefault(cs,1)-1);
        if(hm.get(cs) == 0) hm.remove(cs);
        cs-=root.val;
    }
}
```
