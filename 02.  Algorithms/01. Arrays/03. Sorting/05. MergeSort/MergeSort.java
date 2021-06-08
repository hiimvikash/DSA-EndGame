package justLikeThat;
import java.util.*;
public class MergeSort {

	public static void main(String[] args) {
		int arr[]= {900,23,67,0,100,-1,-2,1000,-8};
		int n=arr.length;
			mergeSort(arr,0,n-1);
			System.out.println(Arrays.toString(arr));
		}
	
	// arr is an array of integer type
	// start and end are the starting and ending index of current interval of Arr
	public static void mergeSort(int arr[], int start, int end) {

		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
		
	// example of merge sort in Java
	// merge function take two intervals
	// one from start to mid
	// second from mid+1, to end
	// and merge them in sorted order

	private static void merge(int arr[], int start, int mid, int end) {

		// create a temp array
		int temp[] = new int[end - start + 1];

		// crawlers for both intervals and for temp
		int i = start; int j = mid+1;int k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp 
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				 i++;
			}
			else {
				temp[k] = arr[j];
				 j ++;
			}
			k++;
		}

		// add elements left in the first interval
		if(j>end) {
			while(i <= mid) {
				temp[k] = arr[i];
				k++; i++;
			}
		}

		// add elements left in the second interval 
		else if(i>mid) {
			while(j <= end) {
				temp[k] = arr[j];
				k ++; j++;
			}
		}

		// copy temp to original interval
		k=0;
		for(i = start; i <= end; i++) {
			arr[i] = temp[k];k++;
		}
	}

}
	