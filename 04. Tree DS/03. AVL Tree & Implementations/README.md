# **What is Balanced BT ?**

## Binary tree where the difference between the height of left subtree and right subtree **for every node** is not more than k(usually k=1). This difference is called balanced factor. **bf=|height of LST - height of RST|**.

## So for every node **height of LST - height of RST** should be {-1,0,1}.

# **AVL TREE**

## **AVL Tree is a self-balancing BST (i.e.,basically a BST which remains balanced even though you insert or delete values).**

# **Ways of Balancing AVL Tree**

## To maintain the balance in AVL Tree(i.e to be AVL tree always) while inserting and deleting, we perform Rotations. Depending on different imbalance cases, we have 4 basic types of rotations –

- **LEFT LEFT Imbalance/case - RIGHT Rotation**
- **RIGHT RIGHT Imbalance/case - LEFT Rotation**
- **LEFT RIGHT Imbalance/case - LEFT RIGHT Rotation**
- **RIGHT LEFT Imbalance/case - RIGHT LEFT Rotation**

![](https://i.ibb.co/vQLZCmQ/Imbalances.png)

### **[Video Reference](https://youtu.be/_nyt5QYel3Q)**

<HR>

# **INSERTION IN AVL TREE**

## **Step 1 (Optional) : [Theoritical insertion in AVL tree](https://youtu.be/f0BplF93TIA)**

## **Step 2 : [Practical insertion in AVL tree dry run + code](https://youtu.be/otiDcwZbCo4)**

```java
// INSERTION IN AVL TREE STARTS
		public Node insertNodeRECURR(Node r, int key) {

    		// if the root is null, create a new node and return it
            if (r == null)
            	return new Node(key);


            // if the given key is less than the root node,
            // recur for the left subtree
            else if (key < r.data)
            	r.left = insertNodeRECURR(r.left, key);


            // otherwise, recur for the right subtree
            else if(key > r.data)
                r.right = insertNodeRECURR(r.right, key);

            else // key== root.data
            {
            	System.out.println("Dublicate value not allowed");
            	return r;
            }

            // HERE COME'S AVL TREE PART STARTS
            int bf = getBalancedFac(r);
            // Left Case
            if (bf > 1 && key < r.left.data)
              return rightRotate(r);
            // Right Case
            else if(bf < -1 && key > r.right.data)
            	return leftRotate(r);
            // Left-Right Case
            else if(bf > 1 && key > r.left.data)
            {
            	r.left=leftRotate(r.left);
            	return rightRotate(r);
            }
            // Right-Left Case
            else if(bf < -1 && key < r.right.data)
            {
            	r.right=rightRotate(r.right);
            	return leftRotate(r);
            }
            // HERE COME'S AVL TREE PART ENDS


            return r;
    	}
// INSERTION IN AVL TREE ENDS
```

<hr>

# **DELETION IN AVL TREE**

![](https://i.ibb.co/DMJf0TY/deletion-cases-in-AVL-tree.png)

## **Step 1: [Practical Implementation of deletion in AVL TREE](https://youtu.be/3UivJWAFaI4)**

```java
// DELETION IN AVL TREE STARTS
		public Node delete(Node r,int val) {
			if(r==null) return null;
			if(val<r.data) {
				r.left=delete(r.left,val);
			}
			else if(val>r.data) {
				r.right=delete(r.right,val);
			}
			else {
				if(r.left!=null && r.right!=null) {
					int lmax=maxLeft(r.left);
					r.data=lmax;
					r.left=delete(r.left,lmax);
				}
				else if(r.left!=null) {
					return  r.left;
				}
				else if(r.right!=null) {
					return  r.right;
				}
				else {
					return null;
				}
			}

			// HERE COME'S AVL TREE DELETION PART STARTS
				int bf=getBalancedFac(r);
				// bf=2 means deletion from right subtree and now remaining is left imbalance OR L-R imbalance

				/*
				 * bf(r.left)=1 means remaing structure in this is:-
				 		30 bf=2
				 	   /
				 	  20   bf=1
				 	 /
				 	10     bf=0



				 * bf(r.left)=0 means remaing structure in this is:-
				 	   30 bf=2
				 	  /
				 	 20   bf=0
				 	/  \
				   10  25   bf=0 for both
			  */
				if(bf==2 && getBalancedFac(r.left)>=0)
					return rightRotate(r);
				else if(bf==2 && getBalancedFac(r.left)==-1 ) {
					r.left=leftRotate(r.left);
					return rightRotate(r);
				}
				// bf=-2 means deletion from left subtree and now remaining is right imbalance OR R-L imbalance

				/*
				 * bf(r.right)=-1 means remaing structure in this is:-
				 		10 bf=-2
				 		  \
				 		  20 bf=-1
				 		    \
				 		    30 bf=0



				 * bf(r.right)=0 means remaing structure in this is:-
				 	   10  bf=-2
				 		 \
				 		 20 bf=0
				 		/  \
				 	  15    30 bf=0 for both
			  */
				else if(bf==-2 && getBalancedFac(r.right)<=0)
					return leftRotate(r);
				else if(bf==-2 && getBalancedFac(r.right)==1 ) {
					r.right=rightRotate(r.right);
					return leftRotate(r);
				}
			// HERE COME'S AVL TREE DELETION PART ENDS
			return r;
		}

		public static int maxLeft(Node node) {
			if(node.right!=null) {
				return maxLeft(node.right);
			}
			else {
				return node.data;
			}
		}
// DELETION IN AVL TREE ENDS
```

<hr>
<h1 align="center"><b><a href="./AVLTree.java">SEE MY FULL IMPLEMENTED CODE HERE.</a></b></h1>
<br>
<br>

<h1 align="center"><b>THANK YOU</b></h1>
