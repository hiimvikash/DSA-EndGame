package stacksQueues.queue;
import java.util.*;
public class MyPriorityQueue {
	
	public static void main(String[] args) {
		PriorityQueues<Integer> pq=new PriorityQueues<>(7);
		
		
		pq.add(8);
		pq.add(5);
		pq.add(85);
		pq.add(20);
		pq.add(15);
		pq.add(95);
		pq.add(4);
		
		pq.display();
		System.out.println();
		System.out.println("removed element="+pq.remove());
		System.out.println("peek element="+pq.peek());
		
	}
	

}
class PriorityQueues<T>{
	ArrayList<T> harr;
	int hSize;
	int hCap;
	
	public PriorityQueues(int cap){
		harr=new ArrayList<>();
		hCap=cap;
		hSize=0;
		for(int i=0;i<hCap;i++) {
			harr.add(null);
		}
	}
	public int parent(int i) {
		return (i-1)/2;
	}
	public int left(int i) {
		return (2*i)+1;
	}
	public int right(int i) {
		return (2*i)+2;
	}
	public void display() {
		for(int i=0;i<hSize;i++)
			System.out.print(harr.get(i)+" ");
	}
	public void swap(int currI,int swI) {// currentIndex, swapIndex
		T temp=harr.get(currI);
		harr.set(currI,harr.get(swI));
		harr.set(swI, temp);
	}
	
	
	private boolean isSmaller(T i,T j) {
		Comparable ith=(Comparable)i;
		Comparable jth=(Comparable)j;
		if(ith.compareTo(jth)<0) return true; // thisObj-callingObj
		else return false;
	}
	
	
	//add STARTS
		public void add(T val) {
			if(hSize==hCap) {
				System.out.println("PQ overflow");
				return;
			}
			System.out.println("Value Inserted in Heap");
			hSize++;
			int i=hSize-1;
			harr.add(i,val);
			
			//here checking if currInsertedNode is lesser than parent node -->then SWAP
			while(i!=0 && isSmaller(harr.get(i) , harr.get(parent(i)))) {
				swap(i, parent(i));
				i=parent(i);
			}
		}
	//add ENDS
		
		
	//peek() starts
		public T peek() {
			return harr.get(0);
		}
	//peek() ends	
		
		
	// remove() starts	
		public T remove() {
				if(hSize<=0) {
					System.out.println("Empty PQ");
					return null;
				}
				if(hSize==1) {
					hSize--;
					return harr.get(0);
				}
				T root=harr.get(0);
				harr.set(0, harr.get(hSize-1));
				
				hSize--;
				minHeapify(0);
				return root;
			}
			
			public void minHeapify(int i) {
				int l=left(i);
				int r=right(i);
				int smallest=i;
				
				if(l<hSize && isSmaller(harr.get(l) , harr.get(smallest))) smallest=l;
				if(r<hSize && isSmaller(harr.get(r) , harr.get(smallest))) smallest=r;
				
				if(smallest!=i) {
					swap(i,smallest);
					minHeapify(smallest);
				}
			}
	//remove() ENDS	
}
