# Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo.

# Approach 1: **Counting method** TC is O(2N) & SC is O(1)

- ## Make 3 variable named as count0, count1, count2 and store the count of 0's, 1's and 2's in each variable respectively.
- ## Now store 0 in index ranging from **0 to count0-1**
- ## Now store 1 in index ranging from **count0 to count1-1**
- ## Now store 2 in index ranging from **count1 to n-1**

# Approach 2: **Dutch National Flag Algorithm** TC is O(N) and SC is O(1)

- ## Initialise low=0; mid=0; high=n-1;
- ## Now DNF algo states that
  - **[0...low-1] will contain 0**
  - **[high+1...n] will contain 2**
- ## Seeing the above condition we build following algo to sort
  - **mid will traverse throughout the array till mid<=high.**
  - **case 0: arr[mid]=0**
    - **swap(mid,low); low++; mid++;**
  - **case 1: arr[mid]=1**
    - **mid++;**
  - **case 2: arr[mid]=2**
    - **swap(mid,high); high--;**

```java
public static void main(String[] args) {
		int arr[]={0, 2, 1, 2, 0,1,2,0,2};
		int n=arr.length;

		 int low=0; int mid=0; int high=n-1;
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
```

# **[See My Full Code Here](./DNF012.java)**
