package arrays;
import java.util.*;


public class AlternatePN {
	public static void main(String[] args) {
		int arr[]= { -25, -6, -18, 33, 39, 42,-69, -68, -39, 46, 52, 55, 55, 64, 71};
		alternatePN(arr,arr.length);
		System.out.println(Arrays.toString(arr));
	}
	static void alternatePN(int arr[],int n) {
		int posi=segregateByDNF(arr,n);
		//put neg=0(starting index of -ve element) and posi will contain starting index of +ve value.
		// increment neg by 2 and posi by 1
		int neg=0;
		while(neg<posi && posi<n && arr[neg]<0) {
			swap(arr,neg,posi);
			posi++;
			neg+=2;
		}
	}
	private static int segregateByDNF(int[] arr, int n) {
		// TODO Auto-generated method stub
		int low=0,mid=0;
		while(mid<n) {
			if(arr[mid]<0) {
				if(low!=mid) swap(arr,low,mid);
				low++;
				mid++;
			}
			else mid++;
		}
		return low; // here we are returning starting index of +ve element.
	}
	private static void swap(int a[],int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	
}
