# **[Count Inversions ](https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#)**

**TC = O(N Log N) SC = O(N)**

```java
class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr,0,(int)N-1);
    }
    public static long mergeSort(long arr[], int start, int end) {
                long invC=0l;
		if(start < end) {
			int mid = (start + end) / 2;
			invC=mergeSort(arr, start, mid);
			invC+=mergeSort(arr, mid+1, end);
			invC+=merge(arr, start, mid, end);
		}
		return invC;
	}


	private static long merge(long arr[], int start, int mid, int end) {
        long invC=0l;
		// create a temp array
		long temp[] = new long[end - start + 1];

		// crawlers for both intervals and for temp
		int i = start; int j = mid+1; int k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				 i++;
			}
			else {
				temp[k] = arr[j];
				invC+=(mid+1-i); // mid+1 will keep the pointer in the first element of next array.
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
		return invC;
	}
}
```

## **[Video Reference](https://youtu.be/kQ1mJlwW-c0)**
