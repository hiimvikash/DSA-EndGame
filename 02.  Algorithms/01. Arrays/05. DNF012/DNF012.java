package arrays;

import java.util.Arrays;

public class DNF012 {

	public static void main(String[] args) {
		int arr[]={0, 2, 1, 2, 0,1,2,0,2};
		int n=arr.length;
		
		 int low=0;int mid=0;int high=n-1;
	      while(mid<=high){
	          switch(arr[mid]){
	              case 0: swap(arr,low,mid);
	              		  mid++;
	              		  low++;
	              break;
	              case 1: mid++;
	              break;
	              case 2: swap(arr,high,mid);
	              		  high--;
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
