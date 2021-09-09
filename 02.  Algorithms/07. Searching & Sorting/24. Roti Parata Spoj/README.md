# [**Roti - Parata Spoj**](https://www.spoj.com/problems/PRATA/)
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
			int p=sc.nextInt();
			int l=sc.nextInt();
			int cook[]=new int[l];
			int maxR=0;
			for(int i=0;i<l;i++){
				cook[i]=sc.nextInt();
				maxR=Math.max(cook[i],maxR);
			}
			int low=0;
			int high=maxR*((p*(p+1))/2);
			int ans=0;
			while(low<=high){
				int mid=(low+high)/2;
				if(isMidPossibleAns(mid,cook,p)){
					ans=mid;
					high=mid-1;
				}
				else low=mid+1;
			}
			System.out.println(ans);
		}
	}
	static boolean isMidPossibleAns(int mid, int cook[], int pReq){
		int pMade=0; 
		for(int i=0;i<cook.length;i++){
			int time=cook[i];int j=2;
			while(time<=mid){
				pMade++;
				time+=cook[i]*j;
				j++;
			}
			if(pMade>=pReq) return true;
		}
		return false;
	}
}
```
