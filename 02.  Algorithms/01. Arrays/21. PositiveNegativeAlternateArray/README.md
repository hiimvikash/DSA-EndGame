# **[PositiveNegativeAlternateArray](https://www.geeksforgeeks.org/rearrange-array-in-alternating-positive-negative-items-with-o1-extra-space-set-2/)**

## Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa. **Order of elements in output doesn’t matter**. Extra positive or negative elements should be moved to end.

# **My Intution :- TC - O(N) SC - O(1)**

- Segregate -ve elements on left side and +ve elements on right side of array.
- put a pointer **'neg'** on starting of -ve element and a pointer **'posi'** on starting of +ve element.
- In each itteration swap(arr,neg,posi); pos++; neg+=2;

```java
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
```

## **[See My Full Code Here](./AlternatePN.java)**
# Same Q But Here Order Matters TC - O(N) SC - O(N)
![PN 1](https://user-images.githubusercontent.com/71629248/123248471-98cc2300-d505-11eb-8c05-0a450904fe9e.jpg)
![PN 2](https://user-images.githubusercontent.com/71629248/123248525-a84b6c00-d505-11eb-883a-900308b5ad26.jpg)


