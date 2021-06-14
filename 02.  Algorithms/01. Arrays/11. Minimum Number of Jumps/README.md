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
}    
```

# **Approach 2- By Ladder** TC=O(n)
```java
class Solution{
    static int minJumps(int[] arr){
        // your code here
        if(arr[0]==0) return -1;
        int n=arr.length;
        int maxReach=arr[0]; // this will store the maximum reachable index
        int step=arr[0]; // this will make the lader i.e., no. of steps required to reach MaxReach always
        int jump=1; // we will always need to take at least one jump.
        
        for(int i=1;i<n;i++){
            if(i==n-1) return jump; // whether we have reached the end of the array, in that case we just need to return the jump variable.
            maxReach=Math.max(maxReach,arr[i]+i); // earlier approach we use to find MaxPowerIndex, this is similar.
            step--; // decrement of this signifies how much step we have taken 
            
            if(step==0){ // this means step has completed its steps to reach MaxReach and now its gona be initialize with upcoming maxReach steps. 
                jump++;
                if(i>=maxReach) return -1; // TC like [1 2 1 0 1]  before re-initializing step, we also check whether a step is becoming zero or negative.
                step=maxReach-i; // re-initializing step means we are making lader.here we are storing No. of step left to reach MaxReach from current index i.
            }
        }
        return -1;
    }
}
```

