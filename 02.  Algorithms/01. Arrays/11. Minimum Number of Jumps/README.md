# **[Minimum number of jumps](https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#)**

# **Approach 1- By Finding Maximum Power** TC=O(n<sup>2</sup>)

![MinimumJumps](https://user-images.githubusercontent.com/71629248/121813971-2e58ee80-cc8c-11eb-82bf-7dc1d39e7f47.jpg)

```java
class Solution{
    static int minJumps(int[] arr){
        int n=arr.length;
        int jump=0;
        int i=0;
	if(arr[i]==0) return -1;
        while(i<n){
	   // if(arr[i]==0) return -1; this is removed coz of this tcs [1 1 2 0 1 0] ans=4, [1 1 1 0]
           if(arr[i]==1 && i!=n-1){
               jump++;i++;
           }
           else if(i!=n-1){
	       if(arr[i]+i>=n-1){
                   jump++;
                   return jump;
               }
               i=maxIdx(arr,i+1,arr[i]+i);
	       if(i==-1) return -1; // if 0 lies in btw of array and it is not overpass by some previous superPower then it's impossible to reach end of array in such case 0 will fall here. [1 2 1 0 1]
               jump++;
           }
	   else i++; // for Tcs [1 1 1 0]
        }
        return jump;
    }
    static int maxIdx(int arr[],int s,int e){
        int mi=-1;
		int max=-999;
		for(int i=s;i<=e;i++) {
			if(arr[i]>=max)
			{
				max=arr[i];
				mi=i;
			}
		}
		return mi;
    }
```
