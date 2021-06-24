# **[MaxMinAlternateArray](https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1#)**

## Given a sorted array of positive integers. Your task is to rearrange the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.

# **My Intution :- TC - O(N) SC - O(1)**

- ATQ even index will have maximum & odd index will have minimum.
- We will use Injection method.
- Initialize maximumIndex maxI=n-1, minimumIndex minI=0 and INF=arr[n-1]+1 here INF is greater than all the elements in array.
- Itterate a loop from i=0 to n-1
  - When i is even we will INJECT maximum element and decrement maxI.
  - When i is odd we will INJECT minimum element and increment minI.
- Now another loop to modify array with its injected element by dividing each element with INF.

```java
class Solution{

 	public static void rearrangeMaxMin(int arr[], int n){

        // Your code here
        int maxI=n-1, minI=0;
        int INF=arr[n-1]+1;
        // this is called Injection Method
        for(int i=0;i<n;i++){
            if(i%2==0){
                arr[i]+=(arr[maxI]%INF)*INF; // here we are injecting arr[maxI] in even index. %INF to get originalOld element.
                maxI--;
            }
            else{
               arr[i]+=(arr[minI]%INF)*INF; // here we are injecting arr[minI] in odd index. %INF to get originalOld element.
               minI++;
            }
        }
        // here we are modifying our array with injected element.
        for(int i=0;i<n;i++){
            arr[i]=arr[i]/INF; // this will give us newly injected element.
        }
    }

}
```

# **TC - O(N) SC - O(N)**

```java
static int[] rearrangeMaxMin(int arr[],int n){
	int ans[]=new int[n];
	int minI=0,maxI=n-1;

	for(int i=0;i<n;i++){
		if(i%2==0) ans[i]=arr[maxI--];
		else ans[i]=arr[minI++];
	}
	return ans;
}
```
