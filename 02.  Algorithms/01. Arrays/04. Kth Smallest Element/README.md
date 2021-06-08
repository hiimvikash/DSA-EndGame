![Kth](https://user-images.githubusercontent.com/71629248/121235931-00059880-c8b3-11eb-91f4-96fcf6f1c0cc.jpg)

```java
   	public static int quickSort(int arr[],int l, int h, int k) {

		if(k>0 && k <= arr.length) {
			int pivotIndex=partition(arr,l,h);
			if(pivotIndex+1==k)
				return arr[pivotIndex];
			else if(pivotIndex+1>k) // this means kth smallest lies in left part
				return quickSort(arr,l,pivotIndex-1,k);
			else // this means kth smallest lies in right part
				return quickSort(arr,pivotIndex+1,h,k);
		}
		return Integer.MAX_VALUE;
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
```
# **[See My Code Here](./KthSmallest.java)**
