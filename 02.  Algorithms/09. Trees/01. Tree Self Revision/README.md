# [**I'm Revising from this folder**](../../../01.%20DataStructures/04.%20Tree%20DS)

# 1. Insertion In BST Itterative
```java
//1.--| Insertion in BST(itterative approach) STARTS
		public Node insertNodeITTE(Node root, int val) {
			
			if(root==null) {
				return root=new Node(val);
			}
			Node temp=root;
			while(true) {
				if(temp.data==val) {
					System.out.println("Already Exist"); return root;
				}
				// this means node will be added in left side
				if(val<temp.data) {
					if(temp.left==null) {
						temp.left=new Node(val); return root;
					}
					temp=temp.left;
				}
				else {
					if(temp.right==null) {
						temp.right=new Node(val); return root;
					}
					temp=temp.right;
				}
			}
		}
	//1.--| Insertion in BST(itterative approach) ENDS
```
# 2. Insertion In BST Recursive
```java
      public Node insertNodeRecur(Node root, int val) {
        if(root==null){
          return root=new Node(val);
        }
        if(root.data==val) return root;

        if(root.data < val)
          root.left=insertNodeRecur(root.left,val);
        else root.right=insertNodeRecur(root.right,val);  
        return root;
      }
```
# 3. Level Order Insertion in BT
```java
    public Node insertLevelorder(Node root, Node val){
      if(root==null) return root=new Node(val);
      Queue<Node> q=new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()){
        Node n=q.remove();
        if(n.left==null){
          n.left=new Node(val);
          return root;
        }
        else if(n.right==null){
          n.right=new Node(val);
          return root;
        }
        else{
          q.add(n.left);
          q.add(n.right);
        }
      }
    }
```
# 4. Height of BT
```java
public int getHeight(Node root){
  if(root==null) return -1;
  if(root.left==null && root.right==null) return 0;
  return Math.max(getHeight(root.left),getHeight(root.right))+1;
}
```
# isBalanced ?
```java
boolean isBalanced=true;
public int getHeight(Node root){
  if(root==null) return -1;
  if(root.left==null && root.right==null) return 0;
  int lh=getHeight(root.left);
  int rh=getHeight(root.right);
  if(Math.abs(lh-rh)>1) isBalanced=false;
  return Math.max(lh,rh)+1;
}
```
# 5. Sum of BT
```java
public int sumOfBt(Node root){
  if(root==null) return 0;
  if(root.left==null && root.right==null) return root.data;
  return sumOfBt(root.left)+sumOfBt(root.right)+root.data;
}
```
# 6. Number of Nodes in BT
```java
public int countNodes(Node root){
  if(root==null) return 0;
  if(root.left==null && root.right==null) return 1;
  return countNodes(root.left)+countNodes(root.right)+1;
}
```
# 7. Maximum value in BT
```java
public int maxValueBt(Node root){
  if(root==null) return -999999;
  if(root.left==null && root.right==null) return root.data;
  return Math.max(root.data,Math.max(maxValueBt(root.left),maxValueBt(root.right)));
}
```
# 8. Level Order Traversal in BT
```java
public void printLevelOrderBFS(Node root){
			  if(root==null){ System.out.println("Empty BT"); return; }
			  if(root.left==null && root.right==null){ System.out.println(root.data); return;}

			  Queue<Node> q=new LinkedList<>();
			  q.add(root);

			  while(!q.isEmpty()){
			    Node n=q.remove();
			    System.out.print(n.data+ " ");
			    if(n.left !=null) q.add(n.left);
			    if(n.right !=null) q.add(n.right);
			  }
}
```
# 9. Sum at Given Level
```java
// considering level<=height always.
public int sumAtGivenLevel(Node root, int level){
  //  think of the smallest possible input's answer
  if(root==null) return 0;
  if(level==0) return root.data;
  return sumAtGivenLevel(root.left,level-1)+sumAtGivenLevel(root.right,level-1);
}
```
**Note :** if(root.left==null && root.right==null) return root.data; is not a valid base case because this can become true for any level.
# 10. Inorder PreOrder PostOrder Traversal
## Inorder Traversal L+R
```java
// L+R
public void inorder(Node root){
  if(root==null) return;
  inorder(root.left);
  System.out.print(root.data+ " ");
  inorder(root.right);
}
```
## Preorder Traversal +LR
```java
// +LR
public void preorder(Node root){
  if(root==null) return;
  System.out.print(root.data+ " ");
  preorder(root.left);
  preorder(root.right);
}
```
## Postorder Traversal LR+
```java
// LR+
public void postorder(Node root){
  if(root==null) return;
  postorder(root.left);
  postorder(root.right);
  System.out.print(root.data+ " ");
}
```
# 11. All Path from root to leaf Node
```java
static Stack<Integer> st=new Stack();
public static void rootToleaf(Node root) {
			if(root==null) return;
			if(root.left==null && root.right==null) {
				st.push(root.data);
				System.out.println(String.valueOf(st)); return;
			}
			st.push(root.data);
			rootToleaf(root.left); // option 1
			st.pop(); // removing value of option 1
			rootToleaf(root.right); // option 2
			st.pop(); // removing value of option 2 and moving my euler back to root
	}
```
# 12. Search in BST
## recursive
```java
public static boolean search(Node root, int val){
  if(root==null) return false;
  if(root.data==val) return true;
  else if(val<root.data) return search(root.left,val);
  else return search(root.right,val);
}
```
## Itterative
```java
public static boolean search(Node root, int val){
  if(root==null) return false;
  Node temp=root;
  while(temp!=null){
    if(temp.data==val) return true;
    else if(val<temp.data)temp=temp.left;
    else temp=temp.right;
  }
  return false;
}
```
# 13. Diameter of BT
```java
public int diameter(Node root){
  if(root==null || (root.left==null && root.right==null)) return 0;
  int ld = diameter(root.left);
  int rd = diameter(root.right);
  option1 = getHeight(root.left)+getHeight(root.right)+2; 
  return Math.max(option1, Math.max(ld,rd));
}
```
## Make a class diapair
```java
class DiaPair{
  int ht; int dia;
  public DiaPair(int h,int d){
    ht=h;
    dia=d;
  }
}
public static DiaPair diameter(Node root){
  if(root==null){
    return new DiaPair(-1,0);
  }
  DiaPair lp=diameter(root.left);
  DiaPair rp=diameter(root.right);

  DiaPair mp=new DiaPair();
  mp.ht=Math.max(lp.ht,rp.ht)+1;

  int option1=lp.ht+rp.ht+2;
  mp.dia=Math.max(option1,Math.max(lp.dia,rp.dia));
  return mp;
}
```