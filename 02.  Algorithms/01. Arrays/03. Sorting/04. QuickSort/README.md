```java
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
```

## **[Video Reference](https://youtu.be/UA_Rmjfj4bw)**
