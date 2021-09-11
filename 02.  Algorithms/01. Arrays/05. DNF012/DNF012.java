package arrays;

import java.util.Arrays;

public class DNF012 {

	public static void main(String[] args) {
		int arr[]={0, 2, 1, 2, 0,1,2,0,2};
		int n=arr.length;

		 int i=0; int curr=0; int k=n-1;
	      while(curr<=k){
	          switch(arr[curr]){
	              case 0: swap(arr,i,curr);
	              		  curr++;
	              		  i++;
	              break;
	              case 1: curr++;
	              break;
	              case 2: swap(arr,k,curr);
	              		  k--;
	              break;
	          }
	      }
	      System.out.println(Arrays.toString(arr));
	}
	public static void swap(int a[],int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
    	}

}
