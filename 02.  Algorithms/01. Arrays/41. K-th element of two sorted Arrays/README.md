# **[K-th element of two sorted Arrays](https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1#)**
# My Intution : - Merge Sort Technique TC - O(N+M) SC - O(1)
```java
class Solution {
    public int kthElement( int arr1[], int arr2[], int m, int n, int k) {
        int i=0,j=0,count=0;
        while(i < m && j < n) {
    		if(arr1[i] <= arr2[j]) {
    			count++;
    			if(count==k) return arr1[i];
    			i++;
    		}
    		else {
    			count++;
    			if(count==k) return arr2[j];
    			j ++;
    		}
		}

		// add elements left in the first interval

        while(i < m) {
            count++;
            if(count==k) return arr1[i];
            i++;
        }


        // add elements left in the second interval

        while(j < n) {
            count++;
            if(count==k) return arr2[j];
            j++;
        }
        
        
        return -1;
    }
}
```
# My Intution : - Binary Search Technique TC - O(Min(log N1,log N2)) SC - O(1)
```java
class Solution {
    public int kthElement( int arr1[], int arr2[], int n1, int n2, int k) {
        
        if(n2<n1) return kthElement(arr2,arr1,n2,n1,k); 
        
        
        int mid=k;
/**  if(mid>n2) then you cant have 0 element from arr1 because maximum element arr2  can contibute is n2 rest(mid-n2) will be contributed by arr1. *forLow
         if(mid<n1) then MAXIMUM element that can be picked from arr1 is mid. *forHigh
         n1 = 4, n2 = 6;
         k = 3 *highCase
         k = 8 *lowCase
    **/
        int low = Math.max(0,mid-n2), high = Math.min(mid,n1);
        int partition1=-1, partition2=-1, l1=0,l2=0,r1=0,r2=0; 
        while(low<=high){
            partition1=(low+high)/2;
            partition2=mid-partition1;
                        
            if(partition1==0) l1=Integer.MIN_VALUE;
            else l1=arr1[partition1-1];
            
            if(partition2==0) l2=Integer.MIN_VALUE;
            else l2=arr2[partition2-1];
                        
            if(partition1==n1) r1=Integer.MAX_VALUE;
            else r1=arr1[partition1];
            
            if(partition2==n2) r2=Integer.MAX_VALUE;
            else r2=arr2[partition2];
            
            if(l1<=r2 && l2<=r1) return Math.max(l1,l2);
            
            else if(l1>r2) high=partition1-1; // left half
            else if(l2>r1) low=partition1+1; // right half
        }
        return -1;
    }
}

```
## **[Video Reference](https://youtu.be/nv7F4PiLUzo)**