![reverse Array](https://user-images.githubusercontent.com/71629248/120749193-bb2fd980-c521-11eb-9b2b-c6635f5568a7.jpg)
## Reverse Array using recurssion
```java
public static void main(String[] args) {
		int arr[]= {1,3,5,6,7,12,15};
		int n=arr.length;
		reverseArr(arr,0,n-1);
		System.out.println(Arrays.toString(arr));
}
	static void reverseArr(int arr[],int s,int e) {
		if(s>=e) return;
		int temp=arr[s];
		arr[s]=arr[e];
		arr[e]=temp;
		reverseArr(arr,++s,--e);
	}
```
