![CamScanner 06-03-2021 23 31 35_2](https://user-images.githubusercontent.com/71629248/120780516-d6acdb80-c545-11eb-944c-d640fd0b8f14.jpg)
![CamScanner 06-03-2021 23 31 35_3](https://user-images.githubusercontent.com/71629248/120779917-335bc680-c545-11eb-8c3b-245d22e4af84.jpg)
## **[Practice Link](https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1#)**
```java
	public static void main(String[] args) {
		//            0  1  2    3  4    5  6
		int arr[]= {-900,23,67,1200,34,9800,0};
		int n=arr.length;
		int minI,minJ,maxI,maxJ=0;
		minI=minJ=999999;
		maxI=maxJ=-999999;
		int mid=0;
		if(n%2==0) mid=n/2; else mid=n/2+1;
		for(int i=0,j=mid ; i<mid ; i++) {
			maxI=Math.max(maxI, arr[i]);
			maxJ=Math.max(maxJ, arr[j]);
			
			minI=Math.min(minI, arr[i]);
			minJ=Math.min(minJ, arr[j]);
			if(j<n-1)
				j++;
			
		}
		System.out.println("Maximum Element in an array= "+Math.max(maxI, maxJ));
		System.out.println("Minimum Element in an array= "+Math.min(minI, minJ));
	}
```
# **[See my code here](./MinMax.java)**
