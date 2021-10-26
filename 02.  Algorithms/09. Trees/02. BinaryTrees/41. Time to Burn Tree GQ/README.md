# [**Time To Burn Tree**](https://www.codingninjas.com/codestudio/problems/time-to-burn-tree_630563)
- [**Video Reference**](https://youtu.be/2r5wLmQfD6g)
```java
/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/
import java.util.*;
public class Solution
{
    static HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> phm = new HashMap<>();
    static BinaryTreeNode<Integer> target=null;
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
    	makeParentHM(root,start);
        int dis=0;
        HashMap<BinaryTreeNode<Integer>, Boolean> vis=new HashMap<>();
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
        
        q.add(target);
        vis.put(target,true);
        while(!q.isEmpty()){
            int size=q.size();
            int f=0;
            for(int i=0; i<size; i++){
                BinaryTreeNode<Integer> n=q.remove();
                
                // check parent left right
                BinaryTreeNode<Integer> p=null;
                if(phm.containsKey(n)) p=phm.get(n);
                if(p!=null && vis.get(p)==null){
                    f=1;
                    q.add(p);
                    vis.put(p,true);
                }
                if(n.left!=null && vis.get(n.left)==null){ f=1; q.add(n.left); vis.put(n.left,true); }
                if(n.right!=null && vis.get(n.right)==null){ f=1; q.add(n.right); vis.put(n.right,true);}
            }
            if(f==1)
            	dis+=1;
        }
    return dis;
    }
    private static void makeParentHM(BinaryTreeNode<Integer> root, int start){
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> n=q.remove();
            
            if(n.data==start) target=n; // finding reference of the node
            if(n.left!=null){
                q.add(n.left);
                phm.put(n.left,n);
            }
            if(n.right!=null){
                q.add(n.right);
                phm.put(n.right,n);
            }
        }
    }
}
```
