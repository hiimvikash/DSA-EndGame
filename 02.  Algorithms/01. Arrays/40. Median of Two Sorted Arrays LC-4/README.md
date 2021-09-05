# **[4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)**
# My Intution : - Merge Sort Technique TC - O(N+M) SC - O(1)
```java
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int m=arr1.length, n=arr2.length;
        int i=0,j=0,count=-1,a=0,b=0;
        while(i < m && j < n) {
		if(arr1[i] <= arr2[j]) {
			count++;
			if(count==((n+m)/2)-1)  a=arr1[i];
			if(count==((n+m)/2)){ b=arr1[i]; break;}
			i++;
		}
		else {
			count++;
			if(count==((n+m)/2)-1)  a=arr2[j];
			if(count==((n+m)/2)){ b=arr2[j]; break;}
			j ++;
		}
			
	}

		// add elements left in the first interval
	if(count!=(n+m)/2){
            while(i < m) {
                count++;
                if(count==((n+m)/2)-1) a=arr1[i];
                if(count==((n+m)/2)){  b=arr1[i]; break;}
                i++;
            }


            // add elements left in the second interval

            while(j < n) {
                count++;
                if(count==((n+m)/2)-1) a=arr2[j];
                if(count==((n+m)/2)){ b=arr2[j]; break;}
                j++;
            }
        }
        
        if((n+m)%2!=0) return b;
        return (a+b)/2.0;
    }
}
```
# My Intution : - Binary Search Technique TC - O(Min(log N1,log N2)) SC - O(1)
```java
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1=arr1.length, n2=arr2.length;
        if(n1==1 && n2==0) return arr1[0]/1.0;
        if(n1==0 && n2==1) return arr2[0]/1.0;
        if(n2<n1) return findMedianSortedArrays(arr2,arr1); // [1,2,3,5,6] [4]
        
        boolean isEven=(n1+n2)%2==0;
        int mid=(n1+n2+1)/2; // no. of element should be divided into
        int low=0;
        int high=n1;
        int partition1=-1, partition2=-1, l1=0,l2=0,r1=0,r2=0; 
        while(low<=high){
            partition1=(low+high)/2;
            partition2=mid-partition1;
           
            l1 = (partition1==0) ? Integer.MIN_VALUE : arr1[partition1-1];
            l2 = (partition2==0) ? Integer.MIN_VALUE : arr2[partition2-1];
            
            r1 = (partition1==n1) ? Integer.MAX_VALUE : arr1[partition1];
            r2 = (partition2==n2) ? Integer.MAX_VALUE : arr2[partition2];
            
            if(l1<=r2 && l2<=r1) break;
            else if(l1>r2) high=partition1-1; //floor
            else if(l2>r1) low=partition1+1; //ceil
        }
        if(isEven) return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
        return Math.max(l2,l1);
        
    }
}
```
## **[Video Reference](https://youtu.be/NTop3VTjmxk)**