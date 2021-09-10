# [**Double Helix - Spoj**](https://www.spoj.com/problems/ANARC05B/)
## [**Video Reference**](https://youtu.be/w-6YHcGmSxM)
```java
import java.util.*;
import java.lang.*;
 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		while(true){
			int n1=sc.nextInt();
			if(n1==0) break;
			// Step 1 : Take array Input
			
			int arr1[]=new int[n1];
			for(int i=0;i<n1;i++){
				arr1[i]=sc.nextInt();
			}
			int n2=sc.nextInt();
			int arr2[]=new int[n2];
			for(int i=0;i<n2;i++){
				arr2[i]=sc.nextInt();
			}
			// Step 2 : make req variable
			int ans=0,s1=0,s2=0;
			int i=0,j=0; // crawler for arr1 & arr2
			while(i<n1 && j<n2){
				if(arr1[i]<arr2[j]) s1+=arr1[i++];
				else if(arr2[j]<arr1[i]) s2+=arr2[j++];
				else{
					ans+=Math.max(s1,s2)+arr1[i];
					s1=s2=0;
					i++;j++;
				}
			}
			while(i<n1){
				s1+=arr1[i++];
			}
			while(j<n2){
				s2+=arr2[j++];
			}
			ans+=Math.max(s1,s2);
			System.out.println(ans);
		}
	}
} 
```