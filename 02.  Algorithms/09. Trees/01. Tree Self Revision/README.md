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