```java
    public static void mergeSort(int arr[], int start, int end) {

		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}


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
		
		while(i <= mid) {
			temp[k] = arr[i];
			k++; i++;
		}
		

		// add elements left in the second interval
		
		while(j <= end) {
			temp[k] = arr[j];
			k ++; j++;
		}
		

		// copy temp to original interval
		k=0;
		for(i = start; i <= end; i++) {
			arr[i] = temp[k];k++;
		}
	}
```

## **[Video Reference](https://youtu.be/aDX3MFL0tYs)**
