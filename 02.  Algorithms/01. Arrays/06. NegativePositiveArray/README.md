# Given an array which consists of only -ve and +ve numbers, Sort the array without using any sorting algo.

## **Input:** {-12, 11, -13, -5, 6, -7, 5, -3, -6}

## **Output:** {-12, -13, -5, -7, -3, -6, 11, 6, 5}

**Note:** Order of elements is not important here.

# Approach 1: **Dutch National Flag Algorithm** TC is O(N) and SC is O(1)

- ## Initialise low=0; mid=0;
- ## Now DNF algo states that
  - **[0...low-1] will contain -ve numbers**
  - **[low...n-1] will contain +ve numbers**
- ## Seeing the above condition we build following algo to sort
  - **mid will traverse throughout the array till mid<=high(here n-1).**
  - **case -ve: arr[mid]<0**
    - **swap(mid,low); low++; mid++;**
  - **case +ve: arr[mid]>0**
    - **mid++;**

```java
public static void main(String[] args) {
		int arr[]= {-12, 11, -13, -5, 6, -7, 5, -3, -6};
		int n=arr.length;

		int low=0; int mid=0;
		while(mid<=n-1) {
			if(arr[mid]<0) {
			  if(mid!=low) swap(arr,mid,low);
			  low++;
			  mid++;
			}
			else
				mid++;
		}
		System.out.println(Arrays.toString(arr));
}
```

# **[See My Full Code Here](./NegativePositiveArray.java)**
