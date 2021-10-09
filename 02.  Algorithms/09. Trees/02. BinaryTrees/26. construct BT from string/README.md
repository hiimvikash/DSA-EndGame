# [**Construct BT from string**](https://www.lintcode.com/problem/880/)
- [**Video reference**](https://youtu.be/BH_btihSwVM)
```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param s: a string
     * @return: a root of this tree
     */
    private int start=0;
    public TreeNode str2tree(String s) {
        // write your code here
        int l=s.length();
        if(start>=l) return null;

        // 1. -ve dealing.
        boolean neg=false;
        if(s.charAt(start)=='-'){ neg=true; start++; }

        // 2. number dealing
        int num=0;
        while(start<l && Character.isDigit(s.charAt(start))){
            int digit=Character.getNumericValue(s.charAt(start));
            num=num*10+digit;
            start++;
        }
        if(neg) num=-num;
        
        // 3. Make a node of value num
        TreeNode root=new TreeNode(num);
        if(start>=l) return root;

        // 4. Deal with brackets

        if(start<l && s.charAt(start)=='('){
            start++;
            root.left=str2tree(s);
        }

        if(start<l && s.charAt(start)==')'){
            start++;
            return root;
        }

        if(start<l && s.charAt(start)=='('){
            start++;
            root.right=str2tree(s);
        }

        if(start<l && s.charAt(start)==')'){
            start++;
            return root;
        }

        return root;
    }
}
```