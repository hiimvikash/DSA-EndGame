# [**Assembly Line Scheduling**](https://www.geeksforgeeks.org/assembly-line-scheduling-dp-34/)

arr is main array, ext is extra criss cross time, st is starting time, et is ending time.
```java
static int als(int arr[][], int ext[][], int st[], int et[]){
	    int m=arr[0].length;
	    int dp[][]=new int [2][m];
	    
	    dp[0][m-1]=et[0]+arr[0][m-1];
	    dp[1][m-1]=et[1]+arr[1][m-1];
	    
	    for(j=m-2; j>=0; j--){
	        dp[0][j]=Math.min(arr[0][j]+dp[0][j+1], arr[0][j]+ext[0][j+1]+dp[1][j+1]);
	        dp[1][j]=Math.min(arr[1][j]+dp[1][j+1, arr[1][j]+ext[1][j+1]+dp[0][j+1]);
	    }
	    
	    return Math.min(dp[0][0]+st[0], dp[1][0]+st[1]);
	}
```
## [**Video reference**](https://youtu.be/1_SRfUUTXEc)