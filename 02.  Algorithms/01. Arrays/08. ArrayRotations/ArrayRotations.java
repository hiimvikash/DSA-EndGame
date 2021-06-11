package arrays;

import java.util.Arrays;

public class ArrayRotations {
/** -----------------------------LEFT ROTATION STARTS--------------------------------------	
	  0  1  2  3  4  5     0  1  2  3  4  5
	 [1, 2, 3, 4, 5, 6]-->[3, 4, 5, 6, 1, 2]**/
	
	// Method 1- TC=O(n+d) SC=O(d) STARTS
	public static int[] leftRotate1(int arr[],int n,int d) {
		int temp[]=new int[d];
		
		// filling temp[] with arr[0...d-1] 
		for(int i=0;i<d;i++)
			temp[i]=arr[i];
		
		// shifting remainingElement(d to n-1) d steps toward left
		for(int i=d;i<n;i++) {
			arr[i-d]=arr[i];
		}
		
		// filling the vacant back position of arr[] with temp[]
		for(int i=n-d;i<n;i++) {
			arr[i]=temp[i-(n-d)];
		}
		return arr;
	}
	
	
	// Method 2- TC=O(n) SC=O(n) STARTS
	public static int[] leftRotate2(int arr[],int n,int d) {
		int temp[]=new int[n];
		int j=0;
		for(int i=d;i<n;i++) {
			temp[j++]=arr[i];
		}
		for(int i=0;i<d;i++) {
			temp[j++]=arr[i];
		}
		return temp;
	}
	
	
	// Method 3- TC=O(n) SC=O(1) LR 1by1 STARTS
	public static int[] leftRotate1by1(int arr[],int n) {
		int temp=arr[0];
		for(int i=0;i<n-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[n-1]=temp;
		return arr;
	}
		
	/**
	   Let A & B are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. 
	   The idea of the algorithm is : 
	   Reverse A to get ArB, where Ar is reverse of A.
	   Reverse B to get ArBr, where Br is reverse of B.
	   Reverse all to get (ArBr) r = BA.
	   Example : 
	   Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7 
       A = [1, 2] and B = [3, 4, 5, 6, 7] 
 
		Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
		Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
		Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
	**/
	// Method 4- Reversal Algorithm for LR
	public static int[] leftRotate3(int arr[],int n,int d) {
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,n-1);
		reverseArray(arr,0,n-1);
		return arr;
	}
	private static void reverseArray(int[] arr, int s, int e) {
		int temp=0;
		while(s<e) {
			temp=arr[s];
			arr[s]=arr[e];
			arr[e]=temp;
			s++;e--;
		}
	}
/** -----------------------------LEFT ROTATION ENDS--------------------------------------**/
	
/** ----------------------------RIGHT ROTATION STARTS--------------------------------------
                  0  1  2  3  4  5     0  1  2  3  4  5
	         [1, 2, 3, 4, 5, 6]-->[5, 6, 1, 2, 3, 4]**/

	// Method 1- TC=O(n+d) SC=O(d) STARTS
	public static int[] rightRotate1(int arr[],int n,int d) {
		int temp[]=new int[d];
		
		// filling temp[] with arr[n-d...n-1] 
		for(int i=n-d;i<n;i++) {
			temp[i-(n-d)]=arr[i];
		}
		
		// shifting remainingElement(0 to n-d-1) d steps toward right
		for(int i=n-d-1;i>=0;i--) {
			arr[i+d]=arr[i];
		}
		
		// filling the vacant front position of arr[] with temp[]
		for(int i=0;i<d;i++)
			arr[i]=temp[i];
		return arr;
	}
	
	
	// Method 2- TC=O(n) SC=O(n) STARTS
		public static int[] rightRotate2(int arr[],int n,int d) {
			int temp[]=new int[n];
			int j=0;
			for(int i=n-d;i<n;i++) {
				temp[j++]=arr[i];
			}
			for(int i=0;i<n-d;i++) {
				temp[j++]=arr[i];
			}
			return temp;
		}
		
		
	// Method 3- TC=O(n) SC=O(1) RR 1by1 #CyclicRotation STARTS
	public static int[] rightRotate1by1(int arr[],int n) {
		int temp=arr[n-1];
		for(int i=n-2;i>=0;i--) {
			arr[i+1]=arr[i];
		}
		arr[0]=temp;
		return arr;
		
		/** can be done like this also
		 	int temp=arr[n-1];
			for(int i=n-1;i>0;i--) {
				arr[i]=arr[i-1];
			}
			arr[0]=temp;
		**/
	}
/** ----------------------------RIGHT ROTATION ENDS--------------------------------------**/
	public static void main(String[] args) {
		System.out.println("Left Rotations:-");
		System.out.println("LeftRotate1= "+Arrays.toString(leftRotate1(new int[]{1,2,3,4,5,6,7,8},8,4)));
		System.out.println("LeftRotate2= "+Arrays.toString(leftRotate2(new int[]{1,2,3,4,5},5,2)));
		System.out.println("LeftRotate3= "+Arrays.toString(leftRotate3(new int[]{1,2,3,4,5,6},6,2)));
		System.out.println("LeftRotate1by1= "+Arrays.toString(leftRotate1by1(new int[]{1,2,3,4,5},5)));
		
		System.out.println("Right Rotations:-");
		System.out.println("RightRotate1= "+Arrays.toString(rightRotate1(new int[]{1,2,3,4,5,6},6,2)));
		System.out.println("RightRotate2= "+Arrays.toString(rightRotate2(new int[]{1,2,3,4,5},5,2)));
		System.out.println("RightRotate1by1= "+Arrays.toString(rightRotate1by1(new int[]{1,2,3,4,5},5)));
	}

}
