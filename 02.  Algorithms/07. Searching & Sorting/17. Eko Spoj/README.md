# [**Eko Spoj**](https://www.spoj.com/problems/EKO/)

## BS 
## [**Video Reference🔥**](https://youtu.be/JAfJssvFgDI)
```java
import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int arr[]=new int[n];
		int low=0;int high=0;
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
			high=Math.max(high,arr[i]); // only 1 tree to be cut
		}
		
		int ans=0;
		while(low<=high){
			int mid=(low+high)/2;
			if(woodCutted(arr,mid,m)){
				ans=mid;
				low=mid+1;
			}
			else { high=mid-1;}
		}
		System.out.println(ans);
	}
	static boolean woodCutted(int arr[], int bladsize, int m){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>bladsize){
				sum+=(arr[i]-bladsize);
			}
		}
		return sum>=m;
	}
}
```