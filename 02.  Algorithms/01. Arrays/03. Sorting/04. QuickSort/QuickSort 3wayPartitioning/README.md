# [Quick Sort 3 way partitioning](https://www.baeldung.com/java-sorting-arrays-with-repeated-entries)
## **Performance with Repeated Elements**
Let’s say we have an array A = [4, 4, 4, 4, 4, 4, 4] that has all equal elements.

On partitioning this array with the single-pivot partitioning scheme, we'll get two partitions. The first partition will be empty, while the second partition will have N-1 elements. Further, each subsequent invocation of the partition procedure will reduce the input size by only one. Let's see how it works:
![quicksortworstcase](https://user-images.githubusercontent.com/71629248/132946497-f5eefcb5-b7e2-479d-a77e-9343ad19a872.png)

```java
public static void main (String[] args) {
		int arr[]= {8,3,1,3,4,767,678,-910};
		int n=arr.length;
		quicksort(arr,0,n-1);	
		System.out.println(Arrays.toString(arr));
	}
	public static void quicksort(int[] input, int start, int end) {
	    if (end <= start)
	        return;

	    Partition middlePartition = threeWayPartition(input, start, end);

	    quicksort(input, start, middlePartition.left - 1);
	    quicksort(input, middlePartition.right + 1, end);
	}
	public static Partition threeWayPartition(int arr[], int low, int high) {
		int pivot=arr[low];
		/*
		 * 	  0 to i-1  <pivot
              i to curr-1 =pivot
              curr to k unk
              k+1 to e  >pivot
		 */
		int i=0,curr=0,k=high;
		while(curr<=k) {
			int ch=compare(arr[curr],pivot);
			switch(ch) {
			case -1 : swap(arr,curr,i); i++; curr++; break;
			case 0: curr++; break;
			case 1: swap(arr,curr,k); k--;
			}
		}
		return new Partition(i,k);
	}
	// utility fun()
	private static int compare(int ele, int pivot) {
		if(ele<pivot) return -1;
		if(ele==pivot) return 0;
		return 1;
	}
	private static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


class Partition{
	int left;
	int right;
	public Partition(int l, int r) {
		left=l;
		right=r;
	}
}
```
