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