package map;
import java.util.*;
public class MyHashMap<K,V> {

	ArrayList<Node<K,V>> buckets;
	int size; // No. of Entries
	int numBuckets; // No.  of Buckets
	
	
	
	//Constructor STARTS
	public MyHashMap() {
		numBuckets=5;
		size=0;
		buckets=new ArrayList<>();
		// here we are making 20 empty buckets
		for(int i=0;i<numBuckets;i++) {
			buckets.add(null);
		}
	}
	//Constructor ENDS
	
	
	
	// temporary function STARTS
		public double loadFactor() { 
			return (double)size/numBuckets;
		}
	// temporary function ENDS
	
	
	
	// Size STARTS
	public int size() {
		return size;
	}
	// Size ENDS
	
	
	
	//Hash Function STARTS
		private int getBucketIndex(K key) {
			int hashcode=key.hashCode();
			return hashcode%numBuckets;
		}
	//Hash Function ENDS
		
		
		
	// Private Function STARTS
		private void rehash() {
			System.out.println("Entries(n): "+size +"  buckets(b): "+numBuckets+"   lf: "+loadFactor()); // temporary line for dry run;
			ArrayList<Node<K,V>> temp=buckets;
			buckets=new ArrayList<>();
			for(int i=0;i<numBuckets*2;i++) {
				buckets.add(null);
			}
			size=0;
			numBuckets*=2;
			for(int i=0;i<temp.size();i++) {
				Node<K,V> curr=temp.get(i);
				while(curr!=null) {
					put(curr.key, curr.value);
					curr=curr.next;
				}
			}
		}
	// Private Function ENDS
	
	
	
	// put() STARTS	
		public void put(K key, V val) {
			int index=getBucketIndex(key);
			Node<K,V> curr=buckets.get(index); // this is a pointer which will traverse 
			//here we are updating value if same key exist
			while(curr!=null) {
				if(curr.key.equals(key)) { // here equals method can be override if you want to use your using your own class object else Wrapper class like INTEGER, DOUBLE..have their own equals()
					curr.value=val; 
					return;
				}
				curr=curr.next;
			}
			// control comes here, means key to be inserted don't exist.
			curr=buckets.get(index); // bringing my pointer back to start 
			Node<K,V> ne = new Node<>(key,val);
			size++;
			ne.next=curr;
			buckets.set(index, ne);
			
			double loadFactor=(double)size/numBuckets;
			if(loadFactor > 0.7) rehash();
		}
	// put() ENDS
		
		
		
	// get() STARTS
		public V get(K key) {
			int index=getBucketIndex(key);
			Node<K,V> curr=buckets.get(index); // this is a pointer which will traverse
			while(curr!=null) {
				if(curr.key.equals(key)) { // here equals method can be override if you want to use your using your own class object else Wrapper class like INTEGER, DOUBLE..have their own equals()
					return curr.value;
				}
				curr=curr.next;
			}
			return null;
		}
	// get() ENDS
		
		
		
	//	containsKey() STARTS
		public boolean containsKey(K key) {
			int index=getBucketIndex(key);
			Node<K,V> curr=buckets.get(index); // this is a pointer which will traverse
			while(curr!=null) {
				if(curr.key.equals(key)) { // here equals method can be override if you want to use your using your own class object else Wrapper class like INTEGER, DOUBLE..have their own equals()
					return true;
				}
				curr=curr.next;
			}
			return false;
		}
	// containsKey() ENDS
	
	
	
	// remove() STARTS
		public V remove(K key) {
			int index=getBucketIndex(key);
			Node<K,V> curr=buckets.get(index); // this is a pointer which will traverse
			Node<K,V> prev=null;
			while(curr!=null) {
				if(curr.key.equals(key)) { // here equals method can be override if you want to use your using your own class object else Wrapper class like INTEGER, DOUBLE..have their own equals()
					if(prev==null) {
						buckets.set(index, curr.next);
					}
					else
						prev.next=curr.next;
					size--;
					return curr.value;
					
				}
				prev=curr;
				curr=curr.next;
			}
			return null;
		}
	// remove() ENDS
	
	
		
	// utility() for DryRun STARTS 
		public static void main(String args[]) {
			MyHashMap<String,Integer> map =new MyHashMap<>();
			for(int i=1;i<=20;i++) {
				map.put("abc"+i, i);
				System.out.println("Entry "+i+" lf="+map.loadFactor());
			}
			System.out.println(map.containsKey("abc5"));
		}
	// utility() for DryRun ENDS	
	
}

class Node<K,V>{
	Node<K,V> next;
	K key;
	V value;
	
	public Node(K key,V val) {
		this.key=key;
		this.value=val;
	}
}
