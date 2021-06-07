package justLikeThat;
import java.util.*;


public class QuickSort {
	
	public static void main(String[] args) {
		int arr[]= {900,23,67,12,34,98,0,100};
		int n=arr.length;
		quickSort(arr,0,n-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int arr[],int l, int h) {
		if(l<h) {
			int pivotIndex=partition(arr,l,h);
			quickSort(arr,l,pivotIndex-1);
			quickSort(arr,pivotIndex+1,h);
		}
	}
	
	private static int partition(int arr[],int l, int h) {
		// TODO Auto-generated method stub
		int pivot=arr[l];
		int i=l;
		int j=h;
		while(i<j) {
			while(i<=h && arr[i]<=pivot)i++;
			while(j>=l && arr[j]>pivot)j--;
			if(i<j) { // swap ith and jth
				swap(arr,i,j);
			}
		}
		// swap(j,l)
		swap(arr,j,l);
				
		return j;
	}
	
	// swapping functions
	private static void swap(int arr[],int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
