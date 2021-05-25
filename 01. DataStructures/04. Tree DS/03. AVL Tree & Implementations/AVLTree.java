package treeDS;

import java.util.Scanner;

public class AVLTree {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AVL_T at=new AVL_T();
		boolean flag=true;int val=0;
		while(flag) {
			System.out.println();
			System.out.println("1.--| INSERTION IN AVL TREE");
			System.out.println("2.--| PRINT 2D");
			System.out.println("3.--| isBalanced ?");
			System.out.println("4.--| DELETION in AVL TREE");
			System.out.println("5.--| Exit");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter value");
				val=sc.nextInt();
				at.root=at.insertNodeRECURR(at.root, val);
			break;
			
			case 2: 
				at.print2D(at.root, 5);
			break;
			case 3: 
				at.Height(at.root);
				System.out.println(at.isBal);
			break;
			case 4: System.out.println("Enter value to be deleted");
			val=sc.nextInt();
			at.root=at.delete(at.root, val);
			break;
			case 5: flag=false;
			break;
			default: System.out.println("Invalid choice");
			}
		}

	}

}

class AVL_T{
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int val) {
			data=val;
			left=right=null;
		}
	}
	
	Node root;
	public AVL_T() {
		root=null;
	}
	
// SOME PREREQUISITE FUNCTIONS STARTS {
	
	
	//Print 2D STARTS (from BinaryTree.java)
			public void print2D(Node r,int space) {
				
				if (r ==null) // Base case  1
				   return;
				print2D(r.right,space+5);
				System.out.println();
				
				for(int i=0;i<space;i++)
					System.out.print(" ");
				
				System.out.println(r.data);
				print2D(r.left,space+5);
			}
	//Print 2D ENDS (from BinaryTree.java)
	
	//Height of tree / isBalanced STARTS (from BinaryTree.java)
			boolean isBal=true;//only to find balanced BT, ignore while finding height.
			public int Height(Node r) {
				if(r==null) return -1;
				else {
					int lh=Height(r.left);
					int rh=Height(r.right);
					
					// ignore THIS, while thinking about height of BT {
					if(Math.abs(lh-rh)>1)
						isBal=false;
					// }
					return Math.max(lh, rh)+1;
				}
			}
	//Height of tree / isBalanced ENDS (from BinaryTree.java)
	
	// finding Balanced Factor of particular node STARTS
		public int getBalancedFac(Node r) {
			if(r==null) return -1;
			else
				return Height(r.left)-Height(r.right);
		}
	// finding Balanced Factor of particular node ENDS
		
	// right rotation STARTS
		public Node rightRotate(Node r) {
			Node nr=r.left;//new root
			Node T2=nr.right;
			//right rotation begins
			nr.right=r;
			r.left=T2;
			
			return nr;
		}
	// right rotation ENDS
		
	//left rotations STARTS
		public Node leftRotate(Node r) {
			Node nr=r.right;
			Node T2=nr.left;
			//left rotation begins
			nr.left=r;
			r.right=T2;
			
			return nr;
		}
	//left rotations ENDS
		
		
// } SOME PREREQUISITE FUNCTIONS ENDS
		

		

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
			
}