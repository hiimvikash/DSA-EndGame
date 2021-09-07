# [**Agrresive Cows**](https://www.spoj.com/problems/AGGRCOW/)

## BS 
## [**Video Reference🔥**](https://youtu.be/wSOfYesTBRk)
```java
import java.util.*;
import java.lang.*;
 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- !=0){
			int n=sc.nextInt();
			int c=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			int ans=-1;
			int low=1,high=arr[n-1]-arr[0];
			while(low<=high){
				int mid=(low+high)/2;
				if(midPossibleAns(mid,arr,c)){
					ans=mid;
					low=mid+1;
				}
				else high=mid-1;
			}
		System.out.println(ans);
		}
	}
	public static boolean midPossibleAns(int mid,int arr[], int c){
		int placedCow=1; int placedInd=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]-arr[placedInd]>=mid){
				// possible hai.
				placedCow++;
				placedInd=i;
			}
            if(placedCow==c) return true;
		}
		return false;
	}
}
```
