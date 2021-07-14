package treeDS;
import java.util.*;
import java.math.*;
public class MinHeap {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Heap Capacity OR UnSorted ArraySize( only if choose HeapSort ) ");
		int hCap=sc.nextInt();
		Min_Heap hp=new Min_Heap(hCap);
		boolean flag=true; int valu=0;
		
		while(flag) {
			System.out.println();
			System.out.println("1. Insertion in Heap");
			System.out.println("2. Display Heap");
			System.out.println("3. Height of Heap Tree");
			System.out.println("4. Current Heap Size");
			System.out.println("5. minExtract()");
			System.out.println("6. deleteKey()");
			System.out.println("7. Heap Sort");
			System.out.println("8. Exit");
			System.out.println("Enter Your Choice");
			int ch=sc.nextInt();
			switch(ch) {
			case 1: System.out.println("Enter value");
			valu=sc.nextInt();
			hp.minInsert(valu);
			break;
			case 2: hp.display();
			break;
			case 3: System.out.println("Height of Heap Tree - "+((int)Math.ceil(Math.log(hp.hSize + 1)/Math.log(2)) - 1));
			break;
			case 4: System.out.println(hp.hSize);
			break;
			case 5: System.out.println(hp.minExtract());
			break;
			case 6: System.out.println("Enter key to be deleted");
			valu=sc.nextInt();
			hp.minDeleteKey(valu);
			break;
			case 7: hp.hSize=hp.hCap;
			System.out.println("Enter elements in unsorted array");
			for(int i=0;i<hp.hCap;i++) {
				hp.hArr[i]=sc.nextInt();
			}
			hp.heapSort(hp.hArr);
			break;
			case 8:
				flag=false;
			break;
			default:
				System.out.println("Invalid choice");
			}
			
		}

	}

}

class Min_Heap{
	int hArr[];
	int hCap;
	int hSize;
	
	public Min_Heap(int cap) {
		hCap=cap;
		hSize=0;
		hArr=new int[hCap];
	}
	private int parent(int i) {
		return (i-1)/2;
	}
	private int left(int i) {
		return (2*i)+1;
	}
	private int right(int i) {
		return (2*i)+2;
	}
	private void swap(int currI,int swI) {// currentIndex, swapIndex
		int temp=hArr[currI];
		hArr[currI]=hArr[swI];
		hArr[swI]=temp;
	}
	public void display() {
		for(int i=0;i<hSize;i++)
			System.out.print(hArr[i]+" ");
	}
	
	//minInsert STARTS
	public void minInsert(int val) {
		if(hSize==hCap) {
			System.out.println("Heap overflow");
			return;
		}
		System.out.println("Value Inserted in Heap");
		hSize++;
		int i=hSize-1;
		hArr[i]=val;
		
		//here checking if currInsertedNode is lesser than parent node -->then SWAP
		while(i!=0 && hArr[i] < hArr[parent(i)]) {
			swap(i, parent(i));
			i=parent(i);
		}
	}
	//minInsert ENDS
	
	
	//minExtract STARTS
	public int minExtract() {
		if(hSize<=0) {
			System.out.println("Empty heap");
			return -99999;
		}
		if(hSize==1) {
			hSize--;
			return hArr[0];
		}
		int root=hArr[0];
		hArr[0]=hArr[hSize-1];
		hSize--;
		minHeapify(0);
		return root;
	}
	
	private void minHeapify(int i) {
		int l=left(i);
		int r=right(i);
		int smallest=i;
		
		if(l<hSize && hArr[l]<hArr[smallest]) smallest=l;
		if(r<hSize && hArr[r]<hArr[smallest]) smallest=r;
		
		if(smallest!=i) {
			swap(i,smallest);
			minHeapify(smallest);
		}
	}
	//minExtract ENDS
	
	// minDeleteKey operation STARTS
	public void minDeleteKey(int i) {
		if(i>=hSize) {
			System.out.println("Enter valid key"); return;
		}
		decreaseKey(i,-9999);
		minExtract();
	}
	//this () will set the value in deletingIndex with minimum value than will keep on swaping that deletingIndex value with its parents untill it reaches root.
	private void decreaseKey(int i, int minVal){
		hArr[i]=minVal;
		while( i!=0 && hArr[i] < hArr[parent(i)] ) {
			swap(i, parent(i));
			i=parent(i);
		}
		
	}
	// minDeleteKey operation ENDS
	
	
	//heap sort STARTS
	public void heapSort(int unsortedArr[]) {
		System.out.println("Unsorted Array -"+Arrays.toString(unsortedArr));
		
		//this will convert array into minheap array from bottom to top
		for(int i=(unsortedArr.length/2)-1; i>=0;i--) {
			minHeapify(i);
		}
		
		//actual heapsort start
		int sortedArr[]=new int[unsortedArr.length];
		for(int i=0;i<sortedArr.length;i++) {
			sortedArr[i]=minExtract();
		}
		System.out.println("Sorted Array -"+Arrays.toString(sortedArr));
	}
	//heap sort ENDS
}
