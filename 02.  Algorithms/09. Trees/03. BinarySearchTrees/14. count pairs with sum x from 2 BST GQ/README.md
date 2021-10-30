# [**Brothers From Different Roots**](https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1#)

[**Video Reference**](https://youtu.be/h7uGc48yb14)

## Use HashMap Approach
```java
/**
class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}
*/

class Solution
{
     
    static int cnt=0;
	public static int countPairs(Node root1, Node root2, int x)
	{
		// Code here
		if(root1 == null || root2 == null) return 0;
		HashMap<Integer,Integer> hm=new HashMap<>();
		mapbst2(root2, hm);
		cnt=0;
		traversalCount(root1,x,hm);
		
		return cnt;
	}
	private static void mapbst2(Node r2, HashMap<Integer,Integer> hm){
	    if(r2==null) return;
	    
	    mapbst2(r2.left,hm);
	    hm.put(r2.data,1);
	    mapbst2(r2.right,hm);
	}
	private static void traversalCount(Node r1, int x, HashMap<Integer,Integer> hm){
	    if(r1==null) return;
	    
	    traversalCount(r1.left,x,hm);
	    if(hm.containsKey(x-r1.data)) cnt++;
	    traversalCount(r1.right,x,hm);
	}
}
```
## Use BST Search Approach
```java
/*Structure of the Node of the BST is as
class Node
{
	int data;
	Node left, right;

	Node(int val) {
		data = val;
		left = right = null;
	}
}
*/

class Solution
{
    static int cnt = 0;
	public static int countPairs(Node root1, Node root2, int x)
	{
		// Code here
		if(root1==null || root2==null) return 0;
		cnt=0;
		traverse(root1,root2,x);
		
		return cnt;
	}
	
	private static void traverse(Node r1,Node r2, int x){
	    if(r1==null) return;
	    
	    traverse(r1.left,r2,x);
	    if(found(r2, x-r1.data)) cnt++;
	    traverse(r1.right,r2,x);
	}
	
	private static boolean found(Node root2, int val){
          if(root2==null) return false;
          Node temp=root2;
          while(temp!=null){
            if(temp.data==val) return true;
            else if(val<temp.data)temp=temp.left;
            else temp=temp.right;
          }
          return false;
    }
}
```